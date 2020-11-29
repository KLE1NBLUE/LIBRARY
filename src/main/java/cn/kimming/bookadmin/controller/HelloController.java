package cn.kimming.bookadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String sayHello(Model model) {
        model.addAttribute("msg", "hello bookadmin");
        return "pages/hello";
    }
}
