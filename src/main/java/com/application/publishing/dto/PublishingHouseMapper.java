package com.application.publishing.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.application.publishing.PublishingHouse;

@Component
public class PublishingHouseMapper {

	public PublishingHouse houseDTO2House(PublishingHouseDTO houseDTO) {
		PublishingHouse house = new PublishingHouse();
		house.setId(houseDTO.getId());
		house.setName(houseDTO.getName());
		house.setAddress(houseDTO.getAddress());
		return house;
	}

	public PublishingHouseDTO house2houseDTO(PublishingHouse house) {
		PublishingHouseDTO houseDTO = new PublishingHouseDTO();
		houseDTO.setId(house.getId());
		houseDTO.setName(house.getName());
		houseDTO.setAddress(house.getAddress());
		return houseDTO;
	}

	public List<PublishingHouseDTO> houseList2HouseListDTO(List<PublishingHouse> allHouses) {
		return allHouses.stream().map(this::house2houseDTO).collect(Collectors.toList());
	}

}
