package com.example.filmlibrary.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Entity
@Table(name = "films")
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(
        name = "default_generator",
        sequenceName = "film_seq",
        allocationSize = 1
)
public class Film extends GenericModel{
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "premier_year", nullable = false)
    private String premierYear;

    @Column(name = "country")
    private String country;

    @Enumerated
    @Column(name = "genre")
    private Genre genre;

    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable(
            name = "filmdirectors",
            joinColumns = @JoinColumn(name = "film_id"),
            foreignKey = @ForeignKey(name = "FK_FILMS_DIRECTORS"),
            inverseJoinColumns = @JoinColumn(name = "director_id"),
            inverseForeignKey = @ForeignKey(name = "FK_DIRECTORS_FILMS")
    )
    private Set<Director> directors;

}
