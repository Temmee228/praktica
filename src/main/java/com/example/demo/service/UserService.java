package com.example.demo.service;

import com.example.demo.model.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService<T> {
     T save (T t);
     void delete (Long id);
     Page<T> getAll (Pageable pageable);
     T update (T t, Long id);

}
