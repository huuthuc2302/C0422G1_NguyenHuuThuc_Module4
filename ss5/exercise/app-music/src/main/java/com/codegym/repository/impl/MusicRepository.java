package com.codegym.repository.impl;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class MusicRepository implements IMusicRepository {
    @Override
    public List<Music> getAll() {
        List<Music> musicList = BaseRepository.entityManager.createQuery("select s from music s", Music.class).getResultList();
        return musicList;
    }

    @Override
    public void save(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(music);
        entityTransaction.commit();
    }

    @Override
    public Music findById(Long id) {
        Music music = BaseRepository.entityManager.createQuery("select s from music s where s.idSong = ?1", Music.class).setParameter(1, id).getSingleResult();
        return music;
    }

    @Override
    public void update(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(music);
        entityTransaction.commit();
    }

    @Override
    public void remove(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(findById(music.getIdSong()));
        entityTransaction.commit();
    }

    @Override
    public List<Music> searchByName(Music music) {
        List<Music> searchList = BaseRepository.entityManager.
                createQuery("select s from music s where s.nameSong like ?1", Music.class).
                setParameter(1, "%" + music.getNameSong() + "%").getResultList();
        return searchList;
    }

}
