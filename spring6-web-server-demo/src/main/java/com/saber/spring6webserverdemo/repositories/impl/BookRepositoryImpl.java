package com.saber.spring6webserverdemo.repositories.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.saber.spring6webserverdemo.model.query.Book;
import com.saber.spring6webserverdemo.model.query.QBook;
import com.saber.spring6webserverdemo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

import static com.saber.spring6webserverdemo.model.query.QBook.book;
@Repository
@Transactional
public class BookRepositoryImpl implements BookRepository {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Override
    public Book save(Book entity) {
        Long id = jpaQueryFactory.insert(book)
                .columns(book.title,book.isbn,book.authors)
                .values(entity)
                .execute();
        entity.setId(id);
        return entity;
    }

    @Override
    public Optional<Book> findById(Long id) {
        Book book = jpaQueryFactory.selectFrom(QBook.book).where(QBook.book.id.eq(id))
                .fetchOne();
        if (book != null) {
            return Optional.of(book);
        }
        return Optional.empty();
    }
}
