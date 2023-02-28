package com.gb.view;

import com.gb.commands.Command;
import com.gb.entity.Entity;
import com.gb.entity.InMemoryStorage;
import com.gb.model.Note;
import com.gb.services.CommandServices;
import com.gb.services.IOSevices;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class View {

    private String pathToNotes = "";
    private CommandServices commandServices;
    private Scanner scanner;
    private Entity entity;
    private Boolean save = true;
    private IOSevices ioSevicesNotes;

    public View(){
        commandServices = new CommandServices();
        scanner = new Scanner(System.in);
        entity = new InMemoryStorage();
    }

    public void startApp() throws IOException, ClassNotFoundException {
        getPathToNotes();
        while (true){
            getAllCommands();
            chooseCommand();
        }
    }

    public void getPathToNotes() throws IOException {
        System.out.println("Введите путь до файла с заметками: ");
        pathToNotes = this.scanner.next();
        File file = new File(pathToNotes);
        if(!file.exists()){
            System.out.println("Файл не существует. Создать файл(Yes/No)");
            String answer = this.scanner.next();
            if(answer.equals("Yes")){
                try{
                    file.createNewFile();
                }
                catch (IOException e){
                    System.out.println("Не удалось создать файл.");
                    System.out.println("Сохранить заметки не будет возможности");
                    save = false;
                }
            }
            else {
                System.out.println("Сохранить заметки не будет возможности");
                save = false;
            }
        }
        if(save){
            ioSevicesNotes = new IOSevices(pathToNotes);
        }

    }

    public void getAllCommands(){
        System.out.println("Список комманд: ");
        String res = "";
        for (Command command : commandServices.getAllCommands()){
            if(!save){
                if(command.getName().equals("save") || command.getName().equals("read")){

                }
                else {
                    res += command.getName() + " - " + command.getDescription() + "\n";
                }
            }
            else {
                res += command.getName() + " - " + command.getDescription() + "\n";
            }
        }
        System.out.println(res);
    }

    public void chooseCommand() throws IOException, ClassNotFoundException {
        System.out.println("Выберите команду: ");
        String commandString = this.scanner.next();
        for (Command command : commandServices.getAllCommands()){
            if(commandString.equals(command.getName())){
                command.execute(this);
            }
        }
    }

    public Scanner getScanner(){
        return this.scanner;
    }

    public void addNote(Note note) {
        this.entity.addNote(note);
    }


    public String getAllNotes() {
        String res = "";
        for(Note note : entity.getAllNotes()){
            res += note.toString();
        }
        return res;
    }

    public void deleteNote(Integer idDelete) {
        entity.deleteNote(idDelete);
    }

    public void updateNote(Integer id, String title, String body) {
        entity.updateNote(id, title, body);
    }

    public String getNoteById(Integer id) {
        String note = entity.getNote(id).get(0).toString();
        return note;
    }

    public void reaNotes() throws IOException {
        entity.setNotes(ioSevicesNotes.readNotes());
    }

    public void saveNotes() throws IOException {
        ioSevicesNotes.writeNotes(this.entity.getAllNotes());
    }
}
