package com.akobir.blogapp.service;

import com.akobir.blogapp.dto.SubscribeCreateDTO;
import com.akobir.blogapp.dto.SubscribeDTO;

import java.util.List;

public interface SubscribeService {
    List<SubscribeDTO> getSubscriptionsByFollowerUserId(Long followerUserId);

    List<SubscribeDTO> getSubscriptionsByFollowingUserId(Long followingUserId);

    SubscribeDTO createSubscription(SubscribeCreateDTO subscribeCreateDTO);

    void deleteSubscription(Long subscribeId);
}
