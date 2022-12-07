package ru.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.library.domain.User;
import ru.library.domain.dto.UserBasicInfoDTO;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String user);

    @Query("SELECT new ru.library.domain.dto" +
            ".UserBasicInfoDTO(user .id, user.username, user .points, user .userAccessType, user .email) FROM User user")
    List<UserBasicInfoDTO> findAllUserWithBasicInfo();

    /*@Query("SELECT new ru.library.domain.dto" +
            ".UserBasicInfoDTO(user .id, user.username, user .points, user .userAccessType, user .email) FROM User user")*/
    UserBasicInfoDTO findUserBasicInfoById(long id);

}
