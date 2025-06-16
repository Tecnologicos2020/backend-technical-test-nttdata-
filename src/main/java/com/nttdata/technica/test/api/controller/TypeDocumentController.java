package com.nttdata.technica.test.api.controller;

import com.nttdata.technica.test.api.model.TypeDocument;
import com.nttdata.technica.test.api.service.TypeDocumentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-documento")
@CrossOrigin(origins = "*")
public class TypeDocumentController {

    @Autowired
    private TypeDocumentService typeDocumentService;


    @GetMapping
    public ResponseEntity<?> getAll() {
        return typeDocumentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return typeDocumentService.findById(id);
    }
    
}
