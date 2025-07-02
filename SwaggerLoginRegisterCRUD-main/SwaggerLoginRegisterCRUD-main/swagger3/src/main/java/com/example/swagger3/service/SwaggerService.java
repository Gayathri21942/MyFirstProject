package com.example.swagger3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.swagger3.dto.SwaggerDTO;
import com.example.swagger3.entity.LoginRegister;
import com.example.swagger3.entity.SwaggerEntity;

public interface SwaggerService {

	public ResponseEntity<List<SwaggerEntity>> getAllData();

	public Optional<SwaggerEntity> getById(Integer id);

	public SwaggerEntity post(SwaggerDTO swagDto);

	public SwaggerEntity put(Integer id, SwaggerDTO swagDto);

	public SwaggerEntity patch(Integer id, SwaggerDTO swagDto);

	public boolean deleteRecord(Integer id);

	public LoginRegister createUser(SwaggerDTO register);

	public boolean checkLogin(String email, String password);

	

}
