package ru.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.library.domain.User;

@Repository
public interface AuthorRepository extends JpaRepository<User,Long> {
}
