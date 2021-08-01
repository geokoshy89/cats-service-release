package com.example.catsservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<Cats,Integer> {
    Cats findByName(String name);
}
