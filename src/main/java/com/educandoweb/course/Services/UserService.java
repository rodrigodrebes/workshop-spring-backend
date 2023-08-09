package com.educandoweb.course.Services;

import com.educandoweb.course.Repositories.UserRepository;
import com.educandoweb.course.Services.Exceptions.DatabaseException;
import com.educandoweb.course.Services.Exceptions.ResourceNotFoundException;
import com.educandoweb.course.entities.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public User insert(User obj){
       return userRepository.save(obj);
    }

    public void delete(Long id){
        try{
       userRepository.deleteById(id);
    }

        catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj){
       try {
           //prepara o objeto monitorado para edição
           User entity = userRepository.getReferenceById(id);

           // atualiza os dados do entity com base nos dados que chegam do obj
           updateData(entity, obj);
           return userRepository.save(entity);
       }

       catch (EntityNotFoundException e){
           throw new ResourceNotFoundException(id);
       }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
