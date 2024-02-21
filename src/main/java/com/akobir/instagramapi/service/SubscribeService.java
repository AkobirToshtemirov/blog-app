package com.akobir.instagramapi.service;

import com.akobir.instagramapi.dto.SubscribeCreateDTO;
import com.akobir.instagramapi.dto.SubscribeDTO;

import java.util.List;

public interface SubscribeService {
    List<SubscribeDTO> getSubscriptionsByFollowerUserId(Long followerUserId);

    List<SubscribeDTO> getSubscriptionsByFollowingUserId(Long followingUserId);

    SubscribeDTO createSubscription(SubscribeCreateDTO subscribeCreateDTO);

    void deleteSubscription(Long subscribeId);
}
