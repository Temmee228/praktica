package com.example.demo.service;


import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServicelmpl implements UserService<UserModel>, UserDetailsService {

    private final UserRepository userRepository;

    public UserServicelmpl(UserRepository userRepository) {
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


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
