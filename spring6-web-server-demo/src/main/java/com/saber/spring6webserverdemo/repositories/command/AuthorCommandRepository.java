package com.saber.spring6webserverdemo.repositories.command;

import com.saber.spring6webserverdemo.model.command.AuthorCommand;
import com.saber.spring6webserverdemo.model.query.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorCommandRepository extends JpaRepository<Author,Long> {

}
