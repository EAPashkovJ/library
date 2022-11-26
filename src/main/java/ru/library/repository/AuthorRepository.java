package ru.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.library.domain.User;

public interface AuthorRepository extends JpaRepository<User,Long> {
}
