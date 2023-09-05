package com.examination.service;

import com.examination.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISongService {
    Page<Song> getAll(Pageable pageable, String searchName, String genreName);

    void findById(Integer id);

    void save(Song song);

    void deleteById(Integer id);
}
