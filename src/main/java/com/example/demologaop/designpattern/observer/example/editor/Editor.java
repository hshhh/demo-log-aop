package com.example.demologaop.designpattern.observer.example.editor;

import com.example.demologaop.designpattern.observer.example.publisher.EventManager;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * 具体发布者包含一些订阅者感兴趣的实际业务逻辑，
 */
public class Editor {
    // 持有基类发布者
    public EventManager events;
    private File file;

    public Editor() {
        this.events = new EventManager("open", "save");
    }

    // 业务逻辑的方法可以讲变化通知订阅者
    public void openFile(String filePath) {
        this.file = new File(filePath);
        events.notify("open", file);
    }

    public void saveFile() throws Exception {
        if (this.file != null) {
            events.notify("save", file);
        } else {
            throw new FileNotFoundException("请先打开一个文件！");
        }
    }
}
