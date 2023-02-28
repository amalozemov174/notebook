package com.gb.commands;

import com.gb.view.View;

import java.io.IOException;

public class GetAllNotesCommand extends Command {
    private final String description = "Просмотреть все заметки";
    private final String name = "getAll";

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
        System.out.println(view.getAllNotes());
    }
}
