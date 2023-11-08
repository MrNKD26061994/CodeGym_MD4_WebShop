package com.codegym.md4_webshop.service.impl;

import com.codegym.md4_webshop.model.Company;
import com.codegym.md4_webshop.repository.CompanyRepository;
import com.codegym.md4_webshop.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CompanyService implements ICompanyService {
    @Autowired
    CompanyRepository companyRepository;
    @Override
    public Iterable<Company> findAll() {
        return companyRepository.findAllByStatus(1);
    }

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public void remove(Long id) {

    }
}
