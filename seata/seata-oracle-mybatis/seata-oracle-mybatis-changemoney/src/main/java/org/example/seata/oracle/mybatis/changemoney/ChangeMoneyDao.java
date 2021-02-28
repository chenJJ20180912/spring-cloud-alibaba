package org.example.seata.oracle.mybatis.changemoney;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @author chenjia
 * @date : 2021/2/20 16:48
 */
@Mapper
@Repository
public interface ChangeMoneyDao {

    @Select("select money from account_info where id = #{id}")
    Integer loadMoney(int id);

    @Insert("insert into account_info (id,money) values (#{id},#{money})")
    int insertMoney(int id,int money);

    @Update("update account_info set money = #{money} where id = #{id}")
    int updateMoney(int id,int money);
}
