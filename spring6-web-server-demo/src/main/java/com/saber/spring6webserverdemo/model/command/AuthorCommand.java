package com.saber.spring6webserverdemo.model.command;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;


@Data
public class AuthorCommand {

    private Long id;
    private String firstName;
    private String lastName;
//    @ManyToMany(mappedBy = "authors")
//    private Set<Book> books;

//    public Set<Book> getBooks() {
//        if (books == null){
//            books = new HashSet<>();
//        }
//        return books;
//    }
}
