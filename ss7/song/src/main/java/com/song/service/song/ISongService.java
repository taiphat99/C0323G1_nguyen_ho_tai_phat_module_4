package com.song.service.song;

import com.song.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISongService {
    Page<Song> findSongByNameContaining(Pageable pageable, String name);
    void save(Song song);
}
