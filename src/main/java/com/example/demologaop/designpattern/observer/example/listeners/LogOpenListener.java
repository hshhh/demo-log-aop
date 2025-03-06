package com.example.demologaop.designpattern.observer.example.listeners;

import java.io.File;

/**
 * 收到通知后在日志记录一条消息
 */
public class LogOpenListener implements EventListener{
    private File log;

    public LogOpenListener(String fileName) {
        this.log = new File(fileName);
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Save to log "
                + log
                + ": Someone has performed "
                + eventType
                + " operation with following file "
                + file.getName());
    }
}
