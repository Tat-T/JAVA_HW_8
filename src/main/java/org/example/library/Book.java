package org.example.library;

public class Book {
    private final String title;
    private final String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrow() {
        if (!isAvailable) {
            throw new IllegalStateException("Книга уже занята!");
        }
        isAvailable = false;
    }

    public void returnBook() {
        if (isAvailable) {
            throw new IllegalStateException("Книга уже возвращена!");
        }
        isAvailable = true;
    }
}
