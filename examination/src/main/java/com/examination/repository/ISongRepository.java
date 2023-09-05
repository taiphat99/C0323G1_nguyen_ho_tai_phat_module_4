package com.examination.repository;

import com.examination.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song, Integer> {

    Page<Song> findSongByNameContainingAndGenreNameContaining(Pageable pageable, String searchName, String genreName);
}
