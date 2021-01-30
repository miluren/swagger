package com.z.controller;

import com.z.entity.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

	@GetMapping(value = "/hello")
	public String Hello(){
		return "Hello";
	}

	// 只要我们的接口中，返回了实体类，就会被扫描到Swagger中
	@PostMapping(value = "/hello")
	public User User(){
		return new User();
	}

	// ApiOperation接口， 给方法加注释
	@ApiOperation("Hello1控制类")
	@GetMapping("/hello1")
	public String Hello1(@ApiParam("用户名") String username){
		return "Hello1";
	}

	// ApiOperation接口， 给方法加注释
	@ApiOperation("Post测试类")
	@PostMapping("/post")
	public User post(@ApiParam("用户名") User user){
		return user;
	}

}
