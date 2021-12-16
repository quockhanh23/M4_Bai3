package controller;

import model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")
public class DemoController {
    @GetMapping("")
    public String demo(Model model) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("khanh");
        arrayList.add("Long");
        arrayList.add("Long");
        arrayList.add("Long");
        arrayList.add("Long");
       model.addAttribute("name", arrayList);
        return "/demo";
    }
}
