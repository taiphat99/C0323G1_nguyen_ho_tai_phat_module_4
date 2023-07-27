package com.song.service.song;

import com.song.model.Song;
import com.song.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService{
    @Autowired
    private ISongRepository songRepository;
    @Override
    public Page<Song> findSongByNameContaining(Pageable pageable, String name) {
        return songRepository.findSongByNameContaining(pageable,name);
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }
}
