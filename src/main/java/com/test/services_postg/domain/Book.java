package com.test.services_postg.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private Long id;

    @Basic
    @Column
    private String title;

    @Basic
    @Column(name = "release_date")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @ManyToMany(
            fetch = FetchType.LAZY,
            mappedBy = "books"
    )
    private Set<Author> authors = new HashSet<>();

    @ManyToMany(
            fetch = FetchType.LAZY,
            mappedBy = "books"
    )
    private Set<User> users = new HashSet<>();
}
