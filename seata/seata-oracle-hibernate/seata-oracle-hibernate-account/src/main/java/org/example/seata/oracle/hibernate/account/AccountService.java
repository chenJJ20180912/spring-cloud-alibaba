package org.example.seata.oracle.hibernate.account;

import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.example.seata.oracle.hibernate.commonapi.ChangeMoneyApi;

import java.util.Date;

/**
 * @author chenjia
 * @date : 2021/2/20 16:47
 */
@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired(required = false)
    @Lazy
    private ChangeMoneyApi changeMoneyApi;

    /**
     * 执行修改账户金额
     * @param sourceId
     * @param destId
     * @param money
     */
    @GlobalTransactional(name="seata-oracle-account",rollbackFor = Exception.class)
    public void changeMoney(int sourceId, int destId, int money) {
        long id = accountDao.count()+1;
        AccountEntity accountPo = new AccountEntity();
        accountPo.setId(id);
        accountPo.setSourceId(sourceId);
        accountPo.setDestId(destId);
        accountPo.setMoney(money);
        accountPo.setCreatedTime(new Date());
        // 保存一个分数
        accountDao.save(accountPo);
        if(changeMoneyApi != null){
            // 远程调用b服务修改金额的服务
            changeMoneyApi.changeMoney(sourceId, destId, money);
        }
        if(destId == -2){
            // account 服务报错 看changemoney是否回滚
            throw new RuntimeException(" account 服务报错 看changemoney是否回滚");
        }
    }
}
