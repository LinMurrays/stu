package cn.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController//对外暴露，跟提供者对应方法一致
public class HelloController {
	@Autowired//调用提供者需要引入一个模板对象
	private RestTemplate restTemplate;
	
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable String name){
		String url = "http://provider-user/hello/"+name;   //直接访问
		return restTemplate.getForObject(url, String.class);
	}
	

}
