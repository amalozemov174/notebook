package com.gb.commands;

import com.gb.model.Note;
import com.gb.view.View;

import java.io.IOException;

public class UpdateNoteCommand extends Command {
    private final String description = "Обновить заметку";
    private final String name = "update";

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
        System.out.println("Введите id для заметки: ");
        Integer id = Integer.parseInt(view.getScanner().next());
        System.out.println("Введите новые параметры для заметки: ");
        System.out.println("Введите заголовок: ");
        String title = view.getScanner().next();
        System.out.println("Введите описание заметки: ");
        String body = view.getScanner().next();
        view.updateNote(id, title, body);
    }
}
