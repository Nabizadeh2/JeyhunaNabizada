package atl.az.libraryapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookDto {
    String name;
    Integer count;
    Long authorId;
}
