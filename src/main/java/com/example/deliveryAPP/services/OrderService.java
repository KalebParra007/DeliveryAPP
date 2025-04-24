package com.example.deliveryAPP.services;

import com.example.deliveryAPP.models.Item;
import com.example.deliveryAPP.models.Order;
import com.example.deliveryAPP.repositories.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    IOrderRepository repository;

    //Listar los metodos que activaran las consultas en la BD

    //Guardar
    public Order createOrder(Order OrderData)throws Exception{
        try {
            //Validar los datos de entrada
            return this.repository.save(OrderData);

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Buscar todos los registros
    public List<Order> searchOrder()throws Exception{
        try {

            return this.repository.findAll();

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Buscar por ID
    public Order searchOrderById(Integer id)throws Exception{
        try {

            Optional<Order> orderSearched= this.repository.findById(id);
            if (orderSearched.isPresent()){
                return orderSearched.get();
            }else{
                throw new Exception("La orden consultada no esta en la BD");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Modificar por ID}
    public Order modifyOrder(Integer id, Order OrderData) throws Exception{
        try {

            Optional<Order> orderSearched= this.repository.findById(id);
            if (orderSearched.isPresent()){
                orderSearched.get().setStatusOrder(OrderData.getStatusOrder());
                orderSearched.get().setOrderDate(OrderData.getOrderDate());
                orderSearched.get().setTotalOrder(OrderData.getTotalOrder());
                return this.repository.save(orderSearched.get());
            }else{
                throw new Exception("Orden no encontrada");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Eliminar por ID
    public boolean deleteOrder(Integer id) throws Exception{
        try {

            Optional<Order> orderSearched= this.repository.findById(id);
            if (orderSearched.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else {
                throw new Exception("Orden no encontrada");
            }

        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}
