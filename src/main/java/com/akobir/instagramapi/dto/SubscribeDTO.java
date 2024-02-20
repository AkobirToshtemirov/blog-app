package com.akobir.instagramapi.dto;

import java.util.Date;

public record SubscribeDTO(
        Long subscribeId,
        Long followerUserId,
        Long followingUserId,
        Date createdAt
) {
}
