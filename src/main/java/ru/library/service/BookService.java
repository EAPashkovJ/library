package ru.library.service;

import ru.library.domain.Book;
import ru.library.domain.enums.BookStatus;

import java.util.List;
import java.util.Optional;

public interface BookService {

  List<Book> findAll();

  Optional<Book> findById(long id);

  boolean addBook(String title,
                           String description,
                           String author,
                           String date,
                           String genre,
                           int price);

    void deleteBook(long id);

    boolean changeStatus(String title, BookStatus bookStatus);
}


