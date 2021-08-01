create sequence if not exists hibernate_sequence start 1 increment 1;

create table if not exists cats(
     id int4 not null,
     name varchar(255),
     age_in_months int,
     primary key(id)
)

insert into cats (id,name,age_in_months) values (nextval('hibernate_sequence'),'Toby',4)