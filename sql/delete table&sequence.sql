// 전체 테이블 삭제 쿼리문 소환
SELECT 'DROP TABLE "'||TABLE_NAME||'" CASCADE CONSTRAINTS;' FROM user_tables;

// 전체 시퀀스 삭제 쿼리문 소환
SELECT 'DROP sequence "'||SEQUENCE_NAME||'";' FROM user_sequences;
