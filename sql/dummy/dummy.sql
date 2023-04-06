-- sequence update -- 
DROP sequence "BOARDS_SEQ";
DROP sequence "FAVORITES_SEQ";
DROP sequence "GOODS_SEQ";

CREATE SEQUENCE goods_seq START WITH 10;
CREATE SEQUENCE boards_seq START WITH 10;
CREATE SEQUENCE favorites_seq START WITH 10;

-- Accounts --
Insert into ACCOUNTS (ACCOUNTS_ID,PW,NAME,ADDRESS,EMAIL,TEMPERATURE,CREATED_AT,DELETED_AT) values ('rlagptjd','1111','김혜성','서울시 은평구','rlagptjd2002@naver.com',36.5,to_date('23/04/06','RR/MM/DD'),null);
Insert into ACCOUNTS (ACCOUNTS_ID,PW,NAME,ADDRESS,EMAIL,TEMPERATURE,CREATED_AT,DELETED_AT) values ('wkdwodnd','1111','장재웅','서울시 강남구','wkdwodnd@naver.com',36.5,to_date('23/04/06','RR/MM/DD'),null);
Insert into ACCOUNTS (ACCOUNTS_ID,PW,NAME,ADDRESS,EMAIL,TEMPERATURE,CREATED_AT,DELETED_AT) values ('rlaehdals','1111','김동민','서울시 강동구','rlaehdals@naver.com',36.5,to_date('23/04/06','RR/MM/DD'),null);
Insert into ACCOUNTS (ACCOUNTS_ID,PW,NAME,ADDRESS,EMAIL,TEMPERATURE,CREATED_AT,DELETED_AT) values ('chlgksxo','1111','최한태','서울시 서초구','chlgksxo@naver.com',37.5,to_date('23/04/06','RR/MM/DD'),null);
Insert into ACCOUNTS (ACCOUNTS_ID,PW,NAME,ADDRESS,EMAIL,TEMPERATURE,CREATED_AT,DELETED_AT) values ('rlaxodud','1111','김태영','서울시 송파구','rlaxodud@naver.com',36.5,to_date('23/04/06','RR/MM/DD'),null);

-- Boards --
Insert into BOARDS (BOARDS_ID,ACCOUNTS_ID,MAIN_CATEGORY,SUB_CATEGORY,TITLE,CONTENT,RECOMMENDS,VIEWS,ADDRESS,CREATED_AT) values ('b2','rlagptjd','동네생활','동네맛집','사케동 맛집 공유합니다.','사케동 뿐만이 아니라 모든 메뉴 맛있어요!',0,0,null,to_date('23/04/06','RR/MM/DD'));
Insert into BOARDS (BOARDS_ID,ACCOUNTS_ID,MAIN_CATEGORY,SUB_CATEGORY,TITLE,CONTENT,RECOMMENDS,VIEWS,ADDRESS,CREATED_AT) values ('b4','rlaxodud','동네생활','동네맛집','종로구 짜장면 맛집 소개합니다.','깨끗하고 맛있어요!',0,0,null,to_date('23/04/06','RR/MM/DD'));
Insert into BOARDS (BOARDS_ID,ACCOUNTS_ID,MAIN_CATEGORY,SUB_CATEGORY,TITLE,CONTENT,RECOMMENDS,VIEWS,ADDRESS,CREATED_AT) values ('b3','rlaehdals','같이해요','러닝','종로구 러닝','새벽에 러닝 한시간 하실분 모집합니다.',0,0,'서울시 강동구',to_date('23/04/06','RR/MM/DD'));
Insert into BOARDS (BOARDS_ID,ACCOUNTS_ID,MAIN_CATEGORY,SUB_CATEGORY,TITLE,CONTENT,RECOMMENDS,VIEWS,ADDRESS,CREATED_AT) values ('b5','wkdwodnd','같이해요','스터디','자바 스터디 구해요!','같이 스터디 카페에서 공부하실분!',0,0,'서울시 강남구',to_date('23/04/06','RR/MM/DD'));
Insert into BOARDS (BOARDS_ID,ACCOUNTS_ID,MAIN_CATEGORY,SUB_CATEGORY,TITLE,CONTENT,RECOMMENDS,VIEWS,ADDRESS,CREATED_AT) values ('b1','rlagptjd','같이해요','밥/카페','자바 공부 같이 해요','명지대 달콤 커피에서 1시~4시까지 같이 공부하실분 찾아요!',0,0,'서울시 은평구',to_date('23/04/06','RR/MM/DD'));

