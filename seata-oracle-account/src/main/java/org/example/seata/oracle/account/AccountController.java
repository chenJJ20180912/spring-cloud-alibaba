package org.example.seata.oracle.account;

import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenjia
 * @date : 2021/2/20 16:46
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("changeMoney/{sourceId}/{destId}/{money}")
    public String changeMoney(@PathVariable("sourceId") int sourceId,
                     @PathVariable("destId")int destId,
                     @PathVariable("money")int money){
        accountService.changeMoney(sourceId,destId,money);
        return "ok";
    }
}
