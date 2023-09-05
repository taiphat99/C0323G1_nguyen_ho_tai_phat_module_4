package com.examination.service;

import com.examination.model.Song;
import com.examination.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService {

    @Autowired
    private ISongRepository songRepository;

    @Override
    public Page<Song> getAll(Pageable pageable, String searchName, String genreName) {
        return songRepository.findSongByNameContainingAndGenreNameContaining(pageable, searchName, genreName);
    }

    @Override
    public void findById(Integer id) {
        songRepository.findById(id);
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void deleteById(Integer id) {
        songRepository.deleteById(id);
    }

}
