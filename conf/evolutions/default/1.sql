# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table category (
  id                        integer not null,
  cat                       varchar(255) not null,
  name                      varchar(255) not null,
  constraint pk_category primary key (id))
;

create table country (
  id                        integer not null,
  name                      varchar(255) not null,
  fleet                     varchar(255) not null,
  constraint pk_country primary key (id))
;

create table ship (
  id                        bigint not null,
  category_id               integer not null,
  country_id                integer not null,
  name                      varchar(255) not null,
  manufacturer              varchar(255) not null,
  homeport                  varchar(255),
  status                    varchar(255) not null,
  summary                   TEXT not null,
  build_start               bigint not null,
  launch_date               bigint not null,
  commissioned_in           bigint not null,
  removed_from_fleet        bigint,
  displacement              integer not null,
  length                    double not null,
  width                     double not null,
  height                    double not null,
  draft                     double not null,
  power                     integer not null,
  speed                     integer not null,
  crew                      integer not null,
  arming                    TEXT not null,
  constraint pk_ship primary key (id))
;

create table user (
  email                     varchar(255) not null,
  hash                      varchar(255) not null,
  constraint pk_user primary key (email))
;

create sequence category_seq;

create sequence country_seq;

create sequence ship_seq;

create sequence user_seq;

alter table ship add constraint fk_ship_category_1 foreign key (category_id) references category (id) on delete restrict on update restrict;
create index ix_ship_category_1 on ship (category_id);
alter table ship add constraint fk_ship_country_2 foreign key (country_id) references country (id) on delete restrict on update restrict;
create index ix_ship_country_2 on ship (country_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists category;

drop table if exists country;

drop table if exists ship;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists category_seq;

drop sequence if exists country_seq;

drop sequence if exists ship_seq;

drop sequence if exists user_seq;

