package com.application.shipping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.shipping.dto.ShippingPointDto;
import com.application.shipping.dto.ShippingPointMapper;

@RestController
@RequestMapping("/shipping")
public class ShippingPointController {

	@Autowired
	private ShippingPointMapper shippingMapper;

	@Autowired
	private ShippingPointService shippingService;

	@PostMapping
	public ResponseEntity<ShippingPointDto> createShippingPoint(@RequestBody ShippingPointDto shippingPointDto) {
		ShippingPoint shippingPoint = shippingMapper.shippingPointDto2ShippingPoint(shippingPointDto);
		return new ResponseEntity<ShippingPointDto>(
				shippingMapper.shippingPoint2ShippingPointDto(shippingService.createShippingPoint(shippingPoint)),
				HttpStatus.CREATED);
	}

	@GetMapping()
	public ResponseEntity<List<ShippingPointDto>> getAllCompanies() {
		return new ResponseEntity<List<ShippingPointDto>>(
				shippingMapper.ShippingPoint2ShippingPointDtoList(shippingService.getAllCompanies()), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ShippingPointDto> getShippingPointById(@PathVariable Integer id) {
		return new ResponseEntity<ShippingPointDto>(
				shippingMapper.shippingPoint2ShippingPointDto(shippingService.getShippingPointById(id)), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ShippingPointDto> updateShippingPoint(@RequestBody ShippingPointDto ShippingPointDto,
			@PathVariable Integer id) {
		ShippingPoint ShippingPoint = shippingMapper.shippingPointDto2ShippingPoint(ShippingPointDto);
		return new ResponseEntity<ShippingPointDto>(shippingMapper.shippingPoint2ShippingPointDto(
				shippingService.updateShippingPointByID(ShippingPoint, id)), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAuthorById(@PathVariable Integer id) {
		shippingService.deleteShippingPointById(id);
		return new ResponseEntity<String>("ShippingPoint " + id + " succesfuly deleted!", HttpStatus.OK);
	}
}
