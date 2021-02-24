package org.example.seata.oracle.commonapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author chenjia
 * @date : 2021/2/20 16:56
 */
@FeignClient("seata-oracle-changeMoney")
public interface ChangeMoneyApi {

    /**
     * 从a账户那边转账到b账户上
     *
     * @param sourceId 来源账户
     * @param destId   目标账户
     * @param money    转账金额
     */
    @GetMapping("changeMoney/{sourceId}/{destId}/{money}")
    void changeMoney(@PathVariable("sourceId") int sourceId,
                     @PathVariable("destId")int destId,
                     @PathVariable("money")int money);
}
