package atl.az.libraryapp.service;

import atl.az.libraryapp.dao.AuthorEntity;
import atl.az.libraryapp.dao.BookEntity;
import atl.az.libraryapp.dao.BookRepository;
import atl.az.libraryapp.exception.BookNotFoundException;
import atl.az.libraryapp.model.BookDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public List<BookEntity> findAllBooks() {
        log.info("findAllBooks has started");
        return bookRepository.findAll();
    }

    public BookEntity findBookById(Long id) {
        log.info("findBookById has started");
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Author not found with id " + id));
    }

    public BookEntity saveBook(BookDto dto) {
        AuthorEntity author = authorService.findAuthorById(dto.getAuthorId());
        BookEntity book = BookEntity.builder()
                .count(dto.getCount())
                .name(dto.getName())
                .authorEntity(author)
                .build();
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {

        bookRepository.deleteById(id);
    }
}
