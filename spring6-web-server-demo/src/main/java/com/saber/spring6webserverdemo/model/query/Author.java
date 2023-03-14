package com.saber.spring6webserverdemo.model.query;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "author")
@Getter
@Setter
@ToString(exclude = {"books"})
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstName",length = 70)
    private String firstName;
    @Column(name = "lastName",length = 90)
    private String lastName;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    public Set<Book> getBooks() {
        if (books == null){
            books = new HashSet<>();
        }
        return books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) && Objects.equals(firstName, author.firstName) && Objects.equals(lastName, author.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }
}
