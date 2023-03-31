CREATE SEQUENCE goods_seq;
CREATE SEQUENCE boards_seq;

CREATE TABLE accounts (
  accounts_id VARCHAR2(25),
  pw VARCHAR2(50),
  name VARCHAR2(100),
  address VARCHAR2(200),
  email VARCHAR2(50),
  temperature NUMBER(5),
  created_at DATE,
  deleted_at DATE,
    PRIMARY KEY (accounts_id)
);

CREATE TABLE boards (
  boards_id VARCHAR2(25),
  accounts_id VARCHAR2(20),
  main_category VARCHAR2(20),
  middle_category VARCHAR2(20),
  title VARCHAR2(50),
  content VARCHAR2(200),
  recommends NUMBER(5),
  views NUMBER(5),
  address VARCHAR2(200),
  created_at DATE,
  PRIMARY KEY (boards_id)
);
CREATE TABLE photos (
  photos_id VARCHAR2(25),
  name VARCHAR2(50),
  path VARCHAR2(500),
  created_at DATE,
  PRIMARY KEY (photos_id)
);

CREATE TABLE meetings (
  boards_id VARCHAR2(25),
  person NUMBER(2),
  meeting_date DATE,
  meeting_time DATE,
  place VARCHAR2(50),
  gender VARCHAR2(10),
  age NUMBER(2),
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
  favorites_id NUMBER(20),
  accounts_id VARCHAR2(25),
  godds_id NUMBER(20),
  created_at DATE,
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