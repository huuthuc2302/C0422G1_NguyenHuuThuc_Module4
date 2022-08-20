package com.codegym.model;

import javax.persistence.*;

@Entity(name = "music")
@Table
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_song")
    private Long idSong;
    @Column(name = "name_song")
    private String nameSong;
    private String artist;
    private String type;
    private String link;

    public Music() {
    }

    public Music(Long idSong, String nameSong, String artist, String type, String link) {
        this.idSong = idSong;
        this.nameSong = nameSong;
        this.artist = artist;
        this.type = type;
        this.link = link;
    }

    public Long getIdSong() {
        return idSong;
    }

    public void setIdSong(Long idSong) {
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
