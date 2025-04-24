package com.example.deliveryAPP.controllers;

import com.example.deliveryAPP.models.Address;
import com.example.deliveryAPP.models.Dealer;
import com.example.deliveryAPP.services.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dealer")
public class ControllerDealer {

    @Autowired
    DealerService dealerService;

    //Guardar
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Dealer requestData){
        try{

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.dealerService.createDealer(requestData));
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
                    .body(this.dealerService.searchDealer());

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
                    .body(this.dealerService.searchDealerById(id));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> modify(@PathVariable Integer id, @RequestBody Dealer data){
        try {

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.dealerService.modifyDealer(id, data));

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
                    .body(this.dealerService.deleteDealer(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
