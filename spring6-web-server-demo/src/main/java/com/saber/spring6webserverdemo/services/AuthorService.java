package com.saber.spring6webserverdemo.services;

import com.saber.spring6webserverdemo.model.command.AuthorCommand;
import com.saber.spring6webserverdemo.model.query.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    AuthorCommand save(AuthorCommand entity);
    Optional<Author> findById(Long id);
    List<Author> findAll();
}
