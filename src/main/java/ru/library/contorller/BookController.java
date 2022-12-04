package ru.library.contorller;


import org.springframework.web.bind.annotation.*;
import ru.library.domain.Book;
import ru.library.service.BookServiceImpl;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("{id}")
    public Optional<Book> returnBookById(@PathVariable long id) {
        return bookService.findById(id);
    }

    @PostMapping("/add-book")
    private String addBook(@RequestParam(value = "title") String title,
                           @RequestParam(value = "description") String description,
                           @RequestParam(value = "author") String author,
                           @RequestParam(value = "date") String date,
                           @RequestParam(value = "genre") String genre,
                           @RequestParam(value = "price") int price) {

        if(bookService.addBook(title, description, author, date, genre, price)) {
            return String.format("The book %s has been added", title);
        }else {
            return String.format("Cannot add book %s, book is exist", title);
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id){
        bookService.deleteBook(id);
        return "Book was deleted";
    }
}
