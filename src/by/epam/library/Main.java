package by.epam.library;

import by.epam.library.entity.Author;
import by.epam.library.entity.Book;
import by.epam.library.services.BookService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Author[] authors = new Author[3];
        Book[] books = new Book[3];

        authors[0] = new Author("J.K. Rowling", (short) 54);
        authors[1] = new Author("Stephen King", (short) 72);
        authors[2] = new Author("Peter Straub", (short) 77);

        ArrayList<Author> bookAuthors = new ArrayList<Author>();
        ArrayList<Book> authorBooks = new ArrayList<Book>();

        bookAuthors.add(authors[0]);

        books[0] = new Book("Harry Potter and the Philosopher's Stone", bookAuthors, 223);
        books[1] = new Book("Harry Potter and the Chamber of Secrets", bookAuthors, 251);

        authorBooks.add(books[0]);
        authorBooks.add(books[1]);

        authors[0].setBooks(authorBooks);

        bookAuthors.clear();
        authorBooks.clear();

        bookAuthors.add(authors[1]);
        bookAuthors.add(authors[2]);

        books[2] = new Book("The Talisman", bookAuthors, 921);

        authorBooks.add(books[2]);

        authors[1].setBooks(authorBooks);
        authors[2].setBooks(authorBooks);

        BookService bookService = new BookService();

        Optional<Book> maxBook = bookService.findMaxBook(Arrays.stream(books));

        if (maxBook.isPresent()) {
            System.out.println(maxBook.get());
        }

        maxBook = bookService.findMaxBook(Stream.empty());

        try {
            maxBook.orElseThrow(() -> new Exception("Can't find a book with max number of pages in an empty stream."));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
