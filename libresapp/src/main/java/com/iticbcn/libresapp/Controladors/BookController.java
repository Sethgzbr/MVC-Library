package com.iticbcn.libresapp.Controladors;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.iticbcn.libresapp.Model.Llibre;
import com.iticbcn.libresapp.Repositoris.BookRepository;
import com.iticbcn.libresapp.Service.BookService;

@Controller 
@SessionAttributes("users")//Aquesta anotació permet que la variable users es pugui compartir entre diferents pàgines
public class BookController {

    @Autowired
    private BookService repoll;
    @GetMapping("/")//Aixeca el servidor i obre el navegador a http://localhost:8081/
    public String iniciar(Model model) {
        return "login";
        }

    @PostMapping("/index")
        public String login(@RequestParam(name = "usuari", required = true) String usuari,
            @RequestParam(name = "password", required = true) String password,
            Model model) {

        if (usuari.equals("toni") && password.equals("h3ll0!!")) {
            return "index";
        } else {
            return "login";
        }        
    }

    @GetMapping("/index")//Per si necessitem tornar a la pàgina d'inici
    public String index(Model model) {

            return "index";
        
    }
    @GetMapping("/consulta")//Agafa la llista de llibres i la mostra 
    public String consulta(Model model) {

        Set<Llibre> llibres = repoll.findAllLlibres();

        model.addAttribute("llibres", llibres);
        
        return "consulta";
    }

    @GetMapping("/inserir") 
    public String inputInserir(Model model) {
        
        return "inserir";
    }
    
    @GetMapping("/cercaid")
    public String inputCerca(Model model) {

        Llibre llibre = new Llibre();
        llibre.setIdLlibre(0);
        model.addAttribute("llibreErr", true);
        model.addAttribute("message", "");
        model.addAttribute("llibre", llibre);

        return "cercaid";

    }

    /*@PostMapping("/inserir")
    public String inserir(Llibre llibre, Model model) {
        repoll.InsertaLlibre(llibre);//La insercio acaba aqui
        ArrayList<Llibre> llibres = repoll.getAllLlibres();
        model.addAttribute("llibres", llibres);
        return "consulta";
    
    }*/

    @PostMapping("/cercaid")
    public String cercaId(@RequestParam(name = "idLlibre", required = false) String idLlibre, 
                          Model model) {
        int idLlib = 0;
        String message = "";
        boolean llibreErr = false;
    
        try {
            idLlib = Integer.parseInt(idLlibre); // Parseamos el idLlibre
            Optional<Llibre> llibre = repoll.findByIdLlibre(idLlib);
            
            if (llibre.isPresent()) { // Si el libro existe, obtenemos el objeto Llibre real
                model.addAttribute("llibre", llibre.get()); // Añadimos el libro real al modelo
            } else {
                message = "No hi ha cap llibre amb aquesta id";
                llibreErr = true;
            }
        } catch (Exception e) {
            message = "La id de llibre ha de ser un nombre enter";
            llibreErr = true;
        }
    
        // Añadimos el mensaje y el estado del error al modelo
        model.addAttribute("message", message);
        model.addAttribute("llibreErr", llibreErr);
    
        return "cercaid";
    }
    

}