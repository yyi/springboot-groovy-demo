package com.apress.springbootgroovydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @creaor:yyi
 * @createDate:2020/12/2
 * @Describle
 */
@Controller
public class JavaControl {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/j")
    public String callGroovy(Model model) {
        User user = new User();
      //  user.setId(5L);
        user.setEmail("test");
        user.setName("okok");
        user.ok();
        userRepository.save(user);
        return "redirect:/";
    }

}
