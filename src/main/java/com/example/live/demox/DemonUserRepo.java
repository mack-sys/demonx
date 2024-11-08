package com.example.live.demox;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemonUserRepo extends JpaRepository<DemonUser, Integer>{

}
