package com.seedjobs.products.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.seedjobs.products.domain.ConsumerDto;
import com.seedjobs.products.domain.ConsumerEntity;
import com.seedjobs.products.service.ConsumerService;

@RestController
public class ConsumerController {
	@Autowired
	private ConsumerService service;

	@PostMapping("/create")
	public String saveConsumer(@RequestBody ConsumerDto consumerDto) {
		ConsumerEntity entity = new ConsumerEntity();
		entity.setConsumerCategory(consumerDto.getConsumerCategory());
		entity.setProductCategory(consumerDto.getProductCategory());
		entity.setGender(consumerDto.getGender());
		entity.setCount(consumerDto.getCount());
		entity.setRemark(consumerDto.getRemark());
		service.saveData(entity);
		return "Successfully saved";

	}

	@GetMapping("/view")
	public List<ConsumerEntity> viewAll() {
		List<ConsumerEntity> consumerEntities = service.listAll();
		return consumerEntities;
	}

	@PutMapping("/edit/{consumerCategory}")
	public ConsumerEntity edit(@PathVariable(name = "consumerCategory") String consumerCategory) {
		ConsumerEntity entity = service.getDataByCategory(consumerCategory);
		return entity;
	}
}
