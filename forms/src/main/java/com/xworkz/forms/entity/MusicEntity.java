package com.xworkz.forms.entity;



import javax.persistence.*;

    @Entity
    @Table(name = "music_db")
    public class MusicEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String songName;
        private String artist;
        private String genre;
        private double duration;
        private String album;

        public MusicEntity() {
        }

        public MusicEntity(String songName, String artist, String genre, double duration, String album) {
            this.songName = songName;
            this.artist = artist;
            this.genre = genre;
            this.duration = duration;
            this.album = album;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSongName() {
            return songName;
        }

        public void setSongName(String songName) {
            this.songName = songName;
        }

        public String getArtist() {
            return artist;
        }

        public void setArtist(String artist) {
            this.artist = artist;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public double getDuration() {
            return duration;
        }

        public void setDuration(double duration) {
            this.duration = duration;
        }

        public String getAlbum() {
            return album;
        }

        public void setAlbum(String album) {
            this.album = album;
        }

        @Override
        public String toString() {
            return "MusicEntity{" +
                    "id=" + id +
                    ", songName='" + songName + '\'' +
                    ", artist='" + artist + '\'' +
                    ", genre='" + genre + '\'' +
                    ", duration=" + duration +
                    ", album='" + album + '\'' +
                    '}';
        }
    }

