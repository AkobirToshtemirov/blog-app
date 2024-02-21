package com.akobir.instagramapi.repository;

import com.akobir.instagramapi.entity.Subscribe;
import com.akobir.instagramapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscribeRepository extends JpaRepository<Subscribe, Long> {
    List<Subscribe> findByFollowerUser(User user);

    List<Subscribe> findByFollowingUser(User user);

    Optional<Subscribe> findByFollowerUserAndFollowingUser(User followerUser, User followingUser);
}
