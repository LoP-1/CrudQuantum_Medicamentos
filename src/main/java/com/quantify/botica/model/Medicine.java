package com.quantify.botica.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Nombre",nullable = false)
    private String name;

    @Column(name = "Laboratorio", nullable = false)
    private String laboratory;

    @Column(name = "Fecha de Vencimiento", nullable = false)
    private LocalDate dueDate;


    //constructor vacio
    public Medicine(){
    }

    //contructor normal
    public Medicine(long id, String name, String laboratory, LocalDate dueDate) {
        this.id = id;
        this.name = name;
        this.laboratory = laboratory;
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Medicamento{" +
                "id=" + id +
                ", nombre='" + name + '\'' +
                ", laboratorio='" + laboratory + '\'' +
                ", fechaVencimiento=" + dueDate +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(String laboratory) {
        this.laboratory = laboratory;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
