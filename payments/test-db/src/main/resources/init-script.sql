insert into categories (category_id, category_name, category_description) values (1, 'Social', 'Social Payments');
insert into categories (category_id, category_name, category_description) values (2, 'Medicine', 'Medicine Payments');
insert into categories (category_id, category_name, category_description) values (3, 'Tax', 'Tax Payments');
insert into categories (category_id, category_name, category_description) values (4, 'Education', 'Education Payments');

insert into payments (payment_id, payment_name, payment_description, payment_cost, category_id) values (1, 'Cinema', 'Payment for cinema.', 200, 1);
insert into payments (payment_id, payment_name, payment_description, payment_cost, category_id) values (2, 'Coffee', 'Payment for coffee.', 100, 1);
insert into payments (payment_id, payment_name, payment_description, payment_cost, category_id) values (3, 'Home Tax', 'Communal payment.', 700, 3);
insert into payments (payment_id, payment_name, payment_description, payment_cost, category_id) values (4, 'Drive Tax', 'Payment for driving', 300, 3);
insert into payments (payment_id, payment_name, payment_description, payment_cost, category_id) values (5, 'Education in BSTU', 'Payment for education in BSTU', 300, 4);

