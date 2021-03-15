package com.persistence.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

/**
 * The Movie POJO class.
 */
@Data
@Entity
@Table(name = "MOVIE")
public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID")
    private long id;
    @NotNull
    @Column(name = "MOVIE_NAME")
    private String name;
    @Column(name = "PLOT", unique = true)
    private String plot;
    @ElementCollection(targetClass=Country.class)
    @Enumerated(EnumType.STRING)
    @JoinTable(name = "COUNTRY", joinColumns = @JoinColumn(name = "MOVIE_ID"))
    @Column(name = "COUNTRY_CODE", nullable = false)
    private Set<Country> countries;
    @NotNull
    @Column(name = "RUNTIME")
    private int runtime;
    @ManyToMany(mappedBy = "movies")
    private Set<Artist> cast;
    @OneToMany(mappedBy = "movie")
    private Set<Comment> comments;
    @OneToOne
    @JoinColumn(name = "IMDB_ID", unique = true)
    private Imdb imdb;
}
