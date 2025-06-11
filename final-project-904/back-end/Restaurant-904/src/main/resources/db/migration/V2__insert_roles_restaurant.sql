DELETE FROM hr.ROLE_ENTITY r WHERE r.CODE in ('USER', 'ADMIN');
insert into hr.ROLE_ENTITY r (r.CODE) values ('ADMIN');
insert into hr.ROLE_ENTITY r (r.CODE) values ('USER');