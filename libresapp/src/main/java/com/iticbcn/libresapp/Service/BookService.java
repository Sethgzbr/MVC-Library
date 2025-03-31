package com.iticbcn.libresapp.Service;
import java.util.Optional;
import java.util.Set;
import com.iticbcn.libresapp.Model.Llibre;

public interface BookService {

    Set<Llibre> findAllLlibres();
    Llibre findByTitol(String titol);
    Set<Llibre> findByTitolAndEditorial(String titol, String editorial);
    Optional<Llibre> findByIdLlibre(int id);
    boolean validateIsbnFormat(String isbn);
}
