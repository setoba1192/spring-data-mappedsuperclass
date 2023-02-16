package com.example.demo.repository;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
