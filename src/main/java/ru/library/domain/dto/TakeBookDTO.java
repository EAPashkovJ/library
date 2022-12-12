package ru.library.domain.dto;

import com.sun.istack.NotNull;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter(AccessLevel.PUBLIC)
@ToString
public class TakeBookDTO {
    @NotNull
    private String userID;

    @NotNull
    private String bookID;
}
