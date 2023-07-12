package com.example.demo.сontrollers;


import com.example.demo.service.UserServicelmpl;
import com.example.demo.model.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("/users")
public
class UserController {

    private final UserServicelmpl userServicelmpl;
    public UserController(UserServicelmpl userServicelmpl) {
        this.userServicelmpl = userServicelmpl;
    }

    @GetMapping("/all")
    public Page<UserModel> all(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return userServicelmpl.getAll(pageable);
    }

    @DeleteMapping("/delete/{id}")
    public String del(@PathVariable Long id) {
        userServicelmpl.delete(id);
        return "Успешно";
    }

    @PostMapping("/add")
    public UserModel add(@RequestBody UserModel userModel){
        return userServicelmpl.save(userModel);
    }

    @PutMapping("/up/{id}")
    public UserModel up(@PathVariable Long id,  @RequestBody UserModel userModel){
        return userServicelmpl.update(userModel, id);
    }


    @GetMapping("/name/{name}")
    public List<UserModel> searchUsersByName(@PathVariable String name) {
        return userServicelmpl.searchByName(name);
    }

    @GetMapping("/grade/{grade}")
    public List<UserModel> searchByGrade(@PathVariable String grade) {
        return userServicelmpl.searchByGrade(grade);
    }

    @GetMapping("/city/{city}")
    public List<UserModel> searchByCity(@PathVariable String city) {
        return userServicelmpl.searchByCity(city);
    }


    @PostMapping("/ban/{username}")
    public String banUser(@PathVariable("username") String username, @RequestBody String banReason) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        boolean hasSchoolboyOrTeacherRole = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(role -> role.equals("ROLE_ADMIN"));
        if (hasSchoolboyOrTeacherRole) {
            userServicelmpl.banUser(username, banReason);
            return "Пользователь забанен успешно с причиной: " + banReason;
        } else {
            return "Только пользователь с ролью ADMIN может использовать эту функцию.";
        }
    }



}

