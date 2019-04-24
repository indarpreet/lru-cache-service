package com.lru.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lru.dto.CacheDTO;
import com.lru.dto.UserDefinedResponse;
import com.lru.service.LruService;
import com.lru.constant.CacheConstant;
import com.lru.constant.HttpStatus;

@RestController
@RequestMapping(value = CacheConstant.MANAGE_CACHE_ACTION)
public class LruAction {

	@Autowired
	LruService lruService;

	@GetMapping(value = CacheConstant.GET)
	public UserDefinedResponse getValue(@PathVariable("id") int id) {
		UserDefinedResponse userDefinedResponse;
		try {
			CacheDTO cacheDTO = lruService.getValue(id);
			userDefinedResponse = new UserDefinedResponse(HttpStatus.OK, cacheDTO);
			return userDefinedResponse;
		} catch (NoSuchElementException e) {
			return new UserDefinedResponse(HttpStatus.NOT_FOUND, null);
		}
	}

	@PutMapping(value = CacheConstant.PUT)
	public UserDefinedResponse putValue(@PathVariable("id") int id) {
		UserDefinedResponse userDefinedResponse;
		try {

			CacheDTO cacheDTO = lruService.putValue(id);
			userDefinedResponse = new UserDefinedResponse();
			if (null != cacheDTO) {
				userDefinedResponse.setMessage(HttpStatus.OK);
			} else {
				userDefinedResponse.setMessage(HttpStatus.OK);
			}

			return userDefinedResponse;
		} catch (Exception e) {
			return new UserDefinedResponse(HttpStatus.INTERNAL_SERVER_ERROR, null);

		}

	}

}
