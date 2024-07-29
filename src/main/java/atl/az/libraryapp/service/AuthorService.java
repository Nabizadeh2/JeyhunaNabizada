package atl.az.libraryapp.service;

import atl.az.libraryapp.dao.AuthorEntity;
import atl.az.libraryapp.dao.AuthorRepository;
import atl.az.libraryapp.exception.AuthorNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public List<AuthorEntity> findAllAuthors() {
        log.info("findAllAuthors has started");

        return authorRepository.findAll();
    }

    public AuthorEntity findAuthorById(Long id) {
        log.info("findAuthorById has started");
        return authorRepository.findById(id).orElseThrow(() ->
                new AuthorNotFoundException("Author not found with id " + id));
    }

    public AuthorEntity saveAuthor(AuthorEntity authorEntity) {

        return authorRepository.save(authorEntity);
    }

    public void deleteAuthor(Long id) {

        authorRepository.deleteById(id);
    }
}
