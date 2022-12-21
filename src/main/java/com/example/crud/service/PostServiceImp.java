package com.example.crud.service;

import com.example.crud.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostServiceImp implements PostService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Post> findAll() {
        return jdbcTemplate.query("SELECT * FROM posttbl", new BeanPropertyRowMapper<Post>(Post.class));
    }

    @Override
    public Post findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM posttbl WHERE id=?", new BeanPropertyRowMapper<>(Post.class), id);
    }

    @Override
    public int save(Post post) {
        return jdbcTemplate.update(
                "INSERT INTO posttbl (title, body) VALUES (?, ?)",
                new Object[] {post.getTitle(),post.getBody()}
        );
    }
    @Override
    public int update(Post post) {
        return jdbcTemplate.update(
                "UPDATE posttbl SET title = ?, body = ? WHERE id = ?",
                new Object[] {post.getTitle(),post.getBody(),post.getId()}
        );
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM posttbl WHERE id=?", id);
    }
}
