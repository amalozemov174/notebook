package com.gb.utils;

import com.gb.model.Note;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotesReader {

    private BufferedReader bufferedReader;

    public NotesReader(String path) throws FileNotFoundException {
        bufferedReader = new BufferedReader(new java.io.FileReader(path));
    }

    public List<Note> readNotes() throws IOException {
        List<Note> notes = new ArrayList<>();
        while(this.bufferedReader.ready()){
            String tmpHuman = bufferedReader.readLine();
            String[] noteParams = tmpHuman.split(";");
            Date date = new Date(Long.valueOf(noteParams[3]));
            notes.add(new Note(Integer.parseInt(noteParams[0]), noteParams[1], noteParams[2], date));
        }
        return notes;
    }
}
