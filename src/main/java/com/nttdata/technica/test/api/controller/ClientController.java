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

    @GetMapping
    public ResponseEntity<?> getAll() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return clienteService.findById(id);
    }

    @GetMapping("/{identification}/{tipoDocumento}")
    public ResponseEntity<?> searchClientByIdentificationAndTypeDocument(@PathVariable String identification, @PathVariable int tipoDocumento) {
        return clienteService.searchClientByIdentificationAndTypeDocument(identification, tipoDocumento);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Client client) {
        return clienteService.save(client);
    }
}
