package com.codegym.md4_webshop.controller;

import com.codegym.md4_webshop.model.Category;
import com.codegym.md4_webshop.model.Company;
import com.codegym.md4_webshop.service.ICategoryService;
import com.codegym.md4_webshop.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/company")
public class CompanyController implements IGeneralController<Company> {
    @Autowired
    private ICompanyService companyService;
    @GetMapping
    public ResponseEntity<Iterable<Company>> list() {
        List<Company> companyList = (List<Company>) companyService.findAll();
        if (companyList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(companyList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Company> create(@RequestBody Company company) {
        company.setStatus(1);
        companyService.save(company);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> update(@RequestBody Company company) {
        Optional<Company> companyOptional = companyService.findById(company.getId());
        if (!companyOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        companyService.save(company);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Company> delete(@PathVariable Long id) {
        Optional<Company> companyOptional = companyService.findById(id);
        if (!companyOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        companyOptional.get().setStatus(0);
        companyService.save(companyOptional.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
