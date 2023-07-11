package com.example.demo.service;


import com.example.demo.model.Role;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServicelmpl implements UserService<UserModel>, UserDetailsService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;

    public UserServicelmpl(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
    }


    @Override
    public UserModel save(UserModel userModel) {
        return userRepository.save(userModel);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Page<UserModel> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public UserModel update(UserModel userModel, Long id) {
        UserModel userModelUp = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Ошибка"));
        userModelUp.setCity(userModel.getCity());
        userModelUp.setGrade(userModel.getGrade());
        userModelUp.setMail(userModel.getMail());
        userModelUp.setName(userModel.getName());
        userModelUp.setNumber(userModel.getNumber());
        userModelUp.setPassword(userModel.getPassword());
        userModelUp.setPatronymic(userModel.getPatronymic());
        userModelUp.setSchool(userModel.getSchool());
        userModelUp.setSurname(userModel.getSurname());
        return userRepository.save(userModelUp);

    }



    public List<UserModel> searchByName(String name) {
        return userRepository.findByNameContaining(name);
    }

    public List<UserModel> searchByGrade(String grade) {
        return userRepository.findByGrade(grade);
    }

    public List<UserModel> searchByCity(String city) {
        return userRepository.findByCity(city);
    }

    public List<UserModel> searchByName(String name, String surname, String patronymic) {
        return userRepository.findByName(name, surname, patronymic);
    }

    public List<UserModel> searchByName2(String name, String surname) {
        return userRepository.findByName2(name, surname);
    }

    public void banUser(String username, String banReason) {
        Optional<UserModel> optionalUser = Optional.ofNullable(userRepository.findByUsername(username));
        if (optionalUser.isPresent()) {
            UserModel user = optionalUser.get();
            Role role = user.getRole();
            if (role == Role.SCHOOLBOY || role == Role.TEACHER) {
                user.setBanned(true);
                user.setBanReason(banReason);
                userRepository.save(user);
            } else {
                throw new IllegalArgumentException("Только пользователи с ролью SCHOOLBOY и TEACHER могут быть забанены.");
            }
        } else {
            throw new IllegalArgumentException("Пользователь не найден.");
        }
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public UserModel registerUser(String username, String password) {
        UserModel user = new UserModel();
        user.setUsername(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        return userRepository.save(user);
    }

}
