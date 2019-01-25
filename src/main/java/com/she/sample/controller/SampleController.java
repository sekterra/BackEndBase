package com.she.sample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
public class SampleController {
	
	@RequestMapping("/sample")
	@ResponseStatus(value = HttpStatus.OK)
	public String Test() {
		System.out.println("test mssql");
		return "sample/index";
	}

}
