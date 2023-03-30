ALTER TABLE meetings
ADD CONSTRAINT boards_id foreign KEY(boards_id) references meetings (boards_id);


--제약 조건을 걸때, 주키가 있는 테이블이 삭제되면 외래키가 있는 테이블도 삭제되게 하기 위해 외래키 제약을 건다

ALTER TABLE comments
ADD CONSTRAINT boards_id foreign KEY(boards_id) references boards (boards_id);

ALTER TABLE comments
ADD CONSTRAINT accounts_id2 foreign KEY(accounts_id) references accounts(accounts_id); 


ALTER TABLE boards
ADD CONSTRAINT accounts_id foreign Key(accounts_id) references accounts(accounts_id); 


ALTER TABLE favorites
ADD CONSTRAINT accounts_id3 foreign key(accounts_id) references accounts(accounts_id);

ALTER TABLE favorites
ADD CONSTRAINT accounts_id4 foreign key(accounts_id) references goods(goods_id);

--alter table favorites drop CONSTRAINT acooints_id4;

ALTER table goods
add constraint accounts_id5 foreign key(accounts_id) REFERENCES accounts(accounts_id);

commit;
--alter table goods drop constraint ACCOUNTS_ID5;