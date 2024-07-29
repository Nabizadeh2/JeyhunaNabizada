package atl.az.libraryapp.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import static jakarta.persistence.FetchType.EAGER;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="authors")
//@NamedEntityGraph(name = "CustomerEntity.orders",
//        attributeNodes = @NamedAttributeNode("books"))
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String fullName;

    @OneToMany(mappedBy = "authorEntity", fetch = EAGER)
    private Set<BookEntity> bookEntity;

}
