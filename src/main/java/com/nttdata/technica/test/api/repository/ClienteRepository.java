package com.nttdata.technica.test.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.technica.test.api.model.Client;

public interface ClienteRepository extends JpaRepository<Client, Integer> {
    // Métodos personalizados si es necesario

    Optional<Client> findByIdentificacionAndTipoDocumento(String identificacion, int tipoDocumento);
}
