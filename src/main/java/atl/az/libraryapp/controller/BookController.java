package atl.az.libraryapp.controller;

import atl.az.libraryapp.dao.BookEntity;
import atl.az.libraryapp.model.BookDto;
import atl.az.libraryapp.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<BookEntity> getAllBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping("/{id}")
    public BookEntity getBookById(@PathVariable Long id) {
        return bookService.findBookById(id);
    }

    @PostMapping
    public BookEntity createBook(@RequestBody BookDto dto) {
        return bookService.saveBook(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
