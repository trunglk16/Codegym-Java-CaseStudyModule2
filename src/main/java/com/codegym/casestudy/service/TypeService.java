package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Type;

public interface TypeService {
    Iterable<Type> findAll();

    Type findByid(Integer id);

    void save(Type type);

    void remove(Integer id);
}
