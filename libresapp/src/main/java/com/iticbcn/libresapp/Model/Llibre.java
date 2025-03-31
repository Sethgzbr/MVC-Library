package com.iticbcn.libresapp.Model;

import lombok.*;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Llibre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLlibre;

    private String titol;
    private String autor;
    private String editorial;
    @Column(name = "data_edicio")
    private LocalDate datapublicacio;
    private String tematica;

    @Column(unique = true, nullable = false)
    private String isbn;

    public Llibre() {}

    public Llibre(int idLlibre, String titol, String autor, String editorial, LocalDate datapublicacio, String tematica, String isbn) {
        this.idLlibre = idLlibre;
        this.titol = titol;
        this.autor = autor;
        this.editorial = editorial;
        this.datapublicacio = datapublicacio;
        this.tematica = tematica;
        this.isbn = isbn;
    }

    public int getIdLlibre() {
        return idLlibre;
    }

    public void setIdLlibre(int idLlibre) {
        this.idLlibre = idLlibre;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public LocalDate getDatapublicacio() {
        return datapublicacio;
    }

    public void setDatapublicacio(LocalDate datapublicacio) {
        this.datapublicacio = datapublicacio;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
