package com.nttdata.technica.test.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tipo_documento")
public class TypeDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "codigo_tipo_documento", length = 10, nullable = false, unique = true)
    private String codigoTipoDocumento;

    @Column(name = "nombre_tipo_documento", length = 50, nullable = false)
    private String nombreTipoDocumento;

    //@OneToMany(mappedBy = "tipoDocumento")
    //private List<Client> clients;

    // Getters y Setters

    
}
