package com.lushnikova.jpa.controller.web;

import com.lushnikova.jpa.dto.record.PersonDTO4;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/greetings")
public class GreetingController {

    @GetMapping("/hello")
    public ModelAndView greetingHello(@RequestParam(name = "name") String name,
                                      HttpServletRequest request,
                                      ModelAndView modelAndView) {
        request.getSession().setAttribute("name", name);
        modelAndView.addObject("person", new PersonDTO4(10L, "ldskgja", "skdhgs"));
        ModelAndView mav = new ModelAndView("/hello");
        mav.addObject("name", name);
        return mav;
    }

    @GetMapping("/buy")
    public ModelAndView greetingBye(@RequestParam(name = "name") String name) {
        ModelAndView mav = new ModelAndView("/buy");
        mav.addObject("name", name);
        return mav;
    }
}
