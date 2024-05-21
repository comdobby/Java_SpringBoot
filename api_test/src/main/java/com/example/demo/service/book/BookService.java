package com.example.demo.service.book;

import com.example.demo.repository.book.BookMemoryRepository;
import com.example.demo.repository.book.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService implements BookRepository {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void saveBook() {
        bookRepository.saveBook();
    }
}
