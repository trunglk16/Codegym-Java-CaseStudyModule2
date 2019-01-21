package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Type;

public interface TypeService {
    Iterable<Type> findAll();

    Type findByid(int id);

    void save(Type type);

    void remove(int id);
}
