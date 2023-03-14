package com.saber.spring6webserverdemo.repositories.query.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.saber.spring6webserverdemo.model.query.Author;
import com.saber.spring6webserverdemo.model.query.QAuthor;
import com.saber.spring6webserverdemo.repositories.query.AuthorQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.saber.spring6webserverdemo.model.query.QAuthor.author;

@Repository
public class AuthorQueryRepositoryImpl implements AuthorQueryRepository {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;


    @Override
    public Optional<Author> findById(Long id) {
        Author authorResponse = jpaQueryFactory.selectFrom(author)
                .where(QAuthor.author.id.eq(id))
                .fetchOne();
        if (authorResponse != null) {
            return Optional.of(authorResponse);
        }
        return Optional.empty();
    }

    @Override
    public List<Author> findAll() {
        return jpaQueryFactory.selectFrom(author)
                .fetch();
    }
}
