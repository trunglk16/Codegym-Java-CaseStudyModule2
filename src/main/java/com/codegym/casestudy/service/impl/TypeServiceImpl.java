package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.model.Type;
import com.codegym.casestudy.repository.TypeRepository;
import com.codegym.casestudy.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeRepository typeRepository;

    @Override
    public Iterable<Type> findAll() {
        return typeRepository.findAll();
    }

    @Override
    public Type findByid(int id) {
        return typeRepository.findById(id).get();
    }

    @Override
    public void save(Type type) {
        typeRepository.save(type);
    }

    @Override
    public void remove(int id) {
        typeRepository.deleteById(id);
    }
}
