package com.application.company.dto;

import java.util.List;

public class CompanyCreateDto {
	private Integer id;
	private String name;
	private List<Integer> shippingPointIds;

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

}
