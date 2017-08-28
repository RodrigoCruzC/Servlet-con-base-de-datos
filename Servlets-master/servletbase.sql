drop database if exists servletbase;
create database servletbase;
use servletbase;
create table datos(
	usr nvarchar(20) not null primary key,
    pass nvarchar(20) not null
);
select * from datos;

insert into datos values('nom','pass');
insert into datos values('daniela','1234');
