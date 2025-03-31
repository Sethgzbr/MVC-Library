package com.iticbcn.libresapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iticbcn.libresapp.Model.Llibre;
import com.iticbcn.libresapp.Repositoris.BookRepository;
import java.util.Optional;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Set<Llibre> findAllLlibres() {
        return bookRepository.findAll();
    }

    @Override
    public Llibre findByTitol(String titol) {
        return bookRepository.findByTitol(titol);
    }

    @Override
    public Set<Llibre> findByTitolAndEditorial(String titol, String editorial) {
        return (Set<Llibre>) bookRepository.findByTitolAndEditorial(titol, editorial);
    }

    @Override
    public Optional<Llibre> findByIdLlibre(int id) {
        return (Optional <Llibre>) bookRepository.findByIdLlibre(id);
    }

    @Override
    public boolean validateIsbnFormat(String isbn) {
        if (isbn == null || (isbn.length() != 10 && isbn.length() != 13)) {
            return false;
        }
        return isbn.matches("\\d+");
    }
}
