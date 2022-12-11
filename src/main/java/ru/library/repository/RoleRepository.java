package ru.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.library.domain.Role;
import ru.library.domain.enums.UserAccessType;

import javax.persistence.AccessType;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByRole(UserAccessType accessType);
}
