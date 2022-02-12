package com.application.publishing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.exception.ResourceNotFoundException;

@Service
public class PublishingHouseService {

	@Autowired
	private PublishingHouseRepository houseRepository;

	public PublishingHouse createHouse(PublishingHouse house) {
		return houseRepository.saveAndFlush(house);
	}

	public List<PublishingHouse> getAllHouses() {
		return houseRepository.findAll();
	}

	public PublishingHouse getPublishingHouseById(Integer publishingHouseId) {
		return houseRepository.findById(publishingHouseId)
				.orElseThrow(() -> new ResourceNotFoundException("PublishingHouse", "Id", publishingHouseId));
	}

	public void deleteHouseById(Integer publishingHouseId) {
		try {
			houseRepository.deleteById(publishingHouseId);
		} catch (Exception e) {
			throw new ResourceNotFoundException("PublishingHouse", "Id", publishingHouseId);
		}
	}
}
