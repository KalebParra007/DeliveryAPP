package com.example.deliveryAPP.services;

import com.example.deliveryAPP.models.Address;
import com.example.deliveryAPP.models.User;
import com.example.deliveryAPP.repositories.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    IAddressRepository repository;

    //Listar los metodos que activaran las consultas en la BD

    //Guardar
    public Address createAddress(Address AddressData)throws Exception{
        try {
            //Validar los datos de entrada
            return this.repository.save(AddressData);

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Buscar todos los registros
    public List<Address> searchAddress()throws Exception{
        try {

            return this.repository.findAll();

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Buscar por ID
    public Address searchAddressById(Integer id)throws Exception{
        try {

            Optional<Address> addressSearched= this.repository.findById(id);
            if (addressSearched.isPresent()){
                return addressSearched.get();
            }else{
                throw new Exception("La dirección consultada no esta en la BD");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Modificar por ID}
    public Address modifyAddress(Integer id, Address AddressData) throws Exception{
        try {

            Optional<Address> addressSearched= this.repository.findById(id);
            if (addressSearched.isPresent()){
                addressSearched.get().setPaymentDate(AddressData.getPaymentDate());
                addressSearched.get().setAddresStreet(AddressData.getAddresStreet());
                addressSearched.get().setAddressCity(AddressData.getAddressCity());
                addressSearched.get().setAddressPostalCode(AddressData.getAddressPostalCode());
                addressSearched.get().setAddressCountry(AddressData.getAddressCountry());
                return this.repository.save(addressSearched.get());
            }else{
                throw new Exception("Dirección no encontrada");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Eliminar por ID
    public boolean deleteAddress(Integer id) throws Exception{
        try {

            Optional<Address> addressSearched= this.repository.findById(id);
            if (addressSearched.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else {
                throw new Exception("Dirección no encontrada");
            }

        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}
