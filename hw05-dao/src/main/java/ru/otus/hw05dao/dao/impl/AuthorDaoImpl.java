package ru.otus.hw05dao.dao.impl;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.hw05dao.dao.AuthorDao;
import ru.otus.hw05dao.entity.Author;
import ru.otus.hw05dao.mapper.AuthorMapper;

import java.util.List;
import java.util.Map;

@Repository
public class AuthorDaoImpl implements AuthorDao {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public AuthorDaoImpl(NamedParameterJdbcOperations namedParameterJdbcOperations){
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    public List<Author> getAll(){
        return namedParameterJdbcOperations.query(
                "SELECT * FROM AUTHORS",new AuthorMapper());
    }

    @Override
    public Author getById(long id) {
        return namedParameterJdbcOperations.queryForObject(
                "SELECT * FROM AUTHORS WHERE ID = :Id", Map.of("Id", id),new AuthorMapper());
    }
}