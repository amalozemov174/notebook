package com.gb.commands;

import com.gb.view.View;

import java.io.IOException;

public class ReadNoteCommand extends Command{

    private final String description = "Загрузить заметки";
    private final String name = "read";

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
        view.reaNotes();
    }
}
