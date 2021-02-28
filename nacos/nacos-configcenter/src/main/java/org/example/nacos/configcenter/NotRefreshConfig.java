package org.example.nacos.configcenter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author chenjia
 * @date : 2021/2/3 21:01
 */
@Component
public class NotRefreshConfig {

    @Value("${value}")
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
