package com.application.company;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.exception.ResourceNotFoundException;
import com.application.shipping.ShippingPoint;
import com.application.shipping.ShippingPointRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	private ShippingPointRepository shippingPointRepository;

	public Company createCompany(Company company, List<Integer> shippingPointsIds) {

		Set<ShippingPoint> shippingPoints = shippingPointRepository.findByIdIn(shippingPointsIds);

		if (shippingPoints.size() != shippingPoints.size()) {
			throw new ResourceNotFoundException("Shipping Points not found!");
		}

		company.setShippingPoints(shippingPoints);

		return companyRepository.saveAndFlush(company);
	}

	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}

	public Company getCompanyById(Integer id) {
		return companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Company not found!"));
	}

	public void deleteCompanyById(Integer id) {
		companyRepository.deleteById(id);
	}

	public Company updateCompanyByID(Company company, Integer id) {
		Company company2Update = getCompanyById(id);
		company2Update.setName(company.getName());
		return companyRepository.saveAndFlush(company2Update);
	}

}
