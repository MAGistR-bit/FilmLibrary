package com.example.filmlibrary.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Entity
@Table(name = "directors")
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(
        name = "default_generator",
        sequenceName = "director_seq",
        allocationSize = 1
)
public class Director extends GenericModel {
    @Column(name = "directors_fio", nullable = false)
    private String directorFIO;

    @Column(name = "position")
    private String position;

    @ManyToMany(
            mappedBy = "directors",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL}
    )
    private Set<Film> films;
}
