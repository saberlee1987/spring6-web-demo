package com.saber.spring6webserverdemo.repositories;

import com.saber.spring6webserverdemo.model.command.AuthorCommand;

public interface AuthorCommandRepository {
     AuthorCommand save(AuthorCommand entity);
}
