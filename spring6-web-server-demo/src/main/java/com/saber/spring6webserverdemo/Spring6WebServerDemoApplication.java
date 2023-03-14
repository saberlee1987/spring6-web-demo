package com.saber.spring6webserverdemo;

import com.saber.spring6webserverdemo.model.command.AuthorCommand;
import com.saber.spring6webserverdemo.model.query.Author;
import com.saber.spring6webserverdemo.model.query.Book;
import com.saber.spring6webserverdemo.services.AuthorService;
import com.saber.spring6webserverdemo.services.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class Spring6WebServerDemoApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Spring6WebServerDemoApplication.class, args);
        BookService bookService = context.getBean(BookService.class);
        AuthorService authorService = context.getBean(AuthorService.class);

        Book book = new Book();
        book.setIsbn("1234124");
        book.setTitle("java");

        Author author1 = new Author();
        author1.setFirstName("saber");
        author1.setLastName("Azizi");
        author1.getBooks().add(book);
        book.getAuthors().add(author1);

        authorService.save(author1);
        bookService.save(book);


        List<Author> authors = authorService.findAll();
        System.out.println(authors);
        System.out.println("=======================================================================================================");
        List<Book> books = bookService.findAll();
        System.out.println(books);
    }
}