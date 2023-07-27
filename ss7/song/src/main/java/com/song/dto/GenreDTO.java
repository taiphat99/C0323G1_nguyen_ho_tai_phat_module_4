package com.song.dto;

import com.song.model.Song;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.OneToMany;
import java.util.Set;

public class GenreDTO implements Validator {
    private Integer id;
    private String name;
//    private Set<SongDTO> songDTOSet;


    public GenreDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public GenreDTO() {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    GenreDTO genreDTO = (GenreDTO) target;
        if(genreDTO.getName().equals("")){
            errors.rejectValue("name",null,"Can't be Empty!");
        } else if(!genreDTO.getName().matches("^(?!.*\\s{2})[A-Z][a-z]*(\\s[A-Z][a-z]*){0,}[^\\s@;,.=+\\-]{0,794}$")){
            errors.rejectValue("name",null,"Invalid Composer!");
        }
    }
}
