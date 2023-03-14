package com.saber.spring6webserverdemo.services;

import com.saber.spring6webserverdemo.model.query.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Author save(Author entity);
    Optional<Author> findById(Long id);
    List<Author> findAll();
}
