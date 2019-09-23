package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SimpleDictionary {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/translate")
    public String translate(@RequestParam String english, ModelMap modelMap) {
        english = english.toLowerCase();
        modelMap.put("book", "Quyển sách");
        modelMap.put("goodbye", "Tạm biệt");
        modelMap.put("hello", "Xin chào");
        String result = (String) modelMap.get(english);
        if (result != null) {
            modelMap.addAttribute("english", english);
            modelMap.addAttribute("result", result);
        } else {
            result = "Not found";
            modelMap.addAttribute("english", english);
            modelMap.addAttribute("result", result);
        }
        return "/index";
    }
}
