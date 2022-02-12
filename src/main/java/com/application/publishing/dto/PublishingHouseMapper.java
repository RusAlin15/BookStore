package com.application.publishing.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.application.publishing.PublishingHouse;

@Component
public class PublishingHouseMapper {

	public PublishingHouse houseDto2House(PublishingHouseDto houseDto) {
		PublishingHouse house = new PublishingHouse();
		house.setId(houseDto.getId());
		house.setName(houseDto.getName());
		house.setAddress(houseDto.getAddress());
		return house;
	}

	public PublishingHouseDto house2houseDto(PublishingHouse house) {
		PublishingHouseDto houseDto = new PublishingHouseDto();
		houseDto.setId(house.getId());
		houseDto.setName(house.getName());
		houseDto.setAddress(house.getAddress());
		return houseDto;
	}

	public List<PublishingHouseDto> houseList2HouseListDto(List<PublishingHouse> allHouses) {
		return allHouses.stream().map(this::house2houseDto).collect(Collectors.toList());
	}

}
