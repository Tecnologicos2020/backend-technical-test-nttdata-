package com.nttdata.technica.test.api.service;

import com.nttdata.technica.test.api.dto.ResponseClientDto;
import com.nttdata.technica.test.api.model.TypeDocument;
import com.nttdata.technica.test.api.repository.TypeDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TypeDocumentService {

    @Autowired
    private TypeDocumentRepository typeDocumentRepository;

    /**
     * Obtiene todos los tipos de documentos
     * @return ResponseEntity<ResponseClientDto>
     */
    public ResponseEntity<?> findAll() {

        try {
            List<TypeDocument> typeDocuments = typeDocumentRepository.findAll();
            ResponseClientDto responseClientDto = new ResponseClientDto(
                200, 
                "Success", 
                typeDocuments);
            return ResponseEntity.status(HttpStatus.OK).body(responseClientDto);
        } catch (Exception e) {
            ResponseClientDto responseClientDto = new ResponseClientDto(
                500, 
                "Error", 
                e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseClientDto);
        }
    }

    /**
     * Obtiene un tipo de documento por su id
     * @param id
     * @return ResponseEntity<ResponseClientDto>
     */
    public ResponseEntity<?> findById(Integer id) {
        try {
            Optional<TypeDocument> typeDocument = typeDocumentRepository.findById(id);
            ResponseClientDto responseClientDto = new ResponseClientDto(
                200, 
                "Success", 
                typeDocument);
            return ResponseEntity.status(HttpStatus.OK).body(responseClientDto);
        } catch (Exception e) {
            ResponseClientDto responseClientDto = new ResponseClientDto(
                500, 
                "Error", 
                e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseClientDto);
        }
    }

}
