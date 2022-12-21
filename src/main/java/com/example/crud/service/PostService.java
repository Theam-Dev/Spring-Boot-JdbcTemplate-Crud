package com.example.crud.service;


import com.example.crud.models.Post;

import java.util.List;

public interface PostService {
    public List<Post> findAll();
    public Post findById(int id);
    public int save(Post post);
    public int update(Post post);
    public int deleteById(int id);
}