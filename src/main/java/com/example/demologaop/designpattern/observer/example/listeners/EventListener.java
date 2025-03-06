package com.example.demologaop.designpattern.observer.example.listeners;

import java.io.File;

/**
 * 观察者通用接口
 */
public interface EventListener {

    void update(String eventType, File file);
}
