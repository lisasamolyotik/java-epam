package by.epam.library.entity;
import java.util.List;

public class Author {
    private short age;
    private List<Book> books;

    public Author(){}

    public Author(short age) {
        this.age = age;
    }

    public Author(short age, List<Book> books) {
        this.age = age;
        this.books = books;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
