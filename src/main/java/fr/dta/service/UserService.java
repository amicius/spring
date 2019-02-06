package fr.dta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dta.model.User;
import fr.dta.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    
    public void save(User u) {
        userRepository.save( u );
    }
    
    public User findOne(Long id) {
        return userRepository.findOne( id );
    }
    
    public List<User> findAll(){
        return userRepository.findAll();
    }
    
    public void delete(User u) {
        userRepository.delete( u );
    }
    
    public User findOneByLogin(String login) {
        return userRepository.findOneByLogin( login );
    }
}
