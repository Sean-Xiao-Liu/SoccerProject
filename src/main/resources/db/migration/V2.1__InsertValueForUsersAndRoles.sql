insert into role (name, allowed_resource, allowed_read, allowed_create, allowed_update, allowed_delete) values
('Admin', '/', 'Y', 'Y', 'Y', 'Y'),
('user', '/teams,/games,/players', 'Y', 'N', 'N', 'N')
;
commit;
insert into users (name, password, first_name, last_name, email) values
('dwang', '25f9e794323b453885f5181f1b624d0b', 'David', 'Wang', 'dwang@ascending.com'),
('rhang', '25f9e794323b453885f5181f1b624d0b', 'Ryo', 'Hang', 'rhang@ascending.com'),
('xyhuang', '25f9e794323b453885f5181f1b624d0b', 'Xinyue', 'Huang', 'xyhuang@ascending.com')
;
commit;
insert into users_role values
(1, 1),
(2, 2),
(1, 2)
;
commit;