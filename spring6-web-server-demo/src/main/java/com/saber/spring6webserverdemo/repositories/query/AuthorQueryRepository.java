package com.saber.spring6webserverdemo.repositories.query;

import com.saber.spring6webserverdemo.model.command.AuthorCommand;
import com.saber.spring6webserverdemo.model.query.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorQueryRepository {
    Optional<Author> findById(Long id);
     List<Author> findAll();

}
