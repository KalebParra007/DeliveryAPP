package com.example.deliveryAPP.controllers;

import com.example.deliveryAPP.models.Dealer;
import com.example.deliveryAPP.models.Delivery;
import com.example.deliveryAPP.services.DealerService;
import com.example.deliveryAPP.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery")
public class ControllerDelivery {

    @Autowired
    DeliveryService deliveryService;

    //Guardar
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Delivery requestData){
        try{

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.deliveryService.createDelivery(requestData));
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
                    .body(this.deliveryService.searchDelivery());

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
                    .body(this.deliveryService.searchDeliveryById(id));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> modify(@PathVariable Integer id, @RequestBody Delivery data){
        try {

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.deliveryService.modifyDelivery(id, data));

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
                    .body(this.deliveryService.deleteDelivery(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

}
