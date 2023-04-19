package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Clothes;
import com.example.demo.model.User;
@Repository

public interface ClothesRepository extends JpaRepository<Clothes, Integer>{
	@Query("FROM Clothes c WHERE c.name LIKE %?1%")
	public List<Clothes> search(String keyword);
}
