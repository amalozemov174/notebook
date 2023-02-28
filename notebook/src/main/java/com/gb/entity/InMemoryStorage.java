package com.gb.entity;

import com.gb.model.Note;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryStorage implements Entity {

    private List<Note> notes;

    public InMemoryStorage(){
        this.notes = new ArrayList<>();
    }

    @Override
    public List<Note> getAllNotes() {
        return this.notes;
    }

    @Override
    public List<Note> getNote(Integer id) {
        return this.notes.stream().filter(i -> i.getId().equals(id)).collect(Collectors.toList());
    }

    @Override
    public void addNote(Note note) {
        this.notes.add(note);
    }

    @Override
    public void deleteNote(Integer id) {
        this.notes.removeIf(i -> i.getId().equals(id));
    }

    @Override
    public void updateNote(Integer id, String title, String body) {
        for(Note nt : notes){
            if (nt.getId().equals(id)){
                if(!title.equals("") || title.equals(null)){
                    nt.setTitle(title);
                }
                if(!body.equals("") || body.equals(null)){
                    nt.setBody(body);
                }
            }
        }

    }

    @Override
    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
