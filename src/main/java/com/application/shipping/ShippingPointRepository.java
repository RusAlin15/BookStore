package com.application.shipping;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingPointRepository extends JpaRepository<ShippingPoint, Integer> {

	Set<ShippingPoint> findByIdIn(List<Integer> shippingPointsIds);

}
