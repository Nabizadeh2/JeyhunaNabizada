package atl.az.libraryapp.controller;

import atl.az.libraryapp.dao.AuthorEntity;
import atl.az.libraryapp.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<AuthorEntity> getAllAuthors() {

        return authorService.findAllAuthors();
    }

    @GetMapping("/{id}")
    public AuthorEntity getAuthorById(@PathVariable Long id) {

        return authorService.findAuthorById(id);
    }

    @PostMapping
    public AuthorEntity createAuthor(@RequestBody AuthorEntity authorEntity) {
        return authorService.saveAuthor(authorEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {

        authorService.deleteAuthor(id);
    }
}
