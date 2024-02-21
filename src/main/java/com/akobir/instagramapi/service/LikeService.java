package com.akobir.instagramapi.service;

import com.akobir.instagramapi.dto.LikeCreateDTO;
import com.akobir.instagramapi.dto.LikeDTO;

import java.util.List;

public interface LikeService {
    List<LikeDTO> getLikesByPostId(Long postId);

    LikeDTO likePost(LikeCreateDTO likeCreateDTO);

    void unlikePost(Long likeId);
}
