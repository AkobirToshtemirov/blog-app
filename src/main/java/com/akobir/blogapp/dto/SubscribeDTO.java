package com.akobir.blogapp.dto;

import java.time.LocalDateTime;

public record SubscribeDTO(
        Long subscribeId,
        Long followerUserId,
        Long followingUserId,
        LocalDateTime createdAt
) {
}
