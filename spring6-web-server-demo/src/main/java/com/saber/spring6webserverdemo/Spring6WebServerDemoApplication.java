package com.saber.spring6webserverdemo;

import com.saber.spring6webserverdemo.model.command.AuthorCommand;
import com.saber.spring6webserverdemo.model.query.Author;
import com.saber.spring6webserverdemo.services.AuthorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class Spring6WebServerDemoApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Spring6WebServerDemoApplication.class, args);
       // BookService bookService = context.getBean(BookService.class);
        AuthorService authorService = context.getBean(AuthorService.class);

//        Book book = new Book();
//        book.setIsbn("1234124");
//        book.setTitle("java");
//
        AuthorCommand author1 = new AuthorCommand();
        author1.setFirstName("saber");
        author1.setLastName("Azizi");

//        AuthorCommand author2 = new AuthorCommand();
//        author2.setFirstName("bruce3");
//        author2.setLastName("Lee3");
//        //author.setId(1L);
        System.out.println(authorService.save(author1));
      //  System.out.println(authorService.save(author2));


        // book.getAuthors().add(author);
       //author.getBooks().add(book);
     //   bookService.save(book);

//        Optional<Author> authorOptional = authorService.findById(2L);
//        if (authorOptional.isPresent()){
//            Author a = authorOptional.get();
//            System.out.println(a);
//        }

        List<Author> authors = authorService.findAll();
        System.out.println(authors);
    }
}