package com.iticbcn.libresapp.Controladors;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.iticbcn.libresapp.Model.Llibre;
import com.iticbcn.libresapp.Model.Usuaris;
import com.iticbcn.libresapp.Repositoris.RepoLlibre;

@Controller
@SessionAttributes("users")//Aquesta anotació permet que la variable users es pugui compartir entre diferents pàgines
public class BookController {

    @Autowired
    RepoLlibre repoll = new RepoLlibre();

    @GetMapping("/")//Aixeca el servidor i obre el navegador a http://localhost:8080/
    public String iniciar(Model model) {
        return "login";
    }

    @PostMapping("/index")
    public String login(@ModelAttribute("users")/*Va de la ma de la @SessionAttributes */ Usuaris users, Model model/*EM permet cambiar els atributs de la vista */) {

        model.addAttribute("users", users);

        if (users.getUsuari().equals("toni") 
        && users.getPassword().equals("h3ll0!!")) {
            return "index";
        } else {
            return "login";
        }        
    }

    @ModelAttribute("users")//Aquesta anotació permet que la variable users es pugui compartir entre diferents pàgines
    public Usuaris getDefaultUser() {
        return new Usuaris(); 
    }

        @GetMapping("/index")//Per si necessitem tornar a la pàgina d'inici
    public String index(@ModelAttribute("users") Usuaris users, Model model) {

            return "index";
        
    }

    @GetMapping("/consulta")//Agafa la llista de llibres i la mostra 
    public String consulta(@ModelAttribute("users") Usuaris users,Model model) {

        ArrayList<Llibre> llibres = repoll.getAllLlibres();

        model.addAttribute("llibres", llibres);
        
        return "consulta";
    }

    @GetMapping("/inserir") 
    public String inputInserir(@ModelAttribute("users") Usuaris users,Model model) {
        
        return "inserir";
    }
    
    @GetMapping("/cercaid")
    public String inputCerca(@ModelAttribute("users") Usuaris users, Model model) {

        Llibre llibre = new Llibre();
        llibre.setIdLlibre(0);
        model.addAttribute("llibreErr", true);
        model.addAttribute("message", "");
        model.addAttribute("llibre", llibre);

        return "cercaid";

    }

    @PostMapping("/inserir")
    public String inserir(@ModelAttribute("users") Usuaris users, Llibre llibre, Model model) {

        repoll.InsertaLlibre(llibre);//La insercio acaba aqui

        ArrayList<Llibre> llibres = repoll.getAllLlibres();

        model.addAttribute("llibres", llibres);
        
        return "consulta";
    
    }

        @PostMapping("/cercaid")
    public String cercaId(@ModelAttribute("users") Usuaris users,
                          @RequestParam(name = "idLlibre", required = false) String idLlibre, 
                          Model model) {
        
        int idLlib = 0;
        String message = "";
        boolean llibreErr = false;

        try {
            idLlib = Integer.parseInt(idLlibre);
            Llibre llibre = repoll.getLlibreID(idLlib);
            if(llibre !=null) {
                model.addAttribute("llibre", llibre);
            } else {
                message = "No hi ha cap llibre amb aquesta id";
                llibreErr = true;
            }

        } catch (Exception e) {
            message = "La id de llibre ha de ser un nombre enter";
            llibreErr = true;
        } 
        
        model.addAttribute("message", message);
        model.addAttribute("llibreErr",llibreErr);

        return "cercaid";

    }

}