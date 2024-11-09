package com.example.live.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.live.entity.DemonUser;

@Repository
public interface DemonUserRepo extends JpaRepository<DemonUser, Integer>{

}
