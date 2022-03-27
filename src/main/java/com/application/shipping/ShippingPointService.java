package com.application.shipping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.exception.ResourceNotFoundException;

@Service
public class ShippingPointService {
	@Autowired
	private ShippingPointRepository shippingRepository;

	public ShippingPoint createShippingPoint(ShippingPoint shippingPoint) {
		return shippingRepository.saveAndFlush(shippingPoint);
	}

	public List<ShippingPoint> getAllCompanies() {
		return shippingRepository.findAll();
	}

	public ShippingPoint getShippingPointById(Integer id) {
		return shippingRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Shipping Point not found!"));
	}

	public ShippingPoint updateShippingPointByID(ShippingPoint shippingPoint, Integer id) {
		ShippingPoint shippingPoint2Update = getShippingPointById(id);
		shippingPoint2Update.setId(shippingPoint.getId());
		shippingPoint2Update.setAddress(shippingPoint.getAddress());

		return shippingRepository.saveAndFlush(shippingPoint2Update);
	}

	public void deleteShippingPointById(Integer id) {
		shippingRepository.deleteById(id);
	}

}
