package main.controller;

import main.api.response.InitResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

    private final InitResponse initResponse;

    public DefaultController(InitResponse initResponse) {
        this.initResponse = initResponse;
    }

    @RequestMapping("/")
    public String index(Model model) {

        System.out.println(initResponse.getTitle());
        System.out.println(initResponse.getPhone());
        System.out.println(initResponse.getEmail());
        System.out.println(initResponse.getCopyright());
        System.out.println(initResponse.getCopyrightFrom());
        System.out.println(initResponse.getSubtitle());

        return "index";
    }

}

