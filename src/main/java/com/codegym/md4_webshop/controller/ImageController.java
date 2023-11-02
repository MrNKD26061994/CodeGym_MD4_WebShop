package com.codegym.md4_webshop.controller;

import com.codegym.md4_webshop.model.Image;
import com.codegym.md4_webshop.model.Pay;
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
        List<Image> images = (List<Image>) iImageService.findAll();
        if (images.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @Override
    @PostMapping
    public ResponseEntity<Image> create(@RequestBody Image image) {
        Optional<Image> imageOptional = iImageService.findImageByImage(image.getImage());
        if (imageOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(iImageService.save(image), HttpStatus.OK);
    }

    @Override
    @PutMapping
    public ResponseEntity<Image> update(@RequestBody Image image) {
        Optional<Image> imageOptional = iImageService.findById(image.getId());
        if (!imageOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(iImageService.save(image), HttpStatus.OK);
    }

    @Override
        @DeleteMapping
        public ResponseEntity<Image> delete(@RequestBody Long id) {
            Optional<Image> imageOptional = iImageService.findById(id);
            if (!imageOptional.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            iImageService.remove(imageOptional.get().getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
}
