package com.akobir.instagramapi.service;

import com.akobir.instagramapi.dto.PostCreateDTO;
import com.akobir.instagramapi.dto.PostDTO;

import java.util.List;

public interface PostService {
    List<PostDTO> getAllPosts();

    List<PostDTO> getPostsByUserId(Long userId);

    PostDTO getPostById(Long postId);

    PostDTO createPost(PostCreateDTO postCreateDTO);

    void deletePost(Long postId);
}
