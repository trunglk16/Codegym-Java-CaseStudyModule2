package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface NoteService  {

    Page<Note> findAll(Pageable pageable);
    Note findById(int id) ;

    void remove(int id);

    void save(Note note);

    Page<Note> findAllByTitleContainingOrContentContaining (String string,String text, Pageable pageable);
}
