package ru.academits.voropaeva.hello_world_servlet.listeners;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;

public class RequestListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("Запрос пришел");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("Запрос обработан");
    }
}