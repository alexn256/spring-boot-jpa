package com.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

/**
 * The Movie POJO class.
 */
@Getter
@Setter
@Entity
@Table(name = "MOVIE")
@NamedEntityGraph(name = "movie-graph",
        attributeNodes = {
                @NamedAttributeNode("imdb"),
                @NamedAttributeNode("countries"),
                @NamedAttributeNode("cast")
        })
public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID")
    private long movieId;
    @NotNull
    @Column(name = "title")
    private String title;
    @Column(name = "PLOT", unique = true)
    private String plot;
    @ElementCollection(targetClass = Country.class)
    @Enumerated(EnumType.STRING)
    @JoinTable(name = "COUNTRY", joinColumns = @JoinColumn(name = "MOVIE_ID"))
    @Column(name = "COUNTRY_CODE", nullable = false)
    private Set<Country> countries;
    @NotNull
    @Column(name = "RUNTIME")
    private int runtime;
    @NotNull
    @Column(name = "YEAR")
    private int year;
    @ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY)
    private Set<Artist> cast;
    @OneToMany(mappedBy = "movie")
    private Set<Comment> comments;
    @OneToOne
    @JoinColumn(name = "IMDB_ID", unique = true)
    private Imdb imdb;
}
