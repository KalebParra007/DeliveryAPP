package com.example.deliveryAPP.controllers;

import com.example.deliveryAPP.models.Details;
import com.example.deliveryAPP.models.Item;
import com.example.deliveryAPP.services.DetailsService;
import com.example.deliveryAPP.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ControllerItem {

    @Autowired
    ItemService itemService;

    //Guardar
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Item requestData){
        try{

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.itemService.createItem(requestData));
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
                    .body(this.itemService.searchItem());

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
                    .body(this.itemService.searchItemById(id));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> modify(@PathVariable Integer id, @RequestBody Item data){
        try {

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.itemService.modifyItem(id, data));

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
                    .body(this.itemService.deleteItem(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

}
