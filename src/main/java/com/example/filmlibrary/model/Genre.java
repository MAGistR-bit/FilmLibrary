package com.example.filmlibrary.model;

/**
 * @author mikhail
 * Содержит перечисление жанров кино
 */
public enum Genre {
    COMEDY("Комедия"),
    DRAMA("Драма"),
    CRIME("Преступление"),
    MUSICAL("Мюзикл"),
    HORROR ("Ужасы");

    private final String genreText;

    /**
     * Параметризованный конструктор (создание объекта)
     * @param genreName название жанра
     */
    Genre(String genreName) {
        this.genreText = genreName;
    }

    /**
     * Получает жанр фильма
     * @return название жанра
     */
    public String getGenreText() {
        return genreText;
    }

}
