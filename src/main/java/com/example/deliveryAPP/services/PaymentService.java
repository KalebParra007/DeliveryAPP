package com.example.deliveryAPP.services;

import com.example.deliveryAPP.models.Order;
import com.example.deliveryAPP.models.Payment;
import com.example.deliveryAPP.repositories.IPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    IPaymentRepository repository;

    //Listar los metodos que activaran las consultas en la BD

    //Guardar
    public Payment createPayment(Payment PaymentData)throws Exception{
        try {
            //Validar los datos de entrada
            return this.repository.save(PaymentData);

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Buscar todos los registros
    public List<Payment> searchPayment()throws Exception{
        try {

            return this.repository.findAll();

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Buscar por ID
    public Payment searchPaymentById(Integer id)throws Exception{
        try {

            Optional<Payment> paymentSearched= this.repository.findById(id);
            if (paymentSearched.isPresent()){
                return paymentSearched.get();
            }else{
                throw new Exception("El pago consultado no esta en la BD");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Modificar por ID}
    public Payment modifyPayment(Integer id, Payment PaymentData) throws Exception{
        try {

            Optional<Payment> paymentSearched= this.repository.findById(id);
            if (paymentSearched.isPresent()){
                paymentSearched.get().setPaymentMethod(PaymentData.getPaymentMethod());
                paymentSearched.get().setPaymenStatus(PaymentData.getPaymenStatus());
                paymentSearched.get().setPaymenDate(PaymentData.getPaymenDate());
                return this.repository.save(paymentSearched.get());
            }else{
                throw new Exception("Pago no encontrado");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Eliminar por ID
    public boolean deletePayment(Integer id) throws Exception{
        try {

            Optional<Payment> paymentSearched= this.repository.findById(id);
            if (paymentSearched.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else {
                throw new Exception("Pago no encontrado");
            }

        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}
