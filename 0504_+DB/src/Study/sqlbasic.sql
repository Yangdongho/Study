desc student; //테이블 출력

sqlplus / as sysdba

create user scott identified by tiger;

alter user scott identified by tiger account unlock;

GRANT CONNECT,RESOURCE,UNLIMITED TABLESPACE TO SCOTT IDENTIFIED BY TIGER;

select * from tbal 현재 접속한 유저가 사용할 수 있는 테이블

select ename,job,sal where deptnp=30 and sal>1500