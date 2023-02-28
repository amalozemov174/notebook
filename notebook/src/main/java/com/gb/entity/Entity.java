package com.gb.entity;

import com.gb.model.Note;

import java.util.List;

public interface Entity {

    public List<Note> getAllNotes();
    public List<Note> getNote(Integer id);
    public void addNote(Note note);
    public void deleteNote(Integer id);
    public void updateNote(Integer id, String title, String body);
    public void setNotes(List<Note> notes);

}
