package ru.library.domain;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "orders_history")
public class Order  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @Column(name = "take_date")
    private LocalDate takeDate;
    @Column(name = "return_date")
    private LocalDate returnDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getTakeDate() {
        return takeDate;
    }

    public void setTakeDate(LocalDate takeDate) {
        this.takeDate = takeDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
