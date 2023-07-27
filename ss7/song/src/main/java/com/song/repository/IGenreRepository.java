package com.song.repository;

import com.song.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenreRepository extends JpaRepository<Genre,Integer> {
}
