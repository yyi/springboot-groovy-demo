package com.apress.springbootgroovydemo

import groovy.sql.Sql
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

import javax.servlet.http.HttpServletRequest

@Controller
@CompileStatic
class HomeController {

    @Autowired
    UserRepository repo;

    @Autowired
    Sql sql


    @Autowired
    UserService userService

    @Autowired
    ServiceFacade serviceFacade


    @GetMapping("/")
    String home(Model model, HttpServletRequest httpServletRequest) {
        userService.saveUser1()
        def allUsers = getUsers()
        def u = allUsers[0]
        u.name = "ok"
        model.addAttribute("users", allUsers)

        repo.findAll()


        "home"
    }

    List<User> getUsers() {
        def collect = sql.rows('''select * from users``''').collect {
            new User(id: Long.parseLong(it['id'].toString()), name: it['name'].toString(), email: it['email'].toString())
        }
        collect

    }

    @GetMapping("/err")
    String error() {
        serviceFacade.saveUser()
        return "home"
    }

}
