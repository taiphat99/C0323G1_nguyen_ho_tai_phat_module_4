package com.examination.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "genre")
    private Set<Song> songSet;

    public Genre() {
    }

    public Genre(Integer id, String name, Set<Song> songSet) {
        this.id = id;
        this.name = name;
        this.songSet = songSet;
    }

    public Genre(String name, Set<Song> songSet) {
        this.name = name;
        this.songSet = songSet;
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

    public Set<Song> getSongSet() {
        return songSet;
    }

    public void setSongSet(Set<Song> songSet) {
        this.songSet = songSet;
    }
}
