package com.saber.spring6webserverdemo.repositories.command;

import com.saber.spring6webserverdemo.model.query.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCommandRepository extends JpaRepository<Book,Long> {

}