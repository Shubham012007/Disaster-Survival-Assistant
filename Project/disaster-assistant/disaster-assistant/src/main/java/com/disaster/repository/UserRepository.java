package com.disaster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.disaster.entity.user;

public interface UserRepository extends JpaRepository<user, Long> {

    List<user> findAllByEmail(String email);

}