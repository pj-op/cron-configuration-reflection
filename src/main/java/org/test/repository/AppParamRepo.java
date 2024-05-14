package org.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.test.entity.ApplicationParameters;

public interface AppParamRepo extends JpaRepository<ApplicationParameters,Integer> {}
