package exceptionHandler.controlleradvice.controller;

import exceptionHandler.controlleradvice.dto.BookDTO;
import exceptionHandler.controlleradvice.exception.BookNotFoundException;
import exceptionHandler.controlleradvice.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public BookDTO getBook(@PathVariable("id") Long id) {

        // Retrieve the book from the database
        BookDTO book = bookService.getBook(id);

        // If the book does not exist, throw BookNotFoundException
        if (null == book) {
            throw new BookNotFoundException("Book with ID " + id + " not found");
        }

        return book;

    }
}
