package org.example.oracle.hibernate.changemoney;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author chenjia
 * @date : 2021/2/28 13:49
 */
@Entity
@Table(name = "Account_info")
public class AccountInfoEntity{

    @Id
    private long id;

    private Integer money;


    private Date createdTime;

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
