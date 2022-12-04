package ru.library.service;

import ru.library.domain.Book;

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

    public void deleteBook(long id);
}


