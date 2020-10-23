package com.svyat.test.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "diseases")
public class Disease implements Serializable {

    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name="virus_id", nullable=false)
    private Virus virus;

    @ManyToOne
    @JoinColumn(name="population_id", nullable=false)
    private Population population;

    @Column(name = "date_of_infection")
    private Date dateOfInfection;
    @Column(name = "virus_stage")
    private String virusStage;
}
