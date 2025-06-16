package com.nttdata.technica.test.api.repository;

import com.nttdata.technica.test.api.model.TypeDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeDocumentRepository extends JpaRepository<TypeDocument, Integer> {
    // Métodos personalizados si es necesario
}
