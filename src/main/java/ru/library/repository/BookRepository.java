package ru.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.library.domain.Book;



public interface BookRepository extends JpaRepository<Book, Long> {
}
