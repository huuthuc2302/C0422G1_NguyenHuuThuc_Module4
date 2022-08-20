package com.codegym.repository;

import com.codegym.model.Music;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.util.List;

public interface IMusicRepository {

    List<Music> getAll();

    void save(Music music);

    Music findById(Long id);

    void update(Music music);

    void remove(Music music);

    List<Music> searchByName(Music music);

}
