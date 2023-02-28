package com.gb.commands;

import com.gb.view.View;

import java.io.IOException;

public class DeleteNoteCommand extends Command {

    private final String description = "Удалить заметку";
    private final String name = "delete";

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
        System.out.println("Введите id заметки для удаления: ");
        Integer idDelete = Integer.parseInt(view.getScanner().next());
        view.deleteNote(idDelete);
    }
}
