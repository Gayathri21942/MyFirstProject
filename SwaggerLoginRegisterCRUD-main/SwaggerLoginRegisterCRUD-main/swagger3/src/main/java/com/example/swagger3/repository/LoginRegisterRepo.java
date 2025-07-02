package com.example.swagger3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.swagger3.entity.LoginRegister;

@Repository
public interface LoginRegisterRepo extends JpaRepository<LoginRegister, Integer> {

	public Optional<LoginRegister> findByEmail(String email);

	public Optional<LoginRegister> findByPassword(String password);

	public Optional<LoginRegister> findByEmailAndPassword(String email, String password);

}
