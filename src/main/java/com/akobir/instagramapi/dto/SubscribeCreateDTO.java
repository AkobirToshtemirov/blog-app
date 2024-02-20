package com.akobir.instagramapi.dto;

import jakarta.validation.constraints.NotNull;

public record SubscribeCreateDTO(
        @NotNull(message = "Follower user ID must not be null")
        Long followerUserId,

        @NotNull(message = "Following user ID must not be null")
        Long followingUserId
) {
}
