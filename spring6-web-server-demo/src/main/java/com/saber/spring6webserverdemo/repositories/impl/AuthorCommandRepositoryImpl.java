package com.saber.spring6webserverdemo.repositories.impl;

import com.querydsl.sql.SQLQueryFactory;
import com.saber.spring6webserverdemo.model.command.AuthorCommand;
import com.saber.spring6webserverdemo.model.command.public_.QAuthor;
import com.saber.spring6webserverdemo.repositories.AuthorCommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AuthorCommandRepositoryImpl implements AuthorCommandRepository {
    public static final QAuthor authorCmd = new QAuthor("AUTHOR");
    @Autowired
    private SQLQueryFactory sqlQueryFactory;


    @Override
    public AuthorCommand save(AuthorCommand entity) {

        Long id =sqlQueryFactory.insert(authorCmd)
                .populate(entity)
//                .execute();
                .executeWithKey(authorCmd.id);

        entity.setId(id);
        return entity;
    }

}
