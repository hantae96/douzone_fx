
-- 어카운트 테이블 더미--
insert into accounts(accounts_id,pw,name,address) 
values ('a100','1234','애플 사과농장 주인','서울시 종로구');
insert into accounts(accounts_id,pw,name,address) 
values ('a101','5678','신발 구멍 난놈','서울시 종로구');
insert into accounts(accounts_id,pw,name,address) 
values ('a102','1234','구라쟁이','서울시 강남구');
insert into accounts(accounts_id,pw,name,address) 
values ('a103','1234','길거리의 음악가','서울시 강북구');
insert into accounts(accounts_id,pw,name,address) 
values ('a104','1234','중고나라 VIP','서울시 강남구');
insert into accounts(accounts_id,pw,name,address) 
values ('a105','1234','개발자가  상팔자','서울시 강남구');

-- goods 테이블 더미-
insert into goods(goods_id,accounts_id,title,content,address,price,saled_id,recommends) 
values ('g100','a100','에어팟 2세대','상태 양호합니다.','서울시 종로구',200000,'a105',5);
insert into goods(goods_id,accounts_id,title,content,address,price,saled_id) 
values ('g101','a101','뉴발란스 퓨른 풋살화','구매후 한번 신었는데 사이즈 미스로 판매합니다.','서울시 성북구',50000,'a103');
insert into goods(goods_id,accounts_id,title,content,address,price,saled_id,recommends) 
values ('g102','a103','에어팟 맥스 실버 팔아요','케이스 커버 다 씌우고 다녀서 오염없이 깨끗합니다.','서울시 종로구',520000,'a107',11);
insert into goods(goods_id,accounts_id,title,content,address,price,saled_id) 
values ('g103','a104','(새상품급) 입문용 우쿠렐레 코나 판매','안녕하세요 우쿨렐레 새상품을 몇개 가지고 있어서 판매하려고 합니다.\n 정가로 18000원인데 싸게 해드릴게요','서울시 서초구',160000,'a100');
insert into goods(goods_id,accounts_id,title,content,address,price,saled_id,recommends) 
values ('g104','a105','아이패드 에어5','새상품입니다.','서울시 강북구',7800000,'a105',1);


-- 좋아요 테이블 더미-
insert into favorites (favorites_id,accounts_id,goods_id) values (concat('f',favorites_seq.nextval),'a100','g100');

commit;