DELETE FROM HR.ROLE r WHERE r.role in ('USER', 'ADMIN');
insert into HR.ROLE r (r.role) values ('ADMIN');
insert into HR.ROLE r (r.role) values ('USER');