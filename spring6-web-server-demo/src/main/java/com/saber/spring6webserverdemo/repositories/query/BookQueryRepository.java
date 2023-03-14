package com.saber.spring6webserverdemo.repositories.query;

import com.saber.spring6webserverdemo.model.query.Book;

import java.util.List;
import java.util.Optional;

public interface BookQueryRepository {
     Optional<Book> findById(Long id);
     List<Book> findAll();

}