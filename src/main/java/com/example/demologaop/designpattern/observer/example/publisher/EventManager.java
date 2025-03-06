package com.example.demologaop.designpattern.observer.example.publisher;

import com.example.demologaop.designpattern.observer.example.listeners.EventListener;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基础发布类，包含订阅管理代码和通知方法
 */
public class EventManager {
    // 存储订阅者集合
    Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventManager(String... operations) {
        for(String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    // 通知订阅者
    public void notify(String eventType, File file) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.update(eventType, file);
        }
    }
}
