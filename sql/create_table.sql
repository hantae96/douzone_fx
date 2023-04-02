CREATE SEQUENCE goods_seq;
CREATE SEQUENCE boards_seq;
CREATE SEQUENCE favorites_seq;

CREATE TABLE accounts (
  accounts_id VARCHAR2(25),
  pw VARCHAR2(50),
  name VARCHAR2(100),
  address VARCHAR2(200),
  email VARCHAR2(50),
  temperature NUMBER(4,1) default 36.5,
  created_at DATE,
  deleted_at DATE,
    PRIMARY KEY (accounts_id)
);

/* 2023-03-31 변경 */
CREATE TABLE boards (
  boards_id VARCHAR2(25),
  accounts_id VARCHAR2(20),
  main_category VARCHAR2(20),
  sub_category VARCHAR2(20),
  title VARCHAR2(50),
  content VARCHAR2(200),
  address VARCHAR2(50),
  recommends NUMBER(5) default 0,
  views NUMBER(5) default 0,
  created_at DATE default sysdate,
  PRIMARY KEY (boards_id)
);

CREATE TABLE photos (
  photos_id VARCHAR2(25),
  name VARCHAR2(50),
  path VARCHAR2(500),
  created_at DATE,
  PRIMARY KEY (photos_id)
);

/* 2023-03-31 변경 */
CREATE TABLE meetings (
  boards_id VARCHAR2(25),
  person VARCHAR2(10),
  meeting_date Date,
  meeting_time_ampm VARCHAR2(6),
  meeting_time_hour VARCHAR2(6),
  meeting_time_minute VARCHAR2(6),
  place VARCHAR2(50),
  gender VARCHAR2(10),
  age VARCHAR2(10),
  PRIMARY KEY (boards_id)
);

CREATE TABLE comments (
  comments_Id NUMBER(20),
  accounts_id VARCHAR2(25),
  boards_id VARCHAR2(25),
  content VARCHAR2(200),
  writer VARCHAR2(25),
  target VARCHAR2(25),
  dept NUMBER(2),
  created_at DATE,
  PRIMARY KEY (comments_Id)
);

CREATE TABLE favorites (
  favorites_id VARCHAR2(25),
  accounts_id VARCHAR2(25),
  goods_id VARCHAR2(25),
  created_at DATE default sysdate,
  PRIMARY KEY (favorites_id)
);

CREATE TABLE Goods (
  goods_id VARCHAR2(25),
  accounts_id VARCHAR2(50),
  title VARCHAR2(100),
  content VARCHAR2(200),
  address VARCHAR2(100),
  price NUMBER(25),
  saled_id VARCHAR2(25),
  sale VARCHAR2(5),
  grade NUMBER(2),
  recommends NUMBER(5),
  views NUMBER(5),
  created_at DATE,
  PRIMARY KEY (goods_id)
);

commit;