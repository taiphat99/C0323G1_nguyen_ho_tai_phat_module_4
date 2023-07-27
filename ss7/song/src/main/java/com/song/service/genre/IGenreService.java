package com.song.service.genre;

import com.song.model.Genre;
import com.song.model.Song;

import java.util.List;

public interface IGenreService {
    List<Genre> findAll();
}
