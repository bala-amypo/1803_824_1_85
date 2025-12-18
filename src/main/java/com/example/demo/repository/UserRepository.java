package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.collectiondb.entity.studentEntity;



@Repository
public interface UserRepository extends JpaRepository<studentEntity, Long> {



}
