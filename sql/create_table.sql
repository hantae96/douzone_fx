CREATE SEQUENCE goods_seq;
CREATE SEQUENCE boards_seq;
CREATE SEQUENCE favorites_seq;

CREATE TABLE accounts (                 -- 계정
  accounts_id VARCHAR2(25),             -- 계정 ID
  pw VARCHAR2(50),                      -- 계정 비밀번호
  name VARCHAR2(100),                   -- 계정 이름(닉네임)
  address VARCHAR2(200),                -- 계정 주소
  email VARCHAR2(50),                   -- 계정 이메일
  temperature NUMBER(4,1) default 36.5, -- 계정 온도
  created_at DATE DEFAULT SYSDATE,      -- 계정 생성 일자
  deleted_at DATE,                      -- 계정 탈퇴 일자
  PRIMARY KEY (accounts_id)
);


CREATE TABLE photos (                   -- 사진
  photos_id VARCHAR2(25),               -- 사진 ID(accounts_id, boards_id, goods_id)
  name VARCHAR2(50),                    -- 사진 이름
  path VARCHAR2(500),                   -- 사진 파일 경로
  created_at DATE,                      -- 사진 생성 일자
  PRIMARY KEY (photos_id)
);


CREATE TABLE boards (                   -- 게시글(같이해요, 동네생활)
  boards_id VARCHAR2(25),               -- 게시글 ID
  accounts_id VARCHAR2(20),             -- 게시글 대분류
  main_category VARCHAR2(20),           -- 게시글 분류 메인
  sub_category VARCHAR2(20),            -- 게시글 분류 서브
  title VARCHAR2(50),                   -- 게시글 제목
  content VARCHAR2(200),                -- 게시글 내용
  recommends NUMBER(5) default 0,       -- 게시글 추천수
  views NUMBER(5) default 0,            -- 게시글 조회수
  address VARCHAR2(50),                 -- 게시글 작성 장소
  created_at DATE default sysdate,      -- 게시글 작성 일자
  PRIMARY KEY (boards_id)
);


CREATE TABLE meetings (                 -- 동네생활 같이해요(조건)
  boards_id VARCHAR2(25),               -- 게시글 ID
  state VARCHAR2(20) default '모집중',  -- 모임 모집상태
  person VARCHAR2(10),                  -- 모임 인원수
  meeting_date Date,                    -- 모임 날짜
  meeting_time_ampm VARCHAR2(6),        -- 모임 시간 AM/PM
  meeting_time_hour VARCHAR2(6),        -- 모임 시간 시
  meeting_time_minute VARCHAR2(6),      -- 모임 시간 분
  place VARCHAR2(50),                   -- 모임 장소
  gender VARCHAR2(10),                  -- 모임 성별
  age VARCHAR2(10),                     -- 모임 나이
  PRIMARY KEY (boards_id)
);


CREATE TABLE meeting_attendees (          -- 동네생활 같이해요 참석자
    boards_id VARCHAR2(100),              -- 게시글 ID
    accounts_id VARCHAR2(100),            -- 계정 ID
    PRIMARY KEY (boards_id, accounts_id)
);

CREATE TABLE comments (                   -- 댓글(X)
  comments_Id NUMBER(20),                 -- 댓글 ID
  accounts_id VARCHAR2(25),               -- 계정 ID
  boards_id VARCHAR2(25),                 -- 게시글 ID
  content VARCHAR2(200),                  -- 댓글 내용
  writer VARCHAR2(25),                    -- 댓글 작성자
  target VARCHAR2(25),                    -- 댓글 타겟
  dept NUMBER(2),                         -- 댓글 깊이
  created_at DATE,                        -- 댓글 작성 일자
  PRIMARY KEY (comments_Id)
);

CREATE TABLE favorites (                  -- 관심목록
  favorites_id VARCHAR2(25),              -- 관심목록 ID
  accounts_id VARCHAR2(25),               -- 계정 ID
  goods_id VARCHAR2(25),                  -- 판매 게시글 ID
  created_at DATE DEFAULT SYSDATE,        -- 관심목록 생성일자
  PRIMARY KEY (favorites_id)
);

CREATE TABLE Goods (                      -- 판매 게시글
  goods_id VARCHAR2(25),                  -- 판매 게시글 ID
  accounts_id VARCHAR2(50),               -- 계정 ID
  title VARCHAR2(100),                    -- 판매 게시글 제목
  content VARCHAR2(200),                  -- 판매 게시글 내용
  address VARCHAR2(100),                  -- 판매 거래 장소
  price NUMBER(25),                       -- 판매 가격
  saled_id VARCHAR2(25),                  -- 구매자 ID
  sale VARCHAR2(5),                       -- 판매 상태
  grade NUMBER(2),                        -- 판매 평점
  recommends NUMBER(5),                   -- 판매 추천
  views NUMBER(5),                        -- 판매 게시글 조회수
  created_at DATE default sysdate,                        -- 판매 게시글 작성 일자
  PRIMARY KEY (goods_id)
);

commit;