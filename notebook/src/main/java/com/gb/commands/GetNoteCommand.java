package com.gb.commands;

import com.gb.view.View;

import java.io.IOException;

public class GetNoteCommand extends Command{

    private final String description = "Просмотреть заметкe по id";
    private final String name = "getNote";

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
        System.out.println("Введите id заметки: ");
        Integer id = Integer.parseInt(view.getScanner().next());
        System.out.println(view.getNoteById(id));
    }
}
