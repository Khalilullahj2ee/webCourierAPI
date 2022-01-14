package com.webCourier.controler;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webCourier.model.UserModel;
import com.webCourier.repository.UserService;



@RestController
public class WelcomeControler {
	@Autowired
	 private  UserService userService;
	@GetMapping("/")
	public String index() {
		
		return "hello";
	}
	
	@GetMapping("/user_findAll")
	public ResponseEntity<Map> findAll() {
		
		Map<String, Object> map = new HashMap<>();
		try {
			List<UserModel> users= (List<UserModel>) userService.findAll();
			
			map.put("message", "data fetch success");
			map.put("data", users);
			map.put("status", "success");
			return ResponseEntity.ok(map);
		}catch (Exception e) {
			
			map.put("message", "data fetch failed");
			map.put("data", null);
			map.put("status", "failed");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
	}
	
	@GetMapping("/find_by_id/{user_id}")
	public ResponseEntity<Map> findById(@PathVariable(value="user_id") long id) {
		Map<String, Object> map = new HashMap<>();
		try {
			UserModel user=  userService.findById(id).get();
			
			map.put("message", "data fetch success");
			map.put("data", user);
			map.put("status", "success");
			return ResponseEntity.ok(map);
		}catch (Exception e) {
			
			map.put("message", "data fetch failed");
			map.put("data", null);
			map.put("status", "failed");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
	}
	
	@GetMapping("/user_save")
	public ResponseEntity<Map> save(@RequestBody UserModel entity) {
		Map<String, Object> map = new HashMap<>();
		try {
			UserModel user=  userService.save(entity);
			
			map.put("message", " data save successful");
			map.put("data", user);
			map.put("status", "success");
			return ResponseEntity.ok(map);
		}catch (Exception e) {
			
			map.put("message", "data save failed");
			map.put("data", null);
			map.put("status", "failed");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
	}

	@GetMapping("/user_update")
	public ResponseEntity<Map> update(@RequestBody UserModel entity) {
		Map<String, Object> map = new HashMap<>();
		try {
			UserModel user=  userService.save(entity);
			
			map.put("message", " data update successful");
			map.put("data", user);
			map.put("status", "success");
			return ResponseEntity.ok(map);
		}catch (Exception e) {
			
			map.put("message", "data update failed");
			map.put("data", null);
			map.put("status", "failed");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
	}

	@GetMapping(value = "/user/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		Map<String, Object> map = new HashMap<>();
		UserModel user = userService.findById(id).get();
		try {
			userService.delete(user);
			map.put("message", "Data deleted successfully");
			map.put("Data", user);
			map.put("Status code", "success");
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("message", "Data deletation failed");
			map.put("Data", null);
			map.put("Status code", "fail");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
	}

}
