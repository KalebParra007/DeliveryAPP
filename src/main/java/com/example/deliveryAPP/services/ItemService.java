package com.example.deliveryAPP.services;

import com.example.deliveryAPP.models.Details;
import com.example.deliveryAPP.models.Item;
import com.example.deliveryAPP.repositories.IItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    IItemRepository repository;

    //Listar los metodos que activaran las consultas en la BD

    //Guardar
    public Item createItem(Item ItemData)throws Exception{
        try {
            //Validar los datos de entrada
            return this.repository.save(ItemData);

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Buscar todos los registros
    public List<Item> searchItem()throws Exception{
        try {

            return this.repository.findAll();

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Buscar por ID
    public Item searchItemById(Integer id)throws Exception{
        try {

            Optional<Item> itemSearched= this.repository.findById(id);
            if (itemSearched.isPresent()){
                return itemSearched.get();
            }else{
                throw new Exception("El producto consultado no esta en la BD");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Modificar por ID}
    public Item modifyItem(Integer id, Item ItemData) throws Exception{
        try {

            Optional<Item> itemSearched= this.repository.findById(id);
            if (itemSearched.isPresent()){
                itemSearched.get().setItemPrice(ItemData.getItemPrice());
                itemSearched.get().setItemDescription(ItemData.getItemDescription());
                return this.repository.save(itemSearched.get());
            }else{
                throw new Exception("Producto no encontrado");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Eliminar por ID
    public boolean deleteItem(Integer id) throws Exception{
        try {

            Optional<Item> itemSearched= this.repository.findById(id);
            if (itemSearched.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else {
                throw new Exception("Producto no encontrado");
            }

        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}
