package com.akobir.blogapp.controller;

import com.akobir.blogapp.dto.SubscribeCreateDTO;
import com.akobir.blogapp.dto.SubscribeDTO;
import com.akobir.blogapp.service.SubscribeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
@RequiredArgsConstructor
public class SubscribeController {

    private final SubscribeService subscribeService;

    @GetMapping("/followers/{followerUserId}")
    public ResponseEntity<List<SubscribeDTO>> getSubscriptionsByFollowerUserId(@PathVariable Long followerUserId) {
        List<SubscribeDTO> subscriptions = subscribeService.getSubscriptionsByFollowerUserId(followerUserId);
        return ResponseEntity.ok(subscriptions);
    }

    @GetMapping("/following/{followingUserId}")
    public ResponseEntity<List<SubscribeDTO>> getSubscriptionsByFollowingUserId(@PathVariable Long followingUserId) {
        List<SubscribeDTO> subscriptions = subscribeService.getSubscriptionsByFollowingUserId(followingUserId);
        return ResponseEntity.ok(subscriptions);
    }

    @PostMapping
    public ResponseEntity<SubscribeDTO> createSubscription(@RequestBody SubscribeCreateDTO subscribeCreateDTO) {
        SubscribeDTO subscription = subscribeService.createSubscription(subscribeCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(subscription);
    }

    @DeleteMapping("/{subscribeId}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable Long subscribeId) {
        subscribeService.deleteSubscription(subscribeId);
        return ResponseEntity.noContent().build();
    }
}
