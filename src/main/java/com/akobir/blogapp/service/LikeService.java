package com.akobir.blogapp.service;

import com.akobir.blogapp.dto.LikeCreateDTO;
import com.akobir.blogapp.dto.LikeDTO;

import java.util.List;

public interface LikeService {
    List<LikeDTO> getLikesByPostId(Long postId);

    LikeDTO likePost(LikeCreateDTO likeCreateDTO);

    void unlikePost(Long likeId);
}
