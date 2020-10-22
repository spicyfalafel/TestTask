create type "VirusType" as enum ('RNA', 'DNA', 'RETROVIRUS');

create table viruses
(
    type               "VirusType",
    virus_name         varchar,
    infect_prob        double precision,
    infect_days_avg    integer,
    death_rate         double precision,
    reinfection_chance double precision,
    id                 serial not null
        constraint "Viruses_pkey"
            primary key
);

create table population
(
    "ID"          integer not null
        constraint population_pkey
            primary key,
    date_of_death date
);

create table deseases
(
    date_of_infection date,
    virus_id          integer,
    virus_stage       varchar,
    id                integer not null
        constraint deseases_pkey
            primary key
);