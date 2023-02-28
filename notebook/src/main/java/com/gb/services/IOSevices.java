package com.gb.services;

import com.gb.model.Note;
import com.gb.utils.NotesReader;
import com.gb.utils.NotesWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class IOSevices {
    private NotesReader notesReader;
    private NotesWriter notesWriter;

    public IOSevices(String path) throws IOException {
        notesReader = new NotesReader(path);
        notesWriter = new NotesWriter(path);
    }

    public void writeNotes(List<Note> notes) throws IOException {
        notesWriter.writeNotes(notes);
    }

    public List<Note> readNotes() throws IOException {
        return notesReader.readNotes();
    }
}
