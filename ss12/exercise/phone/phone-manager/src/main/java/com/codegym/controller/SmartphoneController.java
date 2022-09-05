package com.codegym.controller;

import com.codegym.model.Smartphone;
import com.codegym.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {

    @Autowired
    private ISmartphoneService ismartphoneService;

    @GetMapping(value = "/list")
    public ResponseEntity<Page<Smartphone>> goSmartphoneList(
            @PageableDefault(size = 3) Pageable pageable) {

        Page<Smartphone> smartphonePage = this.ismartphoneService.findAll(pageable);

        if (!smartphonePage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(smartphonePage, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addNewSmartphone(@RequestBody Smartphone phoneObj) {
        try {
            this.ismartphoneService.save(phoneObj);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("delete")
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        Smartphone phone = this.ismartphoneService.findById(id);
        if (phone == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.ismartphoneService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("showUpdate")
    public ResponseEntity<Smartphone> showUpdate(@RequestParam Long id) {
        Smartphone phone = this.ismartphoneService.findById(id);
        if (phone == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(phone, HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Void> updateSmartphone(@RequestBody Smartphone smartphone) {
        try {
            this.ismartphoneService.save(smartphone);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
