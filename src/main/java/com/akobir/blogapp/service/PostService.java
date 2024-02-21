package com.akobir.blogapp.service;

import com.akobir.blogapp.dto.PostCreateDTO;
import com.akobir.blogapp.dto.PostDTO;

import java.util.List;

public interface PostService {
    List<PostDTO> getAllPosts();

    List<PostDTO> getPostsByUserId(Long userId);

    PostDTO getPostById(Long postId);

    PostDTO createPost(PostCreateDTO postCreateDTO);

    void deletePost(Long postId);
}
