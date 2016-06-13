# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table category (
  id                            serial not null,
  cat                           varchar(255) not null,
  name                          varchar(255) not null,
  constraint pk_category primary key (id)
);

create table country (
  id                            serial not null,
  name                          varchar(255) not null,
  fleet                         varchar(255) not null,
  constraint pk_country primary key (id)
);

create table ships (
  id                            bigserial not null,
  category_id                   integer not null,
  country_id                    integer not null,
  name                          varchar(255) not null,
  summary                       TEXT not null,
  launch_date                   bigint not null,
  displacement                  integer not null,
  length                        float not null,
  width                         float not null,
  height                        float not null,
  draft                         float not null,
  engine                        varchar(255) not null,
  power                         integer not null,
  speed                         integer not null,
  distance                      integer not null,
  crew                          integer not null,
  arming                        TEXT not null,
  artillery                     varchar(255) not null,
  anti_air                      varchar(255) not null,
  air_group                     varchar(255) not null,
  constraint pk_ships primary key (id)
);

create table users (
  email                         varchar(255) not null,
  hash                          varchar(255) not null,
  constraint pk_users primary key (email)
);

alter table ships add constraint fk_ships_category_id foreign key (category_id) references category (id) on delete restrict on update restrict;
create index ix_ships_category_id on ships (category_id);

alter table ships add constraint fk_ships_country_id foreign key (country_id) references country (id) on delete restrict on update restrict;
create index ix_ships_country_id on ships (country_id);


# --- !Downs

alter table ships drop constraint if exists fk_ships_category_id;
drop index if exists ix_ships_category_id;

alter table ships drop constraint if exists fk_ships_country_id;
drop index if exists ix_ships_country_id;

drop table if exists category cascade;

drop table if exists country cascade;

drop table if exists ships cascade;

drop table if exists users cascade;

