package fr.dta.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.dta.model.User;
import fr.dta.service.UserService;

@Controller
@RequestMapping( "/users" )
@SessionAttributes( "user" )
public class UserViewController {

    @Autowired
    private UserService userService;

    @RequestMapping( method = RequestMethod.GET )
    public ModelAndView display() {
        User user = new User();
        ModelAndView mv = new ModelAndView( "user" );
        mv.addObject( "user", user );
        return mv;
    }

    @RequestMapping( method = RequestMethod.POST )
    public String create( @Valid @ModelAttribute User user, BindingResult br, Model model ) {
        model.addAttribute( "test", ":)" );
        if ( br.hasErrors() ) {
            return "user";
        }
        userService.save( user );
        return "update_user_ok";
    }

}
