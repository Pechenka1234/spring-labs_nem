package com.example.crudapp.service;

import com.example.crudapp.entity.Book;
import com.example.crudapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private Environment env;

    private boolean isProd() {
        return env.getActiveProfiles().length > 0 && "prod".equals(env.getActiveProfiles()[0]);
    }

    public Book create(Book book) {
        if (!isProd()) throw new RuntimeException("Доступ заборонено в dev-режимі");
        return repository.save(book);
    }

    public List<Book> getAll() {
        return repository.findAll();
    }

    public Book getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Book update(Long id, Book updatedBook) {
        if (!isProd()) throw new RuntimeException("Доступ заборонено в dev-режимі");
        if (repository.existsById(id)) {
            updatedBook.setId(id);
            return repository.save(updatedBook);
        }
        return null;
    }

    public void delete(Long id) {
        if (!isProd()) throw new RuntimeException("Доступ заборонено в dev-режимі");
        repository.deleteById(id);
    }
}