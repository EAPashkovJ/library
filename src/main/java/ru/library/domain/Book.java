package ru.library.domain;

import org.springframework.stereotype.Component;
import ru.library.domain.enums.BookStatus;
import ru.library.domain.enums.Genre;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Component("ru/library/")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @Enumerated(EnumType.STRING)
    @Column(name = "genre_id", columnDefinition = "enum")
    private Genre genre;
    @Transient
    private BookStatus bookStatus;
    private String description;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    @Column(name = "year")
    private String date;
    private int price;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String tittle) {
        this.title = tittle;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
