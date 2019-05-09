package com.github.richygreat.smr.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.github.richygreat.smr.entity.User;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
