package org.example.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenjia
 * @date : 2021/2/4 14:39
 */
@RestController
@RequestMapping("/sentinel")
public class SentinelController {

    /**
     * 测试1
     * @return
     */
    @GetMapping("/demo")
    @SentinelResource("demo")
    public String demo(){
        return "demo";
    }


    @GetMapping("/hotspotDemo")
    @SentinelResource("hotspotDemo")
    public String hotspotDemo(){
        return "hotspotDemo";
    }
}
