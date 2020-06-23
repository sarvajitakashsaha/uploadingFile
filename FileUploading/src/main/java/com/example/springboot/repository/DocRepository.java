package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.model.Doc;

public interface DocRepository extends JpaRepository<Doc, Integer> {

}
