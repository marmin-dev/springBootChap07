package com.springboot.jpa.repository;

import com.springboot.jpa.data.entity.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducerRepository extends JpaRepository<Producer,Long> {
}
