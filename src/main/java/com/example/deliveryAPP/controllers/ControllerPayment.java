package com.example.deliveryAPP.controllers;

import com.example.deliveryAPP.models.Order;
import com.example.deliveryAPP.models.Payment;
import com.example.deliveryAPP.services.OrderService;
import com.example.deliveryAPP.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payment")
public class ControllerPayment {

    @Autowired
    PaymentService paymentService;

    //Guardar
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Payment requestData){
        try{

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.paymentService.createPayment(requestData));
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
                    .body(this.paymentService.searchPayment());

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
                    .body(this.paymentService.searchPaymentById(id));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> modify(@PathVariable Integer id, @RequestBody Payment data){
        try {

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.paymentService.modifyPayment(id, data));

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
                    .body(this.paymentService.deletePayment(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

}
