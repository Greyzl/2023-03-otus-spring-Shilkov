package ru.otus.hw06orm.persistance.repository;

import ru.otus.hw06orm.persistance.entity.Author;
import ru.otus.hw06orm.persistance.entity.Book;
import ru.otus.hw06orm.persistance.entity.Comment;
import ru.otus.hw06orm.persistance.entity.Genre;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> getAll();

    List<Book> findByAuthor(Author author);

    List<Book> findByGenre(Genre genre);

    Optional<Book> findById(long id);

    Optional<Book> findByTitle(String name);

    Book save(Book book);

    void delete(Book book);

    List<Comment> getComments(long id);
}
