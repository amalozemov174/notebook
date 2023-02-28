package com.gb.commands;

import com.gb.view.View;

import java.io.IOException;

public class ExitCommand extends Command {

    private final String description = "Выйти из программы";
    private final String name = "exit";

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
        System.exit(0);
    }
}
