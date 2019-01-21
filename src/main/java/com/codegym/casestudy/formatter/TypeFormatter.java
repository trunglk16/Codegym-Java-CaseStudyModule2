package com.codegym.casestudy.formatter;

import com.codegym.casestudy.model.Note;
import com.codegym.casestudy.model.Type;
import com.codegym.casestudy.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class TypeFormatter implements Formatter<Type> {
    @Autowired
    private TypeService typeService;
    @Autowired
    public void TypeService(TypeService typeService) {
        this.typeService = typeService;
    }


    @Override
    public Type parse(String text, Locale locale) throws ParseException {
        return typeService.findByid(Integer.parseInt(text));
    }

    @Override
    public String print(Type object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}

