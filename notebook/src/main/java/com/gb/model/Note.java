package com.gb.model;

import java.util.Date;
import java.util.Objects;

public class Note {

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Date getDate() {
        return date;
    }

    private static Integer idCount = 0;
    private Integer id;
    private String title;
    private String body;
    private Date date;

    private static Integer generateId(){
        return idCount++;
    }

    public Note(){
        id = generateId();
        date = new Date(System.currentTimeMillis());
    }

    public Note(String title, String body){
        id = generateId();
        date = new Date(System.currentTimeMillis());
        this.title = title;
        this.body = body;
    }

    public Note(Integer id, String title, String body, Date date) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", date=" + date +
                "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(id, note.id) && Objects.equals(title, note.title) && Objects.equals(body, note.body) && Objects.equals(date, note.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, body, date);
    }
}
