package com.application.company;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.application.shipping.ShippingPoint;

@Entity
@Table(name = "company", schema = "administration")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, orphanRemoval = true)
	@JoinColumn(name = "shipping_point_id_fk")
	private Set<ShippingPoint> shippingPoints;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ShippingPoint> getShippingPoints() {
		return shippingPoints;
	}

	public void setShippingPoints(Set<ShippingPoint> shippingPoints) {
		this.shippingPoints = shippingPoints;
	}

}
