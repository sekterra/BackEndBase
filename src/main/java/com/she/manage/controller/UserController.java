/** 
 * Copyright (C) 2019, 2019 All Right Reserved, http://www.yullin.com/
 * 
 * SHE Business can not be copied and/or distributed without the express
 * permission of Yullin Technologies
 * 
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * 
 */

package com.she.manage.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.she.manage.model.User;
import com.she.manage.service.UserService;
import com.she.utils.RequestMapper;

/**
 * 사용자 컨트롤러
 *
 */
@RestController
@RequestMapping("api/manage/user")
public class UserController
{
	@Autowired
	private UserService userService;
	
	private RequestMapper requestMapper = new RequestMapper();
	
	/**
	 * 사용자 조회
	 * @param parameter 검색조건
	 * @return 사용자 목록
	 * @throws Exception
	 */
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers(@RequestParam HashMap<String, Object> parameter) throws Exception
	{
		HashMap <String, Object> map = this.requestMapper.convertAsParameter(parameter);
		int processNo = map.containsKey("processNo")? Integer.parseInt(map.get("processNo").toString()):0;
		String deptCd = map.containsKey("deptCd")? map.get("deptCd").toString():"";
		String userId = map.containsKey("userId")? map.get("userId").toString():"";
		String userNm = map.containsKey("userNm")? map.get("userNm").toString():"";
		
		List<User> users = this.userService.getUsers(processNo, deptCd, userId, userNm);
		
		return ResponseEntity.ok().body(users);
	}
	
	/**
	 * 사용자 상세 조회
	 * @param userId 사용자아이디
	 * @return 사용자
	 * @throws Exception
	 */
	@GetMapping("/user/{userId}")
	public ResponseEntity<User> getUser(@PathVariable String userId) throws Exception
	{		
		User user = this.userService.getUser(userId);
		
		return ResponseEntity.ok().body(user);
	}
}
