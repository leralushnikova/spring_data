package com.lushnikova.jpa.controller.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class ZuluController {
    @RequestMapping(value = "/zulu", method = RequestMethod.GET)
    public String zulu() {
        log.info("Hello from Zulu");
        return "zulu";
    }
}
