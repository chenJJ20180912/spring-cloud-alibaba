package org.example.nacos.discovery;

import org.example.nacos.discovery.commonapi.AApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenjia
 * @date : 2021/2/3 17:23
 */
@RestController
public class AApiConsumer  {


    @Autowired
    @Lazy
    private AApi aApiProvider;

    @GetMapping("/demo")
    public String demo(){
        return aApiProvider.printServer();
    }
}
