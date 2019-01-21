package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NoteRepository extends PagingAndSortingRepository<Note,Integer> {
    Page<Note> findAllByTitleContainingOrContentContaining(String string, String text, Pageable pageable);
}
