
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

-- boards 테이블 더미 -
insert into boards (boards_id, accounts_id, main_category, sub_category, title, content, address)
values('b1', 'Tester', '같이해요', '산책', '종로3가 산책같이해요', '혼자 산책하기 심심한데 같이 산책해요', '서울시 종로구');
insert into boards (boards_id, accounts_id, main_category, sub_category, title, content, address)
values('b2', 'Men', '같이해요', '기타', '전단지 알바하실분?', '전단지 알바 빌딩 나눠서 같이하실분 구해요', '서울시 종로구');
insert into boards (boards_id, accounts_id, main_category, sub_category, title, content, address)
values('b3', 'Women', '같이해요', '밥/카페', '카페에서 같이 책읽어요!', '종로3가 근처에 좋은 카페 있어요', '서울시 종로구');
insert into boards (boards_id, accounts_id, main_category, sub_category, title, content, address)
values('b4', 'Baby', '같이해요', '밥/카페', '응애 나 애기 밥죠!', '배고파ㅏㅏㅏ', '서울시 종로구');
insert into boards (boards_id, accounts_id, main_category, sub_category, title, content, address)
values('b5', 'Boy', '같이해요', '밥/카페', '중간고사 시험 공부 같이해요', '같이 빡공합시다', '서울시 종로구');
insert into boards (boards_id, accounts_id, main_category, sub_category, title, content, address)
values('b6', 'Girl', '동네생활', '동네맛집', '같이 점심 드실분 있나요?', '혼밥하기 좀 그런데 같이 먹어요!', '서울시 종로구');
insert into boards (boards_id, accounts_id, main_category, sub_category, title, content, address)
values('b7', 'test', '동네생활', '일상', '테스트 하실분 구함', '진짜 아무나 하실수 있어요 같이해요', '서울시 종로구'); 

-- meetings 테이블 더미 -
insert into meetings (boards_id, person, meeting_date, meeting_time_ampm, meeting_time_hour, meeting_time_minute, place, gender, age)
values('b1', 4, '2021-11-12','오전', '11시', '19분', '산책로', '누구나', '20대');
insert into meetings (boards_id, person, meeting_date, meeting_time_ampm, meeting_time_hour, meeting_time_minute, place, gender, age)
values('b2', 4, '2021-11-12','오전', '11시', '30분', 'XX아파트', '여자만', '20대');
insert into meetings (boards_id, person, meeting_date, meeting_time_ampm, meeting_time_hour, meeting_time_minute, place, gender, age)
values('b3', 4, '2021-11-12','오전', '11시', '30분', '스타벅스', '여자만', '20대');
insert into meetings (boards_id, person, meeting_date, meeting_time_ampm, meeting_time_hour, meeting_time_minute, place, gender, age)
values('b4', 4, '2021-11-12','오후', '12시', '30분', '유치원', '누구나', '20대');
insert into meetings (boards_id, person, meeting_date, meeting_time_ampm, meeting_time_hour, meeting_time_minute, place, gender, age)
values('b5', 4, '2021-11-12','오후', '12시', '30분', '스터디카페', '누구나', '20대');

-- photos 테이블 더미 --
insert into photos values('a100', 'logo.jpg', 'src/main/java/com/fx/market/source/image/logo.jpg', SYSDATE);
insert into photos values('a101', 'logo.jpg', 'src/main/java/com/fx/market/source/image/logo.jpg', SYSDATE);
insert into photos values('a102', 'logo.jpg', 'src/main/java/com/fx/market/source/image/logo.jpg', SYSDATE);
insert into photos values('a103', 'logo.jpg', 'src/main/java/com/fx/market/source/image/logo.jpg', SYSDATE);
insert into photos values('a104', 'logo.jpg', 'src/main/java/com/fx/market/source/image/logo.jpg', SYSDATE);
insert into photos values('a105', 'logo.jpg', 'src/main/java/com/fx/market/source/image/logo.jpg', SYSDATE);
insert into photos values('g100', 'logo.jpg', 'src/main/java/com/fx/market/source/image/logo.jpg', SYSDATE);
insert into photos values('g101', 'logo.jpg', 'src/main/java/com/fx/market/source/image/logo.jpg', SYSDATE);
insert into photos values('g102', 'logo.jpg', 'src/main/java/com/fx/market/source/image/logo.jpg', SYSDATE);
insert into photos values('g103', 'logo.jpg', 'src/main/java/com/fx/market/source/image/logo.jpg', SYSDATE);
insert into photos values('g104', 'logo.jpg', 'src/main/java/com/fx/market/source/image/logo.jpg', SYSDATE);
insert into photos values('b1', 'logo.jpg', 'src/main/java/com/fx/market/source/image/logo.jpg', SYSDATE);
insert into photos values('b2', 'logo.jpg', 'src/main/java/com/fx/market/source/image/logo.jpg', SYSDATE);
insert into photos values('b3', 'logo.jpg', 'src/main/java/com/fx/market/source/image/logo.jpg', SYSDATE);
insert into photos values('b4', 'logo.jpg', 'src/main/java/com/fx/market/source/image/logo.jpg', SYSDATE);
insert into photos values('b5', 'logo.jpg', 'src/main/java/com/fx/market/source/image/logo.jpg', SYSDATE);
insert into photos values('b6', 'logo.jpg', 'src/main/java/com/fx/market/source/image/logo.jpg', SYSDATE);
insert into photos values('b7', 'logo.jpg', 'src/main/java/com/fx/market/source/image/logo.jpg', SYSDATE);
