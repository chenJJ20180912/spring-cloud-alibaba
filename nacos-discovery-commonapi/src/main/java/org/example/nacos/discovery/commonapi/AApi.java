package org.example.nacos.discovery.commonapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author chenjia
 * @date : 2021/2/3 17:13
 */
@FeignClient("nacos-discovery-a")
public interface AApi {

    /**
     * 打印一段文字
     *
     * @return
     */
    @RequestMapping(value = "/printServer",method = RequestMethod.POST)
    String printServer();
}
