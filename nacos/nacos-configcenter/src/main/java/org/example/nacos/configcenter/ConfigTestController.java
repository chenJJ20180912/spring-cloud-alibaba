package org.example.nacos.configcenter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenjia
 * @date : 2021/2/3 17:23
 */
@RestController
public class ConfigTestController {

    @Autowired
    private RefreshConfig refreshConfig;

    @Autowired
    private NotRefreshConfig notRefreshConfig;

    @GetMapping("getConfig")
    public String getConfig() {
        return "key:" + refreshConfig.getKey() + "\tvalue:" + notRefreshConfig.getValue();
    }


}
