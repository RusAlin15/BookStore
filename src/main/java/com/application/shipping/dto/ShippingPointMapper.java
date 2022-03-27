package com.application.shipping.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.application.shipping.ShippingPoint;

@Component
public class ShippingPointMapper {

	public ShippingPoint shippingPointDto2ShippingPoint(ShippingPointDto shippingPointDto) {
		ShippingPoint shippingPoint = new ShippingPoint();
		shippingPoint.setAddress(shippingPointDto.getAddress());
		shippingPoint.setId(shippingPointDto.getId());
		return null;
	}

	public ShippingPointDto shippingPoint2ShippingPointDto(ShippingPoint createShippingPoint) {
		ShippingPointDto shippingPointDto = new ShippingPointDto();
		shippingPointDto.setAddress(createShippingPoint.getAddress());
		shippingPointDto.setId(createShippingPoint.getId());
		return null;
	}

	public List<ShippingPointDto> ShippingPoint2ShippingPointDtoList(List<ShippingPoint> allCompanies) {
		return allCompanies.stream().map(this::shippingPoint2ShippingPointDto).collect(Collectors.toList());
	}

}
