package com.saber.spring6webserverdemo.repositories.query.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.saber.spring6webserverdemo.model.query.Book;
import com.saber.spring6webserverdemo.model.query.QBook;
import com.saber.spring6webserverdemo.repositories.query.BookQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

import static com.saber.spring6webserverdemo.model.query.QBook.book;
@Repository
@Transactional
public class BookQueryRepositoryImpl implements BookQueryRepository {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<Book> findById(Long id) {
        Book book = jpaQueryFactory.selectFrom(QBook.book).where(QBook.book.id.eq(id))
                .fetchOne();
        if (book != null) {
            return Optional.of(book);
        }
        return Optional.empty();
    }

    @Override
    public List<Book> findAll() {
        return jpaQueryFactory.selectFrom(book).fetch();
    }
}
