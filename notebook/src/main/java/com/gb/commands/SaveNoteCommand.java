package com.gb.commands;

import com.gb.view.View;

import java.io.IOException;

public class SaveNoteCommand extends Command{
    private final String description = "Сохранить все заметки";
    private final String name = "save";

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute(View view) throws IOException, ClassNotFoundException {
        view.saveNotes();
    }
}
