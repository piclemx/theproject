INSERT INTO credit_card (card_number,expiration_date,card_type) VALUES ('4916432296478696', '02/16','visa');
INSERT INTO credit_card (card_number,expiration_date,card_type) VALUES ('4539536574851', '02/16','visa');
INSERT INTO credit_card (card_number,expiration_date,card_type) VALUES ('5562028007350036', '02/16','generic');

INSERT INTO account (account_id,credit_limit,card_number) VALUES(1,1200,'4916432296478696');
INSERT INTO account (account_id,credit_limit,card_number) VALUES(2,1200,'4539536574851');
INSERT INTO account (account_id,credit_limit,card_number) VALUES(3,1200,'5562028007350036');

insert into vendor (identifier, vendor_id)  values ('M47352424', 1);
insert into vendor (identifier, vendor_id) values ('M83635636',2);
insert into terminal(identifier , terminal_id) values ('T36735353',1);
insert into terminal(identifier , terminal_id) values ('T37415244',2);
insert into terminal(identifier , terminal_id) values ('T36353531',3);

insert into vendor_terminal ( Vendor_vendor_id ,terminals_terminal_id) values (1,1);
insert into vendor_terminal ( Vendor_vendor_id ,terminals_terminal_id) values (1,2);
insert into vendor_terminal ( Vendor_vendor_id ,terminals_terminal_id) values (2,3);

update terminal set vendor_id = 1 where terminal_id = 1;
update terminal set vendor_id = 1 where terminal_id = 2;
update terminal set vendor_id = 2 where terminal_id = 3;
