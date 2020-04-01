package by.epam.library.entity;

import by.epam.library.validator.BookValidator;

import java.util.List;

public class Book {
    private String title;
    private List<Author> authors;
    private int numberOfPages;

    public Book() {}

    public Book(String title, List<Author> authors, int numberOfPages) {
        this.title = title;
        this.authors = authors;
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (BookValidator.isTitleValid(title)) {
            this.title = title;
        }
        //TODO throw exception
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}
