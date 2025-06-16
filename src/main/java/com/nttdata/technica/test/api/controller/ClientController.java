package com.nttdata.technica.test.api.controller;
import com.nttdata.technica.test.api.model.Client;
import com.nttdata.technica.test.api.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
@CrossOrigin(origins = "*")
public class ClientController {

    @Autowired
    private ClienteService clienteService;

    /**
     * Obtiene todos los clientes
     * @return ResponseEntity con la lista de clientes
     */
    @GetMapping
    public ResponseEntity<?> getAll() {
        return clienteService.findAll();
    }

    /**
     * Obtiene un cliente por su ID
     * @param id ID del cliente
     * @return ResponseEntity con el cliente encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return clienteService.findById(id);
    }

    /**
     * Busca un cliente por identificación y tipo de documento
     * @param identification Identificación del cliente
     * @param tipoDocumento Tipo de documento
     * @return ResponseEntity con el cliente encontrado
     */
    @GetMapping("/{identification}/{tipoDocumento}")
    public ResponseEntity<?> searchClientByIdentificationAndTypeDocument(@PathVariable String identification, @PathVariable int tipoDocumento) {
        return clienteService.searchClientByIdentificationAndTypeDocument(identification, tipoDocumento);
    }

    /**
     * Crea un nuevo cliente
     * @param client Datos del cliente
     * @return ResponseEntity con el resultado de la operación
     */
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Client client) {
        return clienteService.save(client);
    }
}
