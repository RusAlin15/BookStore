package com.application.publishing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.publishing.dto.PublishingHouseDTO;
import com.application.publishing.dto.PublishingHouseMapper;

@RestController
@RequestMapping("/publish")
public class PublishingHouseControler {

	@Autowired
	private PublishingHouseService houseService;

	@Autowired
	private PublishingHouseMapper houseMapper;

	@PostMapping
	public ResponseEntity<PublishingHouseDTO> createHouse(@RequestBody PublishingHouseDTO houseDTO) {
		PublishingHouse house = houseService.createHouse(houseMapper.houseDTO2House(houseDTO));

		return new ResponseEntity<PublishingHouseDTO>(houseMapper.house2houseDTO(house), HttpStatus.CREATED);
	}

	@GetMapping
	public List<PublishingHouseDTO> getAllHouses() {
		return houseMapper.houseList2HouseListDTO(houseService.getAllHouses());
	}

}
