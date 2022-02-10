package com.example.aircompanymanagementsystem.service;

import java.util.List;

public interface CustomService<T> {
    T add(T t);

    T get(Long id);

    List<T> getAll();

    void delete(Long id);
}
