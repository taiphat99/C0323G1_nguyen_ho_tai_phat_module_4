package com.song.service.genre;

import com.song.model.Genre;
import com.song.model.Song;
import com.song.repository.IGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GenreService implements IGenreService{
    @Autowired
    private IGenreRepository genreRepository;

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }
}
