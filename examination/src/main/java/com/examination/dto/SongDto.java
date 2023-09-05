package com.examination.dto;

import com.examination.model.Genre;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

public class SongDto implements Validator {
    private String code;
    private String name;
    private String composer;
    private Date released_date;
    private Genre genre;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        if (songDto.getCode().equals("")) {
            errors.rejectValue("code", null, "Can not be blank");
        }
        if (songDto.getName().equals("")) {
            errors.rejectValue("name", null, "Can not be blank");
        } else if (songDto.getName().length() > 80) {
            errors.rejectValue("name", null, "The length can not be over 80 digits");
        }
        if (songDto.getComposer().equals("")) {
            errors.rejectValue("composer", null, "Can not be blank");
        }

    }

    public SongDto() {
    }

    public SongDto(String code, String name, String composer, Date released_date, Genre genre) {
        this.code = code;
        this.name = name;
        this.composer = composer;
        this.released_date = released_date;
        this.genre = genre;
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
