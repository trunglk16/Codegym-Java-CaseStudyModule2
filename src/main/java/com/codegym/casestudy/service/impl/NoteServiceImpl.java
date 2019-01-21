package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.model.Note;
import com.codegym.casestudy.repository.NoteRepository;
import com.codegym.casestudy.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
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
   public Note findById(int id) {
        return noteRepository.findById(id).get();
    }

    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void remove(int id) {
        noteRepository.deleteById(id);
    }
}
