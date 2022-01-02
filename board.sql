-- 게시글 작성 pboard
 create table pboard ( 
	bid			number(5), -- 작성자 id
 	writer		varchar2(40), -- 작성자
 	title		varchar2(40), -- 제목
 	content		varchar2(100), -- 내용
 	fileName   varhar2(30),  --사진
 	regdate		DATE, -- 등록일
 	hit			number(5), -- 좋아요
-- 	bcode 		number(10), --게시글 번호
 	PRIMARY KEY (bid) 
 );
 alter table pboard add(fileName varchar2(30)); 
 select * from pboard;
 select * from pboard;
 
alter table board3 drop (bcode);
select * from board3;
delete from board3;
-- 시퀀스 작성 필요

select * from pmember;
INSERT INTO pboard values(3,'길동1','글1','내용1',sysdate,0);
INSERT INTO pboard values(4,'길동2','글2','내용2',sysdate,1);
INSERT INTO pboard values(5,'길동3','글3','내용3',sysdate,2);
INSERT INTO pboard values(6,'길동1','글1','내용1',sysdate,0);
INSERT INTO pboard values(7,'길동1','글1','내용1',sysdate,0);
INSERT INTO pboard values(8,'길동1','글1','내용1',sysdate,0);
INSERT INTO pboard values(9,'길동1','글1','내용1',sysdate,0);
INSERT INTO pboard values(10,'길동1','글1','내용1',sysdate,0);

INSERT INTO pboard values(31,'길동1','글1','내용1',sysdate,0);
INSERT INTO pboard values(41,'길동2','글2','내용2',sysdate,1);
INSERT INTO pboard values(51,'길동3','글3','내용3',sysdate,2);
INSERT INTO pboard values(61,'길동1','글1','내용1',sysdate,0);
INSERT INTO pboard values(71,'길동1','글1','내용1',sysdate,0);
INSERT INTO pboard values(81,'길동1','글1','내용1',sysdate,0);
INSERT INTO pboard values(91,'길동1','글1','내용1',sysdate,0);
INSERT INTO pboard values(101,'길동1','글1','내용1',sysdate,0);
INSERT INTO pboard values(32,'길동1','글1','내용1',sysdate,0);
INSERT INTO pboard values(42,'길동2','글2','내용2',sysdate,1);
INSERT INTO pboard values(52,'길동3','글3','내용3',sysdate,2);
INSERT INTO pboard values(62,'길동1','글1','내용1',sysdate,0);
INSERT INTO pboard values(72,'길동1','글1','내용1',sysdate,0);
INSERT INTO pboard values(82,'길동1','글1','내용1',sysdate,0);
INSERT INTO pboard values(92,'길동1','글1','내용1',sysdate,0);
INSERT INTO pboard values(102,'길동1','글1','내용1',sysdate,0);



-- 회원관리
create table pmember (
   id varchar2(20) primary key,
   email varchar2(30),
   password varchar2(30),
   name varchar2(30),
   fileName varchar2(50),
   del char(1) default 'n',
   regdate date
);
alter table pmember rename column fileName to memberPhoto;
select * from pmember;
drop table pmember;




-- 관리자
insert into pmember(id,password) values('admin','1234');
update pmember set Name='중앙이' where Id='admin';
select * from pmember where id='admin';




-- 상품 
create table product (
		--사진
		pId number(10) primary key, -- 상품 번호 (primary key )
		writer varchar2(10), -- member의 외래키로 넣어야 하나?
		title varchar2(30), -- 제목
		content varchar2(100), --- 내용
		price number(10),
		regdate date -- 등록일
		
 ); 
 select * from product;

drop table liketable1;
create table liketable1(
 	ltmid varchar2(100) not null, --회원 아이디
 	ltbid number not null, --게시물 기본키
 	ltlike number default 0, --좋아요 체크
 	primary key(ltmid,ltbid)
 	-- foreign key(ltmid)  references pmember(id), -- 삭제 기능이 안되 주석처리함 
 	-- foreign key(ltbid)  references pboard(bid)
 );
select * from LIKETABLE1;
update LIKETABLE1 set ltlike = 0;
