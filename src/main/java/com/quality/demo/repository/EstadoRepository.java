package com.quality.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quality.demo.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long>{
    
    
}
