package com.saber.spring6webserverdemo.services.impl;

import com.saber.spring6webserverdemo.model.query.Book;
import com.saber.spring6webserverdemo.repositories.command.BookCommandRepository;
import com.saber.spring6webserverdemo.repositories.query.BookQueryRepository;
import com.saber.spring6webserverdemo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookQueryRepository bookQueryRepository;
    @Autowired
    private BookCommandRepository bookCommandRepository;
    @Override
    public Book save(Book entity) {
        return bookCommandRepository.save(entity);
    }
    @Override
    public Optional<Book> findById(Long id) {
        return bookQueryRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookQueryRepository.findAll();
    }
}
