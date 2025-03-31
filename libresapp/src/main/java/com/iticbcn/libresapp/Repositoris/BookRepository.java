package com.iticbcn.libresapp.Repositoris;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import com.iticbcn.libresapp.Model.Llibre;

import java.util.Optional;
import java.util.Set;

@Repository
public interface BookRepository extends CrudRepository<Llibre, Integer> {
    
    @Override
    @NonNull
    Set<Llibre> findAll();
    Llibre findByTitol(String titol);
    Llibre findByTitolAndEditorial(String titol, String editorial);
    Optional<Llibre> findByIdLlibre(int id);
    
}
