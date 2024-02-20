package com.akobir.instagramapi.dto;

import java.util.Date;

public record PostDTO(
        Long postId,
        Long userId,
        String title,
        String content,
        Date createdAt
) {
}
