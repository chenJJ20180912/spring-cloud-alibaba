package org.example.oracle.hibernate.changemoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.example.seata.oracle.hibernate.commonapi.ChangeMoneyApi;

/**
 * @author chenjia
 * @date : 2021/2/20 16:46
 */
@RestController
public class ChangeMoneyController implements ChangeMoneyApi {

    @Autowired
    private AccountInfoService accountInfoService;

    @Override
    @GetMapping("changeMoney/{sourceId}/{destId}/{money}")
    public void changeMoney(@PathVariable("sourceId") int sourceId,
                     @PathVariable("destId")int destId,
                     @PathVariable("money")int money){
        accountInfoService.changeMoney(sourceId,destId,money);
    }
}
