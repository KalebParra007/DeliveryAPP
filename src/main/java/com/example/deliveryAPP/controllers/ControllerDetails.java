package com.example.deliveryAPP.controllers;

import com.example.deliveryAPP.models.Delivery;
import com.example.deliveryAPP.models.Details;
import com.example.deliveryAPP.services.DeliveryService;
import com.example.deliveryAPP.services.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/details")
public class ControllerDetails {
    @Autowired
    DetailsService detailsService;

    //Guardar
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Details requestData){
        try{

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.detailsService.createDetails(requestData));
        }catch (Exception error){

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

    //Buscar Todos
    @GetMapping
    public ResponseEntity<?>searchAll(){
        try {

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.detailsService.searchDetails());

        }catch (Exception error){

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

    //Buscar Por Id
    @GetMapping("/{id}")
    public ResponseEntity<?> searchById(@PathVariable Integer id){
        try {

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.detailsService.searchDetailsById(id));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> modify(@PathVariable Integer id, @RequestBody Details data){
        try {

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.detailsService.modifyDetails(id, data));

        }catch (Exception error){

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Eliminar
    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.detailsService.deleteDetails(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
