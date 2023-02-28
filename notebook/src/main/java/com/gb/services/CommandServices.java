package com.gb.services;

import com.gb.commands.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandServices {

    private List<Command> commands;

    public CommandServices(){
        commands = new ArrayList<>();
        commands.add(new AddNoteCommand());
        commands.add(new DeleteNoteCommand());
        commands.add(new GetAllNotesCommand());
        commands.add(new ReadNoteCommand());
        commands.add(new SaveNoteCommand());
        commands.add(new UpdateNoteCommand());
        commands.add(new GetNoteCommand());
        commands.add(new ExitCommand());
    }

    public List<Command> getAllCommands(){
        return this.commands;
    }

}
