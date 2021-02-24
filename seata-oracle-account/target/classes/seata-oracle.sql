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

create table GLOBAL_TABLE (
                              xid varchar2(128)  not null,
                              transaction_id NUMBER(20),
                              status NUMBER(10) not null,
                              application_id varchar2(64),
                              transaction_service_group varchar2(64),
                              transaction_name varchar2(128),
                              timeout NUMBER(10),
                              begin_time NUMBER(20),
                              application_data varchar2(2000),
                              gmt_create DATE,
                              gmt_modified DATE
);

create table BRANCH_TABLE (
                              branch_id NUMBER(20) not null,
                              xid varchar2(128) not null,
                              transaction_id NUMBER(20) ,
                              resource_group_id varchar2(128),
                              resource_id varchar2(256) ,
                              lock_key varchar2(256) ,
                              branch_type varchar2(8) ,
                              status NUMBER(10),
                              client_id varchar2(64),
                              application_data varchar2(2000),
                              gmt_create DATE,
                              gmt_modified DATE
);

create table LOCK_TABLE (
                            row_key varchar2(128) not null,
                            xid varchar2(128),
                            transaction_id NUMBER(20) ,
                            branch_id NUMBER(20),
                            resource_id varchar2(256) ,
                            table_name varchar2(64) ,
                            pk varchar2(128) ,
                            gmt_create DATE ,
                            gmt_modified DATE
);
