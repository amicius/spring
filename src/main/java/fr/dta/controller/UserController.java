package fr.dta.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.exception.NotFoundException;
import fr.dta.exception.WrongUserException;
import fr.dta.model.User;
import fr.dta.service.UserService;

@RestController
@RequestMapping( "/api/users" )
public class UserController {
    
    @Autowired
    private UserService userService;

    @RequestMapping( value = "{id}", method = RequestMethod.GET )
    @ResponseBody
    public User findById( @PathVariable Long id ) throws NotFoundException {
        User user = userService.findOne( id );
        
        if (user == null) {
            throw new NotFoundException();
        }

        return user;
    }
    
    @RequestMapping(method = RequestMethod.GET )
    @ResponseBody
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping( method = RequestMethod.POST )
    @ResponseStatus( HttpStatus.CREATED )
    public void create( @RequestBody @Valid User resource, BindingResult bindingResult ) throws WrongUserException {
        
       if ( bindingResult.hasErrors()) {
           throw new WrongUserException();
       }
        userService.save( resource );
    }
    
    @RequestMapping(  value = "{id}", method = RequestMethod.PUT )
    public User update( @PathVariable Long id, @RequestBody @Valid User resource , BindingResult bindingResult ) throws NotFoundException, WrongUserException{
        if ( bindingResult.hasErrors()) {
            throw new WrongUserException();
        }
        resource.setId( id );
        return userService.save( resource );
    }
    
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody User resource) {
        userService.delete( resource );
    }

    
}
