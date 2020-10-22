package com.svyat.test.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "population")
public class Population implements Serializable {

    @Id
    private int id;

    @OneToMany(mappedBy="population")
    private List<Virus> viruses;

    @Column(name = "date_of_death")
    private Date dateOfDeath;

}
