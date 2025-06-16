package com.nttdata.technica.test.api.model;
import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "identificacion", length = 50, nullable = false)
    @NotNull
    private String identificacion;

    @Column(name = "primer_nombre", length = 50, nullable = false)
    private String primerNombre;

    @Column(name = "segundo_nombre", length = 50)
    private String segundoNombre;

    @Column(name = "primer_apellido", length = 50, nullable = false)
    private String primerApellido;

    @Column(name = "segundo_apellido", length = 50)
    private String segundoApellido;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "direccion", length = 100)
    private String direccion;

    @Column(name = "ciudad_residencia", length = 50)
    private String ciudadResidencia;

    //@OneToOne
    @Column(name = "tipo_documento_id")
    @NotNull
    private int tipoDocumento;

}
