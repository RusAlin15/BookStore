package com.application.company;

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

import com.application.company.dto.CompanyCreateDto;
import com.application.company.dto.CompanyDto;
import com.application.company.dto.CompanyMapper;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyMapper companyMapper;

	@Autowired
	private CompanyService companyService;

	@PostMapping
	public ResponseEntity<CompanyDto> createCompany(@RequestBody CompanyCreateDto companyCreateDto) {
		Company company = companyMapper.companyDto2Company(companyCreateDto);
		return new ResponseEntity<CompanyDto>(
				companyMapper.company2CompanyDto(
						companyService.createCompany(company, companyCreateDto.getShippingPointIds())),
				HttpStatus.CREATED);
	}

	@GetMapping()
	public ResponseEntity<List<CompanyDto>> getAllCompanies() {
		return new ResponseEntity<List<CompanyDto>>(
				companyMapper.company2CompanyDtoList(companyService.getAllCompanies()), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CompanyDto> getCompanyById(@PathVariable Integer id) {
		return new ResponseEntity<CompanyDto>(companyMapper.company2CompanyDto(companyService.getCompanyById(id)),
				HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CompanyDto> updateCompany(@RequestBody CompanyDto companyDto, @PathVariable Integer id) {
		Company company = companyMapper.companyDto2Company(companyDto);
		return new ResponseEntity<CompanyDto>(
				companyMapper.company2CompanyDto(companyService.updateCompanyByID(company, id)), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAuthorById(@PathVariable Integer id) {
		companyService.deleteCompanyById(id);
		return new ResponseEntity<String>("Company " + id + " succesfuly deleted!", HttpStatus.OK);
	}

}
