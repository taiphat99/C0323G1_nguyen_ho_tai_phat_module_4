package com.song.dto;

import com.song.model.Genre;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;

public class SongDTO implements Validator {
    private Integer id;
    private String name;
    private String composer;
    @NotNull(message = "Cannot be empty!")
    private Genre genre;

    public SongDTO(Integer id, String name, String composer, Genre genre) {
        this.id = id;
        this.name = name;
        this.composer = composer;
        this.genre = genre;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public SongDTO() {
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

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDTO songDTO = (SongDTO) target;
//        Name Regex
        if (songDTO.getName().equals("")) {
            errors.rejectValue("name", null, "Can't be Empty!");
        } else if (!songDTO.getName().matches("^(?!.*\\s{2})[A-Z][a-z]*(\\s[A-Z][a-z]*){0,}[^\\s@;,.=+\\-]{0,794}$")) {
            errors.rejectValue("name", null, "Invalid Name!");
        }
//        Composer Regex
        if (songDTO.getComposer().equals("")) {
            errors.rejectValue("composer", null, "Can't be Empty!");
        } else if (!songDTO.getComposer().matches("^(?!.*\\s{2})[A-Z][a-z]*(\\s[A-Z][a-z]*){0,}[^\\s@;,.=+\\-]{0,300}$")) {
            errors.rejectValue("composer", null, "Invalid Composer!");
        }
    }

}
