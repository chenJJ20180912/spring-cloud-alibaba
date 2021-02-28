-- 新建表 UNDO_LOG、GLOBAL_TABLE、BRANCH_TABLE、LOCK_TABLE
-- Create table
create table UNDO_LOG
(
    id            NUMBER(20) not null,
    branch_id     NUMBER(20) not null,
    xid           VARCHAR2(100) not null,
    context       VARCHAR2(128) not null,
    rollback_info BLOB,
    log_status    INTEGER,
    log_created   DATE,
    log_modified  DATE
);
-- Create/Recreate indexes
create index IDX_XRID on UNDO_LOG (BRANCH_ID, XID);
-- Create/Recreate primary, unique and foreign key constraints
alter table UNDO_LOG
    add constraint PK_UNDO primary key (ID);
create sequence UNDO_LOG_SEQ
    minvalue 1
    maxvalue 9999999999999999999999999
    start with 1
    increment by 1
    cache 20;

-- 业务表
create table ACCOUNT_RECORD
(
    ID       NUMBER not null
        constraint ACCOUNT_RECORD_PK
            primary key,
    SOURCEID NUMBER,
    DESTID   NUMBER,
    MONEY    NUMBER
);