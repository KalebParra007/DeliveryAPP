package com.example.deliveryAPP.services;

import com.example.deliveryAPP.models.User;
import com.example.deliveryAPP.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepository repository;

    //Listar los metodos que activaran las consultas en la BD

    //Guardar
    public User createUser(User UserData)throws Exception{
        try {
            //Validar los datos de entrada
           return this.repository.save(UserData);

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Buscar todos los registros
    public List<User> searchUser()throws Exception{
        try {

           return this.repository.findAll();

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Buscar por ID
    public User searchUserById(Integer id)throws Exception{
        try {

            Optional<User> userSearched= this.repository.findById(id);
            if (userSearched.isPresent()){
                return userSearched.get();
            }else{
                throw new Exception("El usuario consultado no esta en la BD");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Modificar por ID}
    public User modifyUser(Integer id, User UserData) throws Exception{
        try {

            Optional<User> userSearched= this.repository.findById(id);
            if (userSearched.isPresent()){
                userSearched.get().setNumberPhone(UserData.getNumberPhone());
                userSearched.get().setEmail(UserData.getEmail());
                return this.repository.save(userSearched.get());
            }else{
                throw new Exception("Usuario no encontrado");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Eliminar por ID
    public boolean deleteUser(Integer id) throws Exception{
        try {

            Optional<User> userSearched= this.repository.findById(id);
            if (userSearched.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else {
                throw new Exception("Usuario no encontrado");
            }

        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}
