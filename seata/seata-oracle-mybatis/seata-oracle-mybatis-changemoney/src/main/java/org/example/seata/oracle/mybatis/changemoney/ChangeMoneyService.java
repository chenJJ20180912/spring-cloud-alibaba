package org.example.seata.oracle.mybatis.changemoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chenjia
 * @date : 2021/2/20 16:47
 */
@Service
public class ChangeMoneyService {

    @Autowired
    private ChangeMoneyDao changeMoneyDao;

    @Transactional(rollbackFor = Exception.class)
    public void changeMoney(int sourceId, int destId, int money) {
        Integer m1 = changeMoneyDao.loadMoney(sourceId);
        if (m1 == null) {
            changeMoneyDao.insertMoney(sourceId, -money);
        } else {
            changeMoneyDao.updateMoney(sourceId, m1 - money);
        }
        Integer m2 = changeMoneyDao.loadMoney(destId);
        if (m2 == null) {
            changeMoneyDao.insertMoney(destId, money);
        } else {
            changeMoneyDao.updateMoney(destId, m2 + money);
        }
        if(destId == -1){
            // 当目标账户的id为-1时报错 让account内的数据回滚
            throw new RuntimeException("事务回滚");
        }
    }
}
