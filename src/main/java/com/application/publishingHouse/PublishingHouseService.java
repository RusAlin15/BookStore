package com.application.publishingHouse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.exception.ResourceNotFoundException;

@Service
public class PublishingHouseService {

	@Autowired
	private PublishingHouseRepository houseRepository;

	public PublishingHouse getPublishingHouseById(Integer publishingHouseId) {
		return houseRepository.findById(publishingHouseId)
				.orElseThrow(() -> new ResourceNotFoundException("PublishingHouse", "Id", publishingHouseId));
	}

	public PublishingHouse createHouse(PublishingHouse house) {
		return houseRepository.saveAndFlush(house);
	}

	public List<PublishingHouse> getAllHouses() {
		return houseRepository.findAll();
	}

}
