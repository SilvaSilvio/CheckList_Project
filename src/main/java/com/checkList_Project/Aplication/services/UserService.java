package com.checkList_Project.Aplication.services;

import com.checkList_Project.Aplication.models.User;
import com.checkList_Project.Aplication.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    //Camada de Negocio.
//    Instanciando o userRepository
    @Autowired
    private UserRepository userRepository;

//    Buscar o usuário pelo ID
    public User findById(Long id){
        Optional<User> user = this.userRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException("User not found"));

    }

    public List<User> findAll(){
        return this.userRepository.findAll();
    }

//    Salvando um usuário no banco
    @Transactional
    public User save(User user){
        //Verifica se já existe um id criado.
        user.setId(null);
        user = this.userRepository.save(user);
        return user;
    }

    @Transactional
    public User update(User obj){
//        Busca o objeto que se quer atualizar.
        User newObj = findById(obj.getId());
        newObj.setPassword(obj.getUser());

        return this.userRepository.save( newObj );
    }

    public void delete(Long id){
        findById(id);
        try{
            this.userRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Não é possivel excluir, pois existe vinculos a esse user.");
        }

    this.userRepository.deleteById(id);
    }

}
