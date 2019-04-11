package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private String publicationDate;

    public Book(String title, String author, String publicationDate) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return this.title;
    }
    public String getAuthor() { return this.author; }
    public String getPublicationDate() { return this.publicationDate; }
}
