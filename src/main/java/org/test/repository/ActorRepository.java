package org.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.test.entity.ActorDAO;

import java.util.List;

public interface ActorRepository extends JpaRepository<ActorDAO, Integer> {
    List<ActorDAO> findByFirstNameLike(String firstName);
}
