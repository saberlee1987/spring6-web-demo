package com.saber.spring6webserverdemo.services.impl;

import com.saber.spring6webserverdemo.model.command.AuthorCommand;
import com.saber.spring6webserverdemo.model.query.Author;
import com.saber.spring6webserverdemo.repositories.AuthorCommandRepository;
import com.saber.spring6webserverdemo.repositories.AuthorQueryRepository;
import com.saber.spring6webserverdemo.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorCommandRepository authorCommandRepository;
    @Autowired
    private AuthorQueryRepository authorQueryRepository;

    @Override
    public AuthorCommand save(AuthorCommand entity) {
        return authorCommandRepository.save(entity);
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorQueryRepository.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return authorQueryRepository.findAll();
    }
}
