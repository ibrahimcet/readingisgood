package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.uti.JsonMergePatcher;
import com.example.demo.uti.ValidatePatchBook;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    private final JsonMergePatcher mergePatcher;

    private final ValidatePatchBook validatePatchBook;

    public Book createBook(Book book){
        Book existingBook = bookRepository.findByName(book.getName());
        if (existingBook != null){
            throw new RuntimeException(String.format("There is a book with the same name! : %s", book.getName()));
        }
        bookRepository.save(book);
        return book;
    }

    public Book retrieveBook(String id) throws NotFoundException {
        Book retrievedBook = bookRepository.findById(id).orElseThrow(() -> new NotFoundException("Book not found"));
        return retrievedBook;
    }

    public Book patchBook(String id, String input) throws Exception {
        Book retrievedBook = retrieveBook(id);
        validatePatchBook.validate(input);
        Book patchedBook = mergePatcher.mergePatch(input, retrievedBook);
        bookRepository.save(patchedBook);
        return patchedBook;
    }

}
