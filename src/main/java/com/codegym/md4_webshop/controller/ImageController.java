package com.codegym.md4_webshop.controller;

import com.codegym.md4_webshop.model.Image;
import com.codegym.md4_webshop.model.Pay;
import com.codegym.md4_webshop.repository.ImageRepository;
import com.codegym.md4_webshop.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/images")
public class ImageController implements IGeneralController<Image> {
    private final IImageService iImageService;

    @Autowired
    public ImageController(IImageService iImageService) {
        this.iImageService = iImageService;
    }

    @Override
    @GetMapping
    public ResponseEntity<Iterable<Image>> list() {
        List<Image> pays = (List<Image>) iImageService.findAll();
        if (pays.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pays, HttpStatus.OK);
    }

    @Override
@PostMapping
    public ResponseEntity<Image> create(@RequestBody Image image) {
        Optional<Image> customerOptional = iImageService.findById(image.getId());
        if (customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(iImageService.save(image), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Image> update(Image image) {
        return null;
    }

    @Override
    public ResponseEntity<Image> delete(Long id) {
        return null;
    }
}
