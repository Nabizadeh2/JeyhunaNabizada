package atl.az.libraryapp.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.EAGER;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")

public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Integer count;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name="author_id",referencedColumnName = "id")
    private AuthorEntity authorEntity;
}
