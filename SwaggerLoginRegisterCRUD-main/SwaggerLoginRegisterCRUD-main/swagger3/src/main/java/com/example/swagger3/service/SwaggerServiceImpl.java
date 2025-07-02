package com.example.swagger3.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.swagger3.custom.exception.CustomException;
import com.example.swagger3.dto.SwaggerDTO;
import com.example.swagger3.entity.LoginRegister;
import com.example.swagger3.entity.SwaggerEntity;
import com.example.swagger3.repository.LoginRegisterRepo;
import com.example.swagger3.repository.SwaggerRepo;

@Service
public class SwaggerServiceImpl implements SwaggerService{

	@Autowired
	private SwaggerRepo swagRepo;
	
	@Autowired
	private LoginRegisterRepo loginSignupRepo;
	
	private static final List<String> VALID_EMAIL_DOMAINS = Arrays.asList("gmail.com","capgemini.com");

	@Override
	public ResponseEntity<List<SwaggerEntity>> getAllData() {
		List<SwaggerEntity> swagEntity = swagRepo.findAll();
		return ResponseEntity.ok(swagEntity);
	}

	@Override
	public Optional<SwaggerEntity> getById(Integer id) {
		return swagRepo.findById(id);
	}

	@Override
	public SwaggerEntity post(SwaggerDTO swagDto) {
		SwaggerEntity entity = new SwaggerEntity();
		entity.setAddress(swagDto.getAddress());
		entity.setFirstName(swagDto.getFirstName());
		entity.setLastName(swagDto.getLastName());
		entity.setPhone(swagDto.getPhone());
		return swagRepo.save(entity);
	}

	@Override
	public SwaggerEntity put(Integer id, SwaggerDTO swagDto) {
		Optional<SwaggerEntity> swag = swagRepo.findById(id);
		if (swag.isPresent()) {
			SwaggerEntity update = swag.get();
			update.setId(id);
			update.setAddress(swagDto.getAddress());
			update.setFirstName(swagDto.getFirstName());
			update.setLastName(swagDto.getLastName());
			update.setPhone(swagDto.getPhone());
			return swagRepo.save(update);
		} else {
			return null;
		}
	}

	@Override
	public SwaggerEntity patch(Integer id, SwaggerDTO swagDto) {
		Optional<SwaggerEntity> swag = swagRepo.findById(id);

		if (swag.isPresent()) {
			SwaggerEntity update = swag.get();
			update.setId(id);
			update.setAddress(swagDto.getAddress());
			return swagRepo.save(update);
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteRecord(Integer id) {
		if (swagRepo.existsById(id)) {
			swagRepo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public LoginRegister createUser(SwaggerDTO register) {
		Optional<LoginRegister> userCheck = loginSignupRepo.findByEmail(register.getEmail());
		if(userCheck.isPresent()) {
			LoginRegister vlaidationCheck = userCheck.get();
			String[] parts = vlaidationCheck.getEmail().split("@");
			String domain = parts[1];
			boolean valid = VALID_EMAIL_DOMAINS.contains(domain);
			if(!valid) {
				throw new CustomException("invalid domain");
			}
			throw new CustomException("User with email " + register.getEmail() + " already exists");
		}
		LoginRegister addUser = new LoginRegister();
		addUser.setEmail(register.getEmail());
		addUser.setGender(register.getGender());
		addUser.setPassword(register.getPassword());
		addUser.setPhoneNumber(register.getPhoneNumber());
		addUser.setUserName(register.getUserName());
		return loginSignupRepo.save(addUser);
	}
	
	public boolean checkLogin(String email, String password) {
		Optional<LoginRegister> user = loginSignupRepo.findByEmail(email);
		if(user.isPresent()) {
			LoginRegister signIn = user.get();
			return signIn.getPassword().equals(password);
		}else {
			return false;
		}
	}

}
