package com.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

/**
 * The User POJO class.
 */
@Getter
@Setter
@Entity
@Table(name = "user")
@NamedEntityGraph(name = "user-graph",
        attributeNodes = {
                @NamedAttributeNode("comments")
        })
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private long id;
    @NotNull
    @Column(name = "FIRST_NAME")
    private String firstName;
    @NotNull
    @Column(name = "LAST_NAME")
    private String lastName;
    @NotNull
    @Email
    @Column(name = "EMAIL", unique = true)
    private String email;
    @NotNull
    @Column(name = "PASSWORD")
    private String password;
    @OneToMany(mappedBy = "user")
    private Set<Comment> comments;
}
