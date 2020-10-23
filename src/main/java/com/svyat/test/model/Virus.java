package com.svyat.test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.svyat.test.util.PostgreSQLEnumType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@Table(name = "viruses")
@TypeDef(
        name = "VirusTypeEnum",
        typeClass = PostgreSQLEnumType.class
)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Virus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "virus_name")
    private String virusName;

    @Column(name = "infect_prob")
    private double infectProb;

    @Column(name = "infect_days_avg")
    private int infectDaysAvg;

    @Column(name = "death_rate")
    private double deathRate;

    @Column(name = "reinfection_chance")
    private double reinfectionChance;

    @Type(type = "VirusTypeEnum")
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private VirusType type;



    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    private Disease disease;

}
