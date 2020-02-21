create database rybakovaLibrary;

use rybakovaLibrary;

create table book(
	id int auto_increment primary key,
    title varchar(63) not null,
    author varchar(63)
);
insert into book values 
	(null, 'Война и мир', 'Лев Толстой'),
	(null, '1984', 'Джордж Оруэлл'),
	(null, 'Улисс', 'Джеймс Джойс'),
	(null, 'Лолита', 'Владимир Набоков'),
	(null, 'Миддлмарч', 'Джордж Элиот'),
	(null, 'Шум и ярость', 'Уильям Фолкнер'),
	(null, 'Невидимка', 'Ральф Эллисон');