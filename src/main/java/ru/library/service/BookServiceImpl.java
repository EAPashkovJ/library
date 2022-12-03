package ru.library.service;

import org.springframework.stereotype.Service;
import ru.library.domain.Author;
import ru.library.domain.Book;
import ru.library.domain.enums.BookStatus;
import ru.library.domain.enums.Genre;
import ru.library.repository.BookRepository;

import java.util.List;

@Service

public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final Book book;

    public BookServiceImpl(BookRepository bookRepository, Book book) {
        this.bookRepository = bookRepository;
        this.book = book;
    }


    public List<Book> findAll() {
        return bookRepository.findAll();

    }

    public boolean addBook(
            String title,
            String description,
            Author author,
            String date,
            Genre genre,
            int price) {
        Book bookFromDb = bookRepository.findByTitle(book.getTitle());

        if (bookFromDb == null) {
            return false;
        }
        bookFromDb.setTitle(title);
        bookFromDb.setAuthor(author);
        bookFromDb.setDescription(description);
        bookFromDb.setDate(date);
        bookFromDb.setGenre(genre);
        bookFromDb.setPrice(price);
        bookFromDb.setBookStatus(BookStatus.AVAILABLE);

        return true;
    }


}
