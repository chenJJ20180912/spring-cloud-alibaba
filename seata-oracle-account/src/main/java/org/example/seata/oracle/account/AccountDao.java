package org.example.seata.oracle.account;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author chenjia
 * @date : 2021/2/20 16:48
 */
@Mapper
@Repository
public interface AccountDao {

    @Insert("insert into account_record(id,sourceId,destId,money) values(#{id},#{sourceId},#{destId},#{money})")
    void saveRecord(int id,int sourceId,int destId,int money);


    @Select("select max(id)+1 from account_record")
    Integer getNextId();
}
