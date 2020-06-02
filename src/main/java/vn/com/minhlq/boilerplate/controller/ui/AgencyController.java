package vn.com.minhlq.boilerplate.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("/agency")
public class AgencyController {

    @GetMapping("/list")
    public ModelAndView getAgencyList() {
        ModelAndView mav = new ModelAndView("/views/agency/agencies");
        mav.addObject("", "abc");
        return mav;
    }
}
