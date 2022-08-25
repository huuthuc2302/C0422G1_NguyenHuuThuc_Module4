package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MusicDto implements Validator {

    private Integer idSong;

    @Pattern(regexp = "([A-Za-z])+(\\s[A-Za-z])*", message = "Vui lòng nhập tên")
    @Size(min = 1, max = 800)
    private String nameSong;

    @Pattern(regexp = "(([A-Za-z])+(\\s[A-Za-z])*)", message = "Vui lòng nhập nghệ sĩ")
    @Size(min = 1, max = 300)
    private String artist;

    @Size(min =1,max = 1000)
    @Pattern(regexp = "^[\\w ,]+$",message = "Vui lòng nhập thể loại nhạc")
    private String type;

    public MusicDto() {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MusicDto musicDto = (MusicDto) target;

    }
}
