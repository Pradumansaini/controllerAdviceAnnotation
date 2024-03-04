package exceptionHandler.controlleradvice.service;

import exceptionHandler.controlleradvice.dto.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookService {
    public BookDTO getBook(Long id) {

        return bookRepo().stream()
                .filter(e -> Objects.equals(e.getId(), id))
                .findFirst()
                .orElse(null);
    }

    private List<BookDTO> bookRepo() {

        return List.of(
                new BookDTO(1L, "Ramayana", "Valmiki"),
                new BookDTO(2L, "Bhagavad Gita", "Vyasa"),
                new BookDTO(3L, "Head First Java", "Kathy Sierra"),
                new BookDTO(4L, "Rich Dad Poor Dad", "Robert Kiyosaki")
        );
    }
}
