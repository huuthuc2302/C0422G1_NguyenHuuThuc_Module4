package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "musics")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_song")
    private Integer idSong;
    @Column(name = "name_song")
    private String nameSong;
    private String artist;
    private String type;

    public Music() {
    }

    public Music(Integer idSong, String nameSong, String artist, String type) {
        this.idSong = idSong;
        this.nameSong = nameSong;
        this.artist = artist;
        this.type = type;
    }

    public Integer getIdSong() {
        return idSong;
    }

    public void setIdSong(Integer idSong) {
        this.idSong = idSong;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
