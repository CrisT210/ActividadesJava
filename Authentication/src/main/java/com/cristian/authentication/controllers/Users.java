package com.cristian.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cristian.authentication.models.User;
import com.cristian.authentication.services.UserService;

@Controller
public class Users {
	
	private final UserService userService;
    
    public Users(UserService userService) {
        this.userService = userService;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "/views/registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "/views/loginPage.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "/views/registrationPage.jsp";
		}else {
			userService.registerUser(user);
			session.setAttribute("session", user.getId());
			return "redirect:/home";
		}
    //si el resultado tiene errores, retornar a la página de registro (no se preocupe por las validaciones por ahora)
    //si no, guarde el usuario en la base de datos, guarde el id del usuario en el objeto Session y redirija a /home
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
		if(userService.authenticateUser(email, password) == true) {
			User user = userService.findByEmail(email);
			session.setAttribute("session", user.getId());
			return "redirect:/home";
		}else {
			model.addAttribute("error", "Error al verificar su Email o Password");
			return "/views/loginPage.jsp";
		}
    	
    //Si el usuario está autenticado, guarde su id de usuario en el objeto Session
    //sino agregue un mensaje de error y retorne a la página de inicio de sesión.
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
    	Long id = (Long) session.getAttribute("session");
    	User user = userService.findUserById(id);
    	model.addAttribute("user", user);
    	return "/views/homePage.jsp";
        //Obtener el usuario desde session, guardarlo en el modelo y retornar a la página principal
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
		session.invalidate();
    	return "redirect:/login";
        // invalidar la sesión
        // redireccionar a la página de inicio de sesión.
    }

}
