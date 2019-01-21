package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.Note;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NoteRepository extends PagingAndSortingRepository<Note,Integer> {
    Iterable<Note> findAllByType(Note note);
}
