package com.xworkz.forms.dto;


import javax.validation.constraints.*;

    public class MusicDTO {

        @NotNull
        @Size(min = 3, max = 30, message = "Song name should be between 3 and 30 characters")
        private String songName;

        @NotNull
        @Size(min = 3, max = 30, message = "Artist name should be between 3 and 30 characters")
        private String artist;

        @NotNull
        @Size(min = 3, max = 20, message = "Genre should be between 3 and 20 characters")
        private String genre;

        @NotNull(message = "Duration is required")
        @Min(value = 1, message = "Minimum duration is 1 minute")
        @Max(value = 600, message = "Maximum duration is 600 minutes")
        private int durationMinutes;

        @NotNull
        @Size(min = 3, max = 20, message = "Language should be between 3 and 20 characters")
        private String language;

        public MusicDTO() {}

        public MusicDTO(String songName, String artist, String genre, int durationMinutes, String language) {
            this.songName = songName;
            this.artist = artist;
            this.genre = genre;
            this.durationMinutes = durationMinutes;
            this.language = language;
        }

        public String getSongName() { return songName; }
        public void setSongName(String songName) { this.songName = songName; }

        public String getArtist() { return artist; }
        public void setArtist(String artist) { this.artist = artist; }

        public String getGenre() { return genre; }
        public void setGenre(String genre) { this.genre = genre; }

        public int getDurationMinutes() { return durationMinutes; }
        public void setDurationMinutes(int durationMinutes) { this.durationMinutes = durationMinutes; }

        public String getLanguage() { return language; }
        public void setLanguage(String language) { this.language = language; }

        @Override
        public String toString() {
            return "MusicDTO{" +
                    "songName='" + songName + '\'' +
                    ", artist='" + artist + '\'' +
                    ", genre='" + genre + '\'' +
                    ", durationMinutes=" + durationMinutes +
                    ", language='" + language + '\'' +
                    '}';
        }
    }


