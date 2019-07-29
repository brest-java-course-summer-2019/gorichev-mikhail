drop table if exists categories;

create table categories (
    category_id serial not null primary key ,
    category_name varchar(15) not null unique ,
    category_description varchar(30)
);

drop table if exists payments;

create table payments (
     payment_id serial not null primary key,
     payment_name varchar(20) not null unique,
     payment_description varchar(30),
     payment_cost numeric not null,
     category_id int references categories(category_id)
);

