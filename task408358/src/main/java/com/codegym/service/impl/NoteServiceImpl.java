package com.codegym.service.impl;

import com.codegym.model.Note;
import com.codegym.model.TypeNote;
import com.codegym.repository.NoteRepository;
import com.codegym.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;


    @Override
    public Page<Note> findAll(Pageable pageable) {
        return noteRepository.findAll(pageable);
    }

    @Override
    public Iterable<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note findById(Long id) {
        return noteRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        noteRepository.delete(id);
    }

    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }

    @Override
    public Page<Note> findAllByTypeNote(TypeNote typeNote, Pageable pageable) {
        return noteRepository.findAllByTypeNote(typeNote,pageable);
    }


    @Override
    public Page<Note> findAllByTitleContaining(String title, Pageable pageable) {
        return noteRepository.findAllByTitleContaining(title,pageable);
    }

    @Override
    public Iterable<Note> findAllByTypeNote(TypeNote typeNote) {
        return noteRepository.findAllByTypeNote(typeNote);
    }

    @Override
    public Page<Note> findAllByTypeNoteAndTitleContaining(TypeNote typeNote, String title, Pageable pageable) {
        return noteRepository.findAllByTypeNoteAndTitleContaining(typeNote,title,pageable);
    }


}