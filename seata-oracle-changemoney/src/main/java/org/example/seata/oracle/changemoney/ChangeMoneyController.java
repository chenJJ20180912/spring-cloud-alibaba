package org.example.seata.oracle.changemoney;

import org.example.seata.oracle.commonapi.ChangeMoneyApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenjia
 * @date : 2021/2/20 16:46
 */
@RestController
public class ChangeMoneyController implements ChangeMoneyApi {

    @Autowired
    private ChangeMoneyService changeMoneyService;

    @Override
    @GetMapping("changeMoney/{sourceId}/{destId}/{money}")
    public void changeMoney(@PathVariable("sourceId") int sourceId,
                     @PathVariable("destId")int destId,
                     @PathVariable("money")int money){
        changeMoneyService.changeMoney(sourceId,destId,money);
    }
}
