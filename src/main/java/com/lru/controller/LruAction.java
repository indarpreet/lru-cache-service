package com.lru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lru.model.Node;
import com.lru.service.LruService;

@RestController
@RequestMapping("api/v1")
public class LruAction {
	
	@Autowired
	LruService lruService;
	
	@GetMapping(value = "/get/{id}")
	public Node getValue(@PathVariable("id") long id){
		return lruService.getValue(id);
	}
	
	@PutMapping(value="/put/{id}")
	public Node putValue(@PathVariable("id") long id){
		return lruService.putValue(id);
	}

}