package com.akobir.blogapp.service.impl;

import com.akobir.blogapp.dto.SubscribeCreateDTO;
import com.akobir.blogapp.dto.SubscribeDTO;
import com.akobir.blogapp.entity.Subscribe;
import com.akobir.blogapp.entity.User;
import com.akobir.blogapp.exception.DuplicateKeyException;
import com.akobir.blogapp.exception.NotFoundException;
import com.akobir.blogapp.mapper.SubscribeMapper;
import com.akobir.blogapp.repository.SubscribeRepository;
import com.akobir.blogapp.service.SubscribeService;
import com.akobir.blogapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubscribeServiceImpl implements SubscribeService {

    private final SubscribeRepository subscribeRepository;
    private final UserService userService;
    private final SubscribeMapper subscribeMapper;

    @Override
    public List<SubscribeDTO> getSubscriptionsByFollowerUserId(Long followerUserId) {
        User followerUser = userService.getById(followerUserId);
        List<Subscribe> subscriptions = subscribeRepository.findByFollowerUser(followerUser);
        return subscriptions.stream()
                .map(subscribeMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SubscribeDTO> getSubscriptionsByFollowingUserId(Long followingUserId) {
        User followingUser = userService.getById(followingUserId);
        List<Subscribe> subscriptions = subscribeRepository.findByFollowingUser(followingUser);
        return subscriptions.stream()
                .map(subscribeMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SubscribeDTO createSubscription(SubscribeCreateDTO subscribeCreateDTO) {
        User followerUser = userService.getById(subscribeCreateDTO.followerUserId());
        User followingUser = userService.getById(subscribeCreateDTO.followingUserId());

        Subscribe subscription = new Subscribe();
        subscription.setFollowerUser(followerUser);
        subscription.setFollowingUser(followingUser);

        try {
            subscription = subscribeRepository.save(subscription);
            return subscribeMapper.INSTANCE.toDTO(subscription);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateKeyException("Subscription already exists for the given users.");
        }
    }

    @Override
    public void deleteSubscription(Long subscribeId) {
        Subscribe subscription = subscribeRepository.findById(subscribeId)
                .orElseThrow(() -> new NotFoundException("Subscription not found with id: " + subscribeId));
        subscribeRepository.delete(subscription);
    }
}
