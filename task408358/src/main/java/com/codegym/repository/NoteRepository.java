package com.codegym.repository;

import com.codegym.model.Note;
import com.codegym.model.TypeNote;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NoteRepository extends PagingAndSortingRepository<Note,Long> {
    Page<Note> findAllByTypeNote(TypeNote typeNote,Pageable pageable);
    Page<Note> findAllByTitleContaining(String title, Pageable pageable);
    Iterable<Note> findAllByTypeNote(TypeNote typeNote);
    Page<Note> findAllByTypeNoteAndTitleContaining(TypeNote typeNote, String title,Pageable pageable);
}
