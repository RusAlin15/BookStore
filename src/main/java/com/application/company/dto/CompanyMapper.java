package com.application.company.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.application.company.Company;

@Component
public class CompanyMapper {

	public Company companyDto2Company(CompanyDto companyDto) {
		Company company = new Company();
		company.setId(companyDto.getId());
		company.setName(companyDto.getName());

		return company;
	}

	public CompanyDto company2CompanyDto(Company createCompany) {
		CompanyDto companyDto = new CompanyDto();
		companyDto.setId(createCompany.getId());
		companyDto.setName(createCompany.getName());
		return companyDto;
	}

	public List<CompanyDto> company2CompanyDtoList(List<Company> allCompanies) {
		return allCompanies.stream().map(this::company2CompanyDto).collect(Collectors.toList());
	}

	public Company companyDto2Company(CompanyCreateDto companyCreateDto) {
		Company company = new Company();
		company.setId(companyCreateDto.getId());
		company.setName(companyCreateDto.getName());

		return company;
	}

}
