package com.example.deliveryAPP.services;

import com.example.deliveryAPP.models.Payment;
import com.example.deliveryAPP.models.Store;
import com.example.deliveryAPP.repositories.IStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    IStoreRepository repository;

    //Listar los metodos que activaran las consultas en la BD

    //Guardar
    public Store createStore(Store StoreData)throws Exception{
        try {
            //Validar los datos de entrada
            return this.repository.save(StoreData);

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Buscar todos los registros
    public List<Store> searchStore()throws Exception{
        try {

            return this.repository.findAll();

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Buscar por ID
    public Store searchStoreById(Integer id)throws Exception{
        try {

            Optional<Store> storeSearched= this.repository.findById(id);
            if (storeSearched.isPresent()){
                return storeSearched.get();
            }else{
                throw new Exception("La tienda consultada no esta en la BD");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Modificar por ID}
    public Store modifyStore(Integer id, Store StoreData) throws Exception{
        try {

            Optional<Store> storeSearched= this.repository.findById(id);
            if (storeSearched.isPresent()){
                storeSearched.get().setStoreName(StoreData.getStoreName());
                storeSearched.get().setStoreAddres(StoreData.getStoreAddres());
                storeSearched.get().setStorePhoneNumber(StoreData.getStorePhoneNumber());
                storeSearched.get().setStoreCategory(StoreData.getStoreCategory());
                return this.repository.save(storeSearched.get());
            }else{
                throw new Exception("Tienda no encontrada");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Eliminar por ID
    public boolean deleteStore(Integer id) throws Exception{
        try {

            Optional<Store> storeSearched= this.repository.findById(id);
            if (storeSearched.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else {
                throw new Exception("Tienda no encontrada");
            }

        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}
