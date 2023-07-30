package com.book.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int quantity;
    private String author;
    private String image;
    @OneToMany(mappedBy = "book")
    private Set<Ticket> ticketSet;
    public Book() {
    }

    public Book(Integer id, String name, int quantity, String author, String image, Set<Ticket> ticketSet) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.author = author;
        this.image = image;
        this.ticketSet = ticketSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Ticket> getCodeSet() {
        return ticketSet;
    }

    public void setCodeSet(Set<Ticket> ticketSet) {
        this.ticketSet = ticketSet;
    }
}
