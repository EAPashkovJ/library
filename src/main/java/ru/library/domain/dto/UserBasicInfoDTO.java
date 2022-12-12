package ru.library.domain.dto;

import com.sun.istack.NotNull;
import lombok.*;
import ru.library.domain.enums.UserAccessType;

import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter(AccessLevel.PUBLIC)
@ToString
public class UserBasicInfoDTO {
    @NotNull
    private long id;

    @NotNull
    private String name;

    private int points;

    private Set<UserAccessType> userAccessType;

    @NotNull
    private String email;


}
