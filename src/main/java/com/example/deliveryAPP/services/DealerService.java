package com.example.deliveryAPP.services;

import com.example.deliveryAPP.models.Address;
import com.example.deliveryAPP.models.Dealer;
import com.example.deliveryAPP.repositories.IDealerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DealerService {

    @Autowired
    IDealerRepository repository;

    //Listar los metodos que activaran las consultas en la BD

    //Guardar
    public Dealer createDealer(Dealer DealerData)throws Exception{
        try {
            //Validar los datos de entrada
            return this.repository.save(DealerData);

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Buscar todos los registros
    public List<Dealer> searchDealer()throws Exception{
        try {

            return this.repository.findAll();

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Buscar por ID
    public Dealer searchDealerById(Integer id)throws Exception{
        try {

            Optional<Dealer> dealerSearched= this.repository.findById(id);
            if (dealerSearched.isPresent()){
                return dealerSearched.get();
            }else{
                throw new Exception("El repartidor consultado no esta en la BD");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Modificar por ID}
    public Dealer modifyDealer(Integer id, Dealer DealerData) throws Exception{
        try {

            Optional<Dealer> dealerSearched= this.repository.findById(id);
            if (dealerSearched.isPresent()){
                dealerSearched.get().setDealerPhoneNumber(DealerData.getDealerPhoneNumber());
                dealerSearched.get().setDealerEmail(DealerData.getDealerEmail());
                dealerSearched.get().setDealerVehicle(DealerData.getDealerVehicle());
                return this.repository.save(dealerSearched.get());
            }else{
                throw new Exception("Repartidor no encontrado");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Eliminar por ID
    public boolean deleteDealer(Integer id) throws Exception{
        try {

            Optional<Dealer> dealerSearched= this.repository.findById(id);
            if (dealerSearched.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else {
                throw new Exception("Repartidor no encontrado");
            }

        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}
