package com.example.demologaop.designpattern.observer.example;

import com.example.demologaop.designpattern.observer.example.editor.Editor;
import com.example.demologaop.designpattern.observer.example.listeners.EmailNotificationListener;
import com.example.demologaop.designpattern.observer.example.listeners.LogOpenListener;

public class Demo {

    public static void main(String[] args) {
        Editor editor = new Editor();
        LogOpenListener logOpenListener = new LogOpenListener("/path/to/log/file.txt");
        EmailNotificationListener emailNotificationListener = new EmailNotificationListener("admin@example.com");
        editor.events.subscribe("open",
                logOpenListener);
        editor.events.subscribe("save",
                logOpenListener);
        editor.events.subscribe("open",
                emailNotificationListener);
        editor.events.subscribe("save",
                emailNotificationListener);

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
