---------------- 테이블 / 시퀀스 초기화 ----------------------
drop table comments;
drop table post;
drop table category;
drop table blog;
drop table users;

drop sequence seq_users_no;
drop sequence seq_category_no;
drop sequence seq_post_no;
drop sequence seq_comments_no;

----------------- users 테이블 / 시퀀스 --------------------

CREATE SEQUENCE seq_users_no
INCREMENT BY 1
START WITH 1
NOCACHE;

create table users (
    userNo number,
    id varchar2(50) not null unique,
    userName varchar2(100) not null,
    password varchar2(50) not null,
    joinDate date not null,
    
    primary key(userNo)
);

--------------------- blog 테이블 -------------------------

create table blog (
    id varchar2(50),
    blogTitle varchar2(200) not null,
    logoFile varchar2(200),
    
    primary key(id),
    constraint fk_id foreign key (id) references users (id)
);

------------------- category 테이블 / 시퀀스 ---------------------
create sequence seq_category_no
INCREMENT BY 1
START WITH 1
NOCACHE;

create table category (
    cateNo number,
    id varchar2(50),
    cateName varchar2(200) not null,
    description varchar2(500),
    regDate date not null,
    
    primary key(cateNo),
    constraint fk_cate_id foreign key (id) references blog (id)
);

------------------- post 테이블 / 시퀀스 --------------------------
create sequence seq_post_no
INCREMENT BY 1
START WITH 1
NOCACHE ;

create table post (
    postNo number,
    cateNo number,
    postTitle varchar2(300) not null,
    postContent varchar2(4000),
    regDate date not null,
    
    primary key(postNo),
    constraint fk_cateNo foreign key (cateNo) references category (cateNo)
);

---------------- comments 테이블 / 시퀀스 -------------------------------
create sequence seq_comments_no
INCREMENT BY 1
START WITH 1
NOCACHE ;

create table comments (
    cmtNo number,
    postNo number,
    userNo number,
    cmtContent varchar2(1000) not null,
    regDate date not null,
    
    primary key(cmtNo),
    constraint fk_postNo foreign key (postNo) references post (postNo),
    constraint fk_userNo foreign key (userNo) references users (userNo)
);









