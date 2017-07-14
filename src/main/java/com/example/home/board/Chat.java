package com.example.home.board;

/**
 * Created by home on 2017-07-07.
 */

public class Chat {

    public String title;
    public String content;
    public String date;
    public String pass;

    public Chat() {}

    public Chat(String title, String content, String date, String pass){
        this.title = title;
        this.content = content;
        this.date = date;
        this.pass = pass;
    }

    public Chat(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
