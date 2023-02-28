package com.gb.commands;

import com.gb.model.Note;
import com.gb.view.View;
import java.io.IOException;

public class AddNoteCommand extends Command{

    private final String description = "Добавить заметку";
    private final String name = "add";

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
        System.out.println("Введите параметры заметки: ");
        System.out.println("Введите заголовок: ");
        String title = view.getScanner().next();
        System.out.println("Введите описание заметки: ");
        String body = view.getScanner().next();
        view.addNote(new Note(title, body));
    }
}
