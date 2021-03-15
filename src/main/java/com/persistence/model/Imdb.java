package com.persistence.model;

import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * The IMDB (Internet Movie Database) POJO class.
 */
@Data
@Entity
@Table(name = "IMDB")
public class Imdb implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IMDB_ID", unique = true)
    private long id;
    @NotNull
    @Column(name = "RATING")
    private int rating;
    @NotNull
    @Column(name = "VOTES")
    private int votes;
}
