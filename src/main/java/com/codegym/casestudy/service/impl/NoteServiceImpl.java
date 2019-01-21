package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.model.Note;
import com.codegym.casestudy.repository.NoteRepository;
import com.codegym.casestudy.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public NoteServiceImpl() {
    }

    @Override
    public Page<Note> findAll(Pageable pageable) {
        return noteRepository.findAll(pageable);
    }

    @Override
    public Optional<Note> findById(int id) {
        return noteRepository.findById(id);
    }

    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void remove(Integer id) {
        noteRepository.deleteById(id);
    }
}