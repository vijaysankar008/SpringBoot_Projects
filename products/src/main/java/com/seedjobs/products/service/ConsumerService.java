package com.seedjobs.products.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seedjobs.products.domain.ConsumerEntity;
import com.seedjobs.products.repository.ConsumerRepository;

@Service
public class ConsumerService {
	@Autowired
	private ConsumerRepository consumerRepository;

	// Method is to save Data
	public void saveData(ConsumerEntity consumerEntity) {
		consumerRepository.save(consumerEntity);
	}

	// Method is to ListAllData
	public List<ConsumerEntity> listAll() {
		return consumerRepository.findAll();
	}

	// Method is for Edit Data
	public ConsumerEntity getDataByCategory(String category) {
		return consumerRepository.findById(category).get();
	}
}
