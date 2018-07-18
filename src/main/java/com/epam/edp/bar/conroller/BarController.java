package com.epam.edp.bar.conroller;

import com.epam.edp.bar.service.BarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pavlo_Yemelianov
 */
@RestController
public class BarController {

    @Autowired
    private BarService barService;

    @GetMapping(value = "/foo/config")
    public String fooConfig() {
        return barService.getFooConfig();
    }

    @GetMapping(value = "/dumb/client")
    public String dumbClient() {
        return "Dumb client response from bar";
    }

    @GetMapping(value = "/feign/client")
    public String feignClient() {
        return "Feign client response from bar";
    }

}
