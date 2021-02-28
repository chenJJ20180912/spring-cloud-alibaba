package org.example.nacos.discovery;

import org.example.nacos.discovery.commonapi.AApi;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenjia
 * @date : 2021/2/3 17:23
 */
@RestController
public class AApiProvider implements AApi {

    @Override
    public String printServer() {
        return "this is nacos-discovery-a";
    }
}
