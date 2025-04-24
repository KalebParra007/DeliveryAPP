package com.example.deliveryAPP.services;

import com.example.deliveryAPP.models.Dealer;
import com.example.deliveryAPP.models.Delivery;
import com.example.deliveryAPP.repositories.IDeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    @Autowired
    IDeliveryRepository repository;

    //Listar los metodos que activaran las consultas en la BD

    //Guardar
    public Delivery createDelivery(Delivery DeliveryData)throws Exception{
        try {
            //Validar los datos de entrada
            return this.repository.save(DeliveryData);

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Buscar todos los registros
    public List<Delivery> searchDelivery()throws Exception{
        try {

            return this.repository.findAll();

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Buscar por ID
    public Delivery searchDeliveryById(Integer id)throws Exception{
        try {

            Optional<Delivery> deliverySearched= this.repository.findById(id);
            if (deliverySearched.isPresent()){
                return deliverySearched.get();
            }else{
                throw new Exception("La entrega consultada no esta en la BD");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Modificar por ID}
    public Delivery modifyDelivery(Integer id, Delivery DeliveryData) throws Exception{
        try {

            Optional<Delivery> deliverySearched= this.repository.findById(id);
            if (deliverySearched.isPresent()){
                deliverySearched.get().setStatusDelivery(DeliveryData.getStatusDelivery());
                deliverySearched.get().setDeliveryDate(DeliveryData.getDeliveryDate());
                return this.repository.save(deliverySearched.get());
            }else{
                throw new Exception("Entrega no encontrada");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Eliminar por ID
    public boolean deleteDelivery(Integer id) throws Exception{
        try {

            Optional<Delivery> deliverySearched= this.repository.findById(id);
            if (deliverySearched.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else {
                throw new Exception("Entrega no encontrada");
            }

        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}
