# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table category (
  id                            integer not null,
  cat                           varchar(255) not null,
  name                          varchar(255) not null,
  constraint pk_category primary key (id)
);
create sequence category_seq;

create table country (
  id                            integer not null,
  name                          varchar(255) not null,
  fleet                         varchar(255) not null,
  constraint pk_country primary key (id)
);
create sequence country_seq;

create table ship (
  id                            bigint not null,
  category_id                   integer not null,
  country_id                    integer not null,
  name                          varchar(255) not null,
  summary                       TEXT not null,
  launch_date                   bigint not null,
  displacement                  integer not null,
  length                        double not null,
  width                         double not null,
  height                        double not null,
  draft                         double not null,
  engine                        varchar(255) not null,
  power                         integer not null,
  speed                         integer not null,
  distance                      integer not null,
  crew                          integer not null,
  arming                        TEXT not null,
  artillery                     varchar(255) not null,
  anti_air                      varchar(255) not null,
  air_group                     varchar(255) not null,
  constraint pk_ship primary key (id)
);
create sequence ship_seq;

create table user (
  email                         varchar(255) not null,
  hash                          varchar(255) not null,
  constraint pk_user primary key (email)
);

alter table ship add constraint fk_ship_category_id foreign key (category_id) references category (id) on delete restrict on update restrict;
create index ix_ship_category_id on ship (category_id);

alter table ship add constraint fk_ship_country_id foreign key (country_id) references country (id) on delete restrict on update restrict;
create index ix_ship_country_id on ship (country_id);


# --- !Downs

alter table ship drop constraint if exists fk_ship_category_id;
drop index if exists ix_ship_category_id;

alter table ship drop constraint if exists fk_ship_country_id;
drop index if exists ix_ship_country_id;

drop table if exists category;
drop sequence if exists category_seq;

drop table if exists country;
drop sequence if exists country_seq;

drop table if exists ship;
drop sequence if exists ship_seq;

drop table if exists user;

