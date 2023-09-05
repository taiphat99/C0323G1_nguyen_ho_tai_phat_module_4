package com.examination.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;
    private String name;
    private String composer;
    private Date released_date;
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;

    public Song() {
    }

    public Song(Integer id, String code, String name, String composer, Date released_date, Genre genre) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.composer = composer;
        this.released_date = released_date;
        this.genre = genre;
    }

    public Song(String code, String name, String composer, Date released_date, Genre genre) {
        this.code = code;
        this.name = name;
        this.composer = composer;
        this.released_date = released_date;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public Date getReleased_date() {
        return released_date;
    }

    public void setReleased_date(Date released_date) {
        this.released_date = released_date;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
