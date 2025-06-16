package com.nttdata.technica.test.api.service;

import com.nttdata.technica.test.api.dto.ResponseClientDto;
import com.nttdata.technica.test.api.model.Client;
import com.nttdata.technica.test.api.model.TypeDocument;
import com.nttdata.technica.test.api.repository.ClienteRepository;
import com.nttdata.technica.test.api.repository.TypeDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TypeDocumentRepository typeDocumentRepository;

    /**
     * Obtiene todos los clientes
     * @return ResponseEntity<ResponseClientDto>
     */
    public ResponseEntity<?> findAll() {
        try {
            List<Client> clients = clienteRepository.findAll();
            ResponseClientDto responseClientDto = new ResponseClientDto(
                HttpStatus.OK.value(), 
                "Success", 
                clients);
            return ResponseEntity.status(HttpStatus.OK).body(responseClientDto);
        } catch (Exception e) {
            e.printStackTrace();
            ResponseClientDto responseClientDto = new ResponseClientDto(
                HttpStatus.INTERNAL_SERVER_ERROR.value(), 
                "Error", 
                e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseClientDto);
        }
    }

    /**
     * Obtiene un cliente por su id
     * @param id
     * @return ResponseEntity<ResponseClientDto>
     */
    public ResponseEntity<?> findById(Integer id) {
        try {
            Optional<Client> client = clienteRepository.findById(id);
            ResponseClientDto responseClientDto = new ResponseClientDto(
                HttpStatus.OK.value(), 
                "Success", 
                client);
            return ResponseEntity.status(HttpStatus.OK).body(responseClientDto);
        } catch (Exception e) {
            e.printStackTrace();
            ResponseClientDto responseClientDto = new ResponseClientDto(
                HttpStatus.INTERNAL_SERVER_ERROR.value(), 
                "Error", 
                e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseClientDto);
        }
    }

    /**
     * Busca un cliente por su identificacion y tipo de documento
     * @param identification
     * @param IdtypeDocument
     * @return ResponseEntity<ResponseClientDto>
     */
    public ResponseEntity<?> searchClientByIdentificationAndTypeDocument(String identification, Integer IdtypeDocument) 
    {
        try {
            if (identification == null || identification.trim().isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseClientDto(
                        HttpStatus.BAD_REQUEST.value(), 
                        "Se requiere la identificacion", 
                        null)
                    );
            }
            if (IdtypeDocument == 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseClientDto(
                        HttpStatus.BAD_REQUEST.value(), 
                        "Se requiere el tipo de documento", 
                        null)
                    );
            }
        
            // Validar existencia del tipo de documento (opcional, si es necesario)
    
            Optional<TypeDocument> typeDocumentOptional = typeDocumentRepository.findById(IdtypeDocument);
            if (typeDocumentOptional.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseClientDto(
                            HttpStatus.NOT_FOUND.value(), 
                            "No hay un tipo de documento con el id proporcionado", 
                            null)
                        );
            }
        
            // Buscar cliente por ambos parámetros
            Optional<Client> client = clienteRepository.findByIdentificacionAndTipoDocumento(identification, IdtypeDocument);
            if (client.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseClientDto(
                            HttpStatus.NOT_FOUND.value(), 
                            "No hay un cliente con los datos proporcionados", 
                            null)
                        );
            }
            return ResponseEntity.ok(new ResponseClientDto(HttpStatus.OK.value(), "Success", client.get()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new ResponseClientDto(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(), 
                    "Error", 
                    e.getMessage())
                );
        }
    }

    /**
     * Actualiza un cliente existente
     * @param id ID del cliente a actualizar
     * @param cliente Datos nuevos del cliente
     * @return ResponseEntity<ResponseClientDto>
     */
    public ResponseEntity<?> update(Integer id, Client cliente) {
        try {
            Optional<Client> existingClient = clienteRepository.findById(id);
            if (existingClient.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseClientDto(
                        HttpStatus.NOT_FOUND.value(),
                        "Cliente no encontrado",
                        null)
                );
            }
            // Copiar los datos del cliente recibido al existente
            Client clientToUpdate = existingClient.get();
            clientToUpdate.setIdentificacion(cliente.getIdentificacion());
            clientToUpdate.setPrimerNombre(cliente.getPrimerNombre());
            clientToUpdate.setSegundoNombre(cliente.getSegundoNombre());
            clientToUpdate.setPrimerApellido(cliente.getPrimerApellido());
            clientToUpdate.setSegundoApellido(cliente.getSegundoApellido());
            clientToUpdate.setTelefono(cliente.getTelefono());
            clientToUpdate.setDireccion(cliente.getDireccion());
            clientToUpdate.setCiudadResidencia(cliente.getCiudadResidencia());
            clientToUpdate.setTipoDocumento(cliente.getTipoDocumento());
            ResponseClientDto responseClientDto = new ResponseClientDto(
                HttpStatus.OK.value(),
                "Cliente actualizado correctamente",
                clienteRepository.save(clientToUpdate)
            );
            return ResponseEntity.status(HttpStatus.OK).body(responseClientDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new ResponseClientDto(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Error",
                    e.getMessage())
            );
        }
    }

    /**
     * Guarda un cliente
     * @param cliente
     * @return ResponseEntity<ResponseClientDto>
     */
    public ResponseEntity<?> save(Client cliente) {
        try {
            ResponseClientDto responseClientDto = new ResponseClientDto(
                HttpStatus.OK.value(), 
                "Success", 
                clienteRepository.save(cliente));
            return ResponseEntity.status(HttpStatus.OK).body(responseClientDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new ResponseClientDto(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(), 
                    "Error", 
                    e.getMessage())
                );
        }
    }
}
