package org.example.oracle.hibernate.changemoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author chenjia
 * @date : 2021/2/20 16:47
 */
@Service
public class AccountInfoService {

    @Autowired
    private AccountInfoDao accountInfoDao;

    @Transactional(rollbackFor = Exception.class)
    public void changeMoney(int sourceId, int destId, int money) {
        Optional<AccountInfoEntity> optional = accountInfoDao.findById((long) sourceId);
        AccountInfoEntity po;
        if (optional.isPresent()) {
            po = optional.get();
        } else {
            po = new AccountInfoEntity();
            po.setMoney(0);
            po.setId(sourceId);
        }
        po.setMoney(po.getMoney() - money);
        accountInfoDao.save(po);

        Optional<AccountInfoEntity> optional2 = accountInfoDao.findById((long) destId);
        AccountInfoEntity po2;
        if (optional2.isPresent()) {
            po2 = optional2.get();
        } else {
            po2 = new AccountInfoEntity();
            po2.setMoney(0);
            po2.setId(destId);
        }
        po2.setMoney(po2.getMoney() + money);
        accountInfoDao.save(po2);
        if (destId == -1) {
            // 当目标账户的id为-1时报错 让account内的数据回滚
            throw new RuntimeException("事务回滚");
        }
    }
}
