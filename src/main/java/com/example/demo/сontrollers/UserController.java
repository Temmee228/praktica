package com.example.demo.сontrollers;


import com.example.demo.service.UserServicelmpl;
import com.example.demo.model.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;


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




}

