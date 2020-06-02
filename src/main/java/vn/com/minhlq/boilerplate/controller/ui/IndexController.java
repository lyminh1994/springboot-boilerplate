package vn.com.minhlq.boilerplate.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "/views/index";
    }

    @GetMapping("/agency/list")
    public ModelAndView getAgencyList() {
        ModelAndView mav = new ModelAndView("/views/agency/agencies");
        mav.addObject("", "abc");
        return mav;
    }
}
