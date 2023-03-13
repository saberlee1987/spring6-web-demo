package com.saber.spring6webserverdemo.model.query;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "book")
@Getter
@Setter
@ToString(exclude = {"authors"})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title",length = 50)
    private String title;
    @Column(name = "isbn",length = 20)
    private String isbn;
    @ManyToMany
    @JoinTable(name = "author-book",
            joinColumns = @JoinColumn(name = "book_id")
    ,inverseJoinColumns = @JoinColumn(name = "author-id"))
    private Set<Author> authors;

    public Set<Author> getAuthors() {
        if (authors == null){
            authors = new HashSet<>();
        }
        return authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, isbn);
    }
}
