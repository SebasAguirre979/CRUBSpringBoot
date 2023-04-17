package com.quality.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quality.demo.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
    
}