-- goods --
Insert into GOODS (GOODS_ID,ACCOUNTS_ID,TITLE,CONTENT,ADDRESS,PRICE,SALED_ID,SALE,GRADE,RECOMMENDS,VIEWS,CREATED_AT) values ('g1','rlagptjd','감귤 한 박스 팝니다.','제주에서 4월6일에 가져온 감귤 한 박스입니다','서울시 은평구',15000,null,null,null,3,3,to_date('23/04/06','RR/MM/DD'));
Insert into GOODS (GOODS_ID,ACCOUNTS_ID,TITLE,CONTENT,ADDRESS,PRICE,SALED_ID,SALE,GRADE,RECOMMENDS,VIEWS,CREATED_AT) values ('g5','chlgksxo','애플워치4, 44mm, 셀룰러','풀박스, 충전기 있음, 하자 없음, 화/목 17:00 이후 가능합니다.','서울시 강남구',180000,null,null,null,0,null,to_date('23/04/06','RR/MM/DD'));
Insert into GOODS (GOODS_ID,ACCOUNTS_ID,TITLE,CONTENT,ADDRESS,PRICE,SALED_ID,SALE,GRADE,RECOMMENDS,VIEWS,CREATED_AT) values ('g7','rlaxodud','Z플립3 256G 팝니다.','정상해지 하고 공장 초기화 해놨습니다. 박스+본품이고 케이블은 없습니다.','서울시 송파구',370000,null,null,null,0,1,to_date('23/04/06','RR/MM/DD'));
Insert into GOODS (GOODS_ID,ACCOUNTS_ID,TITLE,CONTENT,ADDRESS,PRICE,SALED_ID,SALE,GRADE,RECOMMENDS,VIEWS,CREATED_AT) values ('g6','chlgksxo','에어팟 3세대','박스가 없습니다. 상태는 최상급입니다.','서울시 강남구',120000,'wkdwodnd','TRUE',4,0,1,to_date('23/04/06','RR/MM/DD'));
Insert into GOODS (GOODS_ID,ACCOUNTS_ID,TITLE,CONTENT,ADDRESS,PRICE,SALED_ID,SALE,GRADE,RECOMMENDS,VIEWS,CREATED_AT) values ('g2','chlgksxo','아이폰 14 256G 판매합니다.','새제품 미개봉 / 시중154~170으로 알고 있습니다. 2023년 1월 생산 제품입니다.','서울시 강남구',1500000,null,null,null,0,null,to_date('23/04/06','RR/MM/DD'));
Insert into GOODS (GOODS_ID,ACCOUNTS_ID,TITLE,CONTENT,ADDRESS,PRICE,SALED_ID,SALE,GRADE,RECOMMENDS,VIEWS,CREATED_AT) values ('g8','wkdwodnd','madcatz r a t pro x3 supreme 팝니다','미개봉입니다','서울시 강남구',100000,null,null,null,0,null,to_date('23/04/06','RR/MM/DD'));
Insert into GOODS (GOODS_ID,ACCOUNTS_ID,TITLE,CONTENT,ADDRESS,PRICE,SALED_ID,SALE,GRADE,RECOMMENDS,VIEWS,CREATED_AT) values ('g3','chlgksxo','아이패드 프로 12.9 6세대','12월에 구매했고, 3개월 사용했습니다. 거의 새제품이나 다름없습니다.','서울시 강남구',1320000,'wkdwodnd','TRUE',4,0,1,to_date('23/04/06','RR/MM/DD'));
Insert into GOODS (GOODS_ID,ACCOUNTS_ID,TITLE,CONTENT,ADDRESS,PRICE,SALED_ID,SALE,GRADE,RECOMMENDS,VIEWS,CREATED_AT) values ('g4','chlgksxo','맥북 16인치 고급형 팝니다.','필요하시면 쓰던 허브 같이 드립니다. 애플 케어플러스 기간 남아있습니다. 박스 있습니다.','서울시 강남구',1500000,null,null,null,1,1,to_date('23/04/06','RR/MM/DD'));

-- meetings --
Insert into MEETINGS (BOARDS_ID,STATE,PERSON,MEETING_DATE,MEETING_TIME_AMPM,MEETING_TIME_HOUR,MEETING_TIME_MINUTE,PLACE,GENDER,AGE) values ('b3','모집중','10',to_date('23/04/08','RR/MM/DD'),'오전','6시','30분','종로3가역 앞 단성사 1층 로비','누구나','20~40');
Insert into MEETINGS (BOARDS_ID,STATE,PERSON,MEETING_DATE,MEETING_TIME_AMPM,MEETING_TIME_HOUR,MEETING_TIME_MINUTE,PLACE,GENDER,AGE) values ('b5','모집중','3',to_date('23/04/12','RR/MM/DD'),'오후','4시','30분','종로3가역 단성사 5층','누구나','20~33');
Insert into MEETINGS (BOARDS_ID,STATE,PERSON,MEETING_DATE,MEETING_TIME_AMPM,MEETING_TIME_HOUR,MEETING_TIME_MINUTE,PLACE,GENDER,AGE) values ('b1','모집중','4',to_date('23/04/09','RR/MM/DD'),'오후','1시','10분','달콤 커피 명지대점','누구나','20~35');

