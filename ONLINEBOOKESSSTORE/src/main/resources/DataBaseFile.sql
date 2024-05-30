create database bookstore;
   use bookstore;
   
   drop table user;
   
    create table user (                                 
    user_id int auto_increment,
    user_name varchar(255),
	password varchar(255),
    email_id varchar(255),
    phone_no varchar(255),
    first_name varchar(255),
    last_name varchar(255),
    primary key(user_id)
    );
    
	create table books (                                 
    book_id int auto_increment,
    book_name varchar(255),
	book_author varchar(255),
    no_of_pages int,
    genere varchar(255),
    price int,
    primary key(book_id)
    );
    
     create table read_later (     
      read_later_id int auto_increment primary key,
      book_id int,
      book_name varchar(255),
      user_id int
      );
       
	create table like_section (     
	like_section_id int auto_increment primary key,
	book_id int,
	book_name varchar(255),
	user_id int
	);
       
create table data(
 id int primary key,
 user_name varchar(255)
 );
 

select * from like_section;
select * from read_later;
select * from user;
select * from books;