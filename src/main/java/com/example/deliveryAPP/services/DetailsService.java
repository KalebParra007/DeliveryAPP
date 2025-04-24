package com.example.deliveryAPP.services;

import com.example.deliveryAPP.models.Delivery;
import com.example.deliveryAPP.models.Details;
import com.example.deliveryAPP.repositories.IDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailsService {

    @Autowired
    IDetailsRepository repository;

    //Listar los metodos que activaran las consultas en la BD

    //Guardar
    public Details createDetails(Details DetailsData)throws Exception{
        try {
            //Validar los datos de entrada
            return this.repository.save(DetailsData);

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Buscar todos los registros
    public List<Details> searchDetails()throws Exception{
        try {

            return this.repository.findAll();

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Buscar por ID
    public Details searchDetailsById(Integer id)throws Exception{
        try {

            Optional<Details> detailsSearched= this.repository.findById(id);
            if (detailsSearched.isPresent()){
                return detailsSearched.get();
            }else{
                throw new Exception("El recibo consultado no esta en la BD");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Modificar por ID}
    public Details modifyDetails(Integer id, Details DetailsData) throws Exception{
        try {

            Optional<Details> detailsSearched= this.repository.findById(id);
            if (detailsSearched.isPresent()){
                detailsSearched.get().setAmountItem(DetailsData.getAmountItem());
                detailsSearched.get().setSubTotalItem(DetailsData.getSubTotalItem());
                return this.repository.save(detailsSearched.get());
            }else{
                throw new Exception("Detalle no encontrado");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Eliminar por ID
    public boolean deleteDetails(Integer id) throws Exception{
        try {

            Optional<Details> detailsSearched= this.repository.findById(id);
            if (detailsSearched.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else {
                throw new Exception("Detalle no encontrado");
            }

        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}
