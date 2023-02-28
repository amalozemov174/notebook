package com.gb.utils;

import com.gb.model.Note;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class NotesWriter {

    BufferedWriter bufferedWriter;

    public NotesWriter(String path) throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter(path, true));
    }

    public void writeNotes(List<Note> notes) throws IOException {
        for (Note note : notes) {
            String write = note.getId() + ";" + note.getTitle() + ";" + note.getBody() + ";" + note.getDate().getTime() + "\n";
            bufferedWriter.append(write);
        }
        bufferedWriter.flush();
    }

}
