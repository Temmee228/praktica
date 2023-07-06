package com.example.demo.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService<T> {
     T save (T t);
     void delete (Long id);
     Page<T> getAll (Pageable pageable);
     T update (T t, Long id);
}
