INSERT INTO role (name) VALUES
	('user'),
	('admin');

INSERT INTO users (email, password, role_id, first_name, second_name, rating) VALUES
	('123@mail.ru', 'qwe', 1, 'user', 'user', 0),
	('321@mail.ru', 'qwe', 1, 'user', 'user', 0),
	('333@mail.ru', 'qwe', 2, 'user', 'user', 0),
	('222@mail.ru', 'qwe', 2, 'user', 'user', 0),
	('111@mail.ru', 'qwe', 2, 'user', 'user', 0);

INSERT INTO lot_category (name) VALUES
	('key'),
	('account');

INSERT INTO lot (name, description, bid, finish_date, category_id, seller_id) VALUES
	('dota2', '', 100, '2018-9-12', 2, 1),
	('cs:go', '', 200, '2018-9-12', 1, 2),
	('cod', '', 1000, '2018-9-12', 1, 3),
	('fifa', '', 250, '2018-9-12', 2, 4);