package com.hits.iternship.repositories;

import com.hits.iternship.entities.comments.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    List<UserEntity> findAll();

//    List<UserEntity> findUserEntitiesByImage(String image);

    List<UserEntity> findUserEntitiesByUserId(Integer userId);
}
