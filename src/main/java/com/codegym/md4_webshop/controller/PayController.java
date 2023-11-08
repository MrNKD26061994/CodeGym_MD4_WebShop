package com.codegym.md4_webshop.controller;

import com.codegym.md4_webshop.model.Pay;
import com.codegym.md4_webshop.service.IPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/pays")
public class PayController implements IGeneralController<Pay> {
    private final IPayService iPayService;

    @Autowired
    public PayController(IPayService iPayService) {
        this.iPayService = iPayService;
    }

    @Override
    @GetMapping
    public ResponseEntity<Iterable<Pay>> list() {
        List<Pay> pays = (List<Pay>) iPayService.findAll();
        if (pays.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pays, HttpStatus.OK);
    }

    @Override
    @PostMapping
    public ResponseEntity<Pay> create(@RequestBody Pay pay) {
        Optional<Pay> imageOptional = iPayService.findById(pay.getId());
        if (imageOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(iPayService.save(pay), HttpStatus.OK);
    }

    @Override
    @PutMapping
    public ResponseEntity<Pay> update(@RequestBody Pay pay) {
        Optional<Pay> customerOptional = iPayService.findById(pay.getId());
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(iPayService.save(pay), HttpStatus.OK);
    }


    @Override
    @DeleteMapping
    public ResponseEntity<Pay> delete(@RequestBody Long id) {
        Optional<Pay> customerOptional = iPayService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iPayService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
