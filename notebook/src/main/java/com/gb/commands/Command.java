package com.gb.commands;

import com.gb.view.View;

import java.io.IOException;

public abstract class Command {

    public abstract String getDescription();

    public abstract String getName();

    public abstract void execute(View view) throws IOException, ClassNotFoundException;

}
