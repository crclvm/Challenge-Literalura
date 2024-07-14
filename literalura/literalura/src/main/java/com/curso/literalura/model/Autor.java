package com.curso.literalura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String birth;
    private String death;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> book;

    public Autor() {
    }

    public Autor(DatosAutor datosAutor) {
        this.name = datosAutor.nombre();
        this.birth = datosAutor.fechaDeNacimiento();
        this.death = datosAutor.fechaDeFallecimiento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }

    public List<Libro> getBook() {
        return book;
    }

    public void setBook(List<Libro> book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "********** AUTOR ***********" + '\n' +
                "Nombre= " + name + '\n' +
                "Fecha De Nacimiento= " + birth + '\n' +
                "Fecha De Fallecimiento= " + death + '\n' +
                "Libros= " + book.stream().map(Libro::getTitulo).collect(Collectors.toUnmodifiableList()) + '\n' +
                "****************************" + '\n';
    }
}