-- meeting_attendees --
Insert into MEETING_ATTENDEES (BOARDS_ID,ACCOUNTS_ID) values ('b1','chlgksxo');
Insert into MEETING_ATTENDEES (BOARDS_ID,ACCOUNTS_ID) values ('b3','rlaxodud');

-- favorites --
Insert into FAVORITES (FAVORITES_ID,ACCOUNTS_ID,GOODS_ID,CREATED_AT) values ('f2','rlaehdals','g1',to_date('23/04/06','RR/MM/DD'));
Insert into FAVORITES (FAVORITES_ID,ACCOUNTS_ID,GOODS_ID,CREATED_AT) values ('f3','rlaehdals','g4',to_date('23/04/06','RR/MM/DD'));
Insert into FAVORITES (FAVORITES_ID,ACCOUNTS_ID,GOODS_ID,CREATED_AT) values ('f1','chlgksxo','g1',to_date('23/04/06','RR/MM/DD'));
Insert into FAVORITES (FAVORITES_ID,ACCOUNTS_ID,GOODS_ID,CREATED_AT) values ('f4','wkdwodnd','g1',to_date('23/04/06','RR/MM/DD'));

-- photos --
Insert into PHOTOS (PHOTOS_ID,NAME,PATH,CREATED_AT) values ('b2','b2히사시돈부리.jpg','src/main/java/com/fx/market/source/image/b2히사시돈부리.jpg',to_date('23/04/06','RR/MM/DD'));
Insert into PHOTOS (PHOTOS_ID,NAME,PATH,CREATED_AT) values ('g6','g6','src/main/java/com/fx/market/source/image/g6.jpg',to_date('23/04/06','RR/MM/DD'));
Insert into PHOTOS (PHOTOS_ID,NAME,PATH,CREATED_AT) values ('b4','b4중국집.jpg','src/main/java/com/fx/market/source/image/b4중국집.jpg',to_date('23/04/06','RR/MM/DD'));
Insert into PHOTOS (PHOTOS_ID,NAME,PATH,CREATED_AT) values ('rlagptjd','default.jpg','src/main/java/com/fx/market/source/image/default.jpg',to_date('23/04/06','RR/MM/DD'));
Insert into PHOTOS (PHOTOS_ID,NAME,PATH,CREATED_AT) values ('wkdwodnd','default.jpg','src/main/java/com/fx/market/source/image/default.jpg',to_date('23/04/06','RR/MM/DD'));
Insert into PHOTOS (PHOTOS_ID,NAME,PATH,CREATED_AT) values ('rlaehdals','default.jpg','src/main/java/com/fx/market/source/image/default.jpg',to_date('23/04/06','RR/MM/DD'));
Insert into PHOTOS (PHOTOS_ID,NAME,PATH,CREATED_AT) values ('g2','g2','src/main/java/com/fx/market/source/image/g2.jpg',to_date('23/04/06','RR/MM/DD'));
Insert into PHOTOS (PHOTOS_ID,NAME,PATH,CREATED_AT) values ('g8','g8','src/main/java/com/fx/market/source/image/g8.jpg',to_date('23/04/06','RR/MM/DD'));
Insert into PHOTOS (PHOTOS_ID,NAME,PATH,CREATED_AT) values ('g3','g3','src/main/java/com/fx/market/source/image/g3.jpg',to_date('23/04/06','RR/MM/DD'));
Insert into PHOTOS (PHOTOS_ID,NAME,PATH,CREATED_AT) values ('chlgksxo','default.jpg','src/main/java/com/fx/market/source/image/default.jpg',to_date('23/04/06','RR/MM/DD'));
Insert into PHOTOS (PHOTOS_ID,NAME,PATH,CREATED_AT) values ('g4','g4','src/main/java/com/fx/market/source/image/g4.jpg',to_date('23/04/06','RR/MM/DD'));
Insert into PHOTOS (PHOTOS_ID,NAME,PATH,CREATED_AT) values ('rlaxodud','default.jpg','src/main/java/com/fx/market/source/image/default.jpg',to_date('23/04/06','RR/MM/DD'));
Insert into PHOTOS (PHOTOS_ID,NAME,PATH,CREATED_AT) values ('g1','g1','src/main/java/com/fx/market/source/image/g1.jpg',to_date('23/04/06','RR/MM/DD'));
Insert into PHOTOS (PHOTOS_ID,NAME,PATH,CREATED_AT) values ('g5','g5','src/main/java/com/fx/market/source/image/g5.jpg',to_date('23/04/06','RR/MM/DD'));
Insert into PHOTOS (PHOTOS_ID,NAME,PATH,CREATED_AT) values ('g7','g7','src/main/java/com/fx/market/source/image/g7.jpg',to_date('23/04/06','RR/MM/DD'));
