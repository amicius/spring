package fr.dta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.model.User;
import fr.dta.service.UserService;

@RestController
@RequestMapping( "/api/users" )
public class UserController {
    
    @Autowired
    private UserService userService;

    @RequestMapping( value = "{id}", method = RequestMethod.GET )
    @ResponseBody
    public User findById( @PathVariable Long id ) {
        return userService.findOne( id );
    }
    
    @RequestMapping(method = RequestMethod.GET )
    @ResponseBody
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping( method = RequestMethod.POST )
    @ResponseStatus( HttpStatus.CREATED )
    public void create( @RequestBody User resource ) {
        userService.save( resource );
    }
    
    @RequestMapping( method = RequestMethod.POST )
    @ResponseStatus( HttpStatus.OK )
    public void update( @RequestBody User resource ) {
        userService.save( resource );
    }
    
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus( HttpStatus.OK)
    public void delete(@RequestBody User resource) {
        userService.delete( resource );
    }

    
}
