package ru.library.domain;

import ru.library.domain.enums.BookStatus;
import ru.library.domain.enums.Genre;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String tittle;
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
    private LocalDate date;
    private int price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
