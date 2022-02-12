package com.application.publishing;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.publishing.dto.PublishingHouseDto;
import com.application.publishing.dto.PublishingHouseMapper;

@RestController
@RequestMapping("/publish")
public class PublishingHouseControler {

	@Autowired
	private PublishingHouseService houseService;

	@Autowired
	private PublishingHouseMapper houseMapper;

	@PostMapping
	public ResponseEntity<PublishingHouseDto> createHouse(@RequestBody PublishingHouseDto houseDto) {
		PublishingHouse house = houseService.createHouse(houseMapper.houseDto2House(houseDto));

		return new ResponseEntity<PublishingHouseDto>(houseMapper.house2houseDto(house), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<PublishingHouseDto>> getAllHouses() {
		return new ResponseEntity<List<PublishingHouseDto>>(
				houseMapper.houseList2HouseListDto(houseService.getAllHouses()), HttpStatus.OK);
	}

	@GetMapping("/by-id/{houseId}")
	public ResponseEntity<PublishingHouseDto> getHouseById(@PathVariable Integer houseId) {
		return new ResponseEntity<>(houseMapper.house2houseDto(houseService.getPublishingHouseById(houseId)),
				HttpStatus.OK);
	}

	@Transactional
	@DeleteMapping("/{houseId}")
	public ResponseEntity<String> deleteHouseById(@PathVariable Integer houseId) {
		houseService.deleteHouseById(houseId);
		return new ResponseEntity<String>("Publishing House " + houseId + " succesfuly deleted!	", HttpStatus.OK);
	}
}
