package ru.library.contorller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.library.domain.Author;
import ru.library.domain.Book;
import ru.library.domain.enums.Genre;
import ru.library.service.BookServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/show")
    public List<Book> showListOfBook() {
        return bookService.findAll();
    }
    @PostMapping("/addbook")
    private String addBook(@RequestParam(value = "title") String title,
                           @RequestParam(value = "description") String description,
                           @RequestParam(value = "author") Author author,
                           @RequestParam(value = "date") String date,
                           @RequestParam(value = "genre") Genre genre,
                           @RequestParam(value = "price") int price) {

        bookService.addBook(title, description, author, date, genre, price);

        return "Book added" + HttpStatus.OK;

    }


}
