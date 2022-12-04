package ru.library.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.library.domain.Book;
import ru.library.domain.enums.BookStatus;
import ru.library.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
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

    public Optional<Book> findById(long id) {
        return bookRepository.findById(id);
    }

    public boolean addBook(
            String title,
            String description,
            String author,
            String date,
            String genre,
            int price) {
        Book bookFromDb = bookRepository.findByTitle(title);

        if (bookFromDb != null) {
            log.error("Книга уже существует");
            return false;
        }
        book.setTitle(title);
        book.setAuthor(author);
        book.setDescription(description);
        book.setDate(date);
        book.setGenre(genre);
        book.setPrice(price);
        book.setBookStatus(BookStatus.AVAILABLE);
        log.info("Сохраняю книгу:" + " " + book.getTitle());
        bookRepository.save(book);
        return true;
    }

    public void deleteBook(long id) {
        Optional<Book> bookFromDb = bookRepository.findById(id);
        if (bookFromDb.isPresent()) {
            bookRepository.deleteById(id);
            log.info("Книга удалена!");
        } else {
            log.error("Книга не найдена!");
        }

    }


}
