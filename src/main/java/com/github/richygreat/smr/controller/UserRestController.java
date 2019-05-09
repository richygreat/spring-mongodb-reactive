package com.github.richygreat.smr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.richygreat.smr.entity.User;
import com.github.richygreat.smr.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserRestController {
	private final UserRepository userRepository;

	@GetMapping
	Mono<User> create(@RequestParam("username") String userName) {
		User user = new User();
		user.setUsername(userName);
		return userRepository.save(user);
	}

	@GetMapping("/{id}")
	Mono<User> read(@PathVariable("id") String id) {
		log.info("read: Entering id: {}", id);
		return userRepository.findById(id);
	}
}
