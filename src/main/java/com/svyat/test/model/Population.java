package com.svyat.test.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "population")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Population implements Serializable {

    @Id
    private BigInteger populationId;

    @OneToMany(mappedBy="population")
    private List<Disease> diseases;

    @Column(name = "date_of_death")
    private Date dateOfDeath;

}
