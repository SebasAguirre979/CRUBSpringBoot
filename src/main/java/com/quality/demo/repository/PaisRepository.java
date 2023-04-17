package com.quality.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quality.demo.model.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long>{
    
}
