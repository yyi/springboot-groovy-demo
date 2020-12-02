package com.apress.springbootgroovydemo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * @creaor:yyi
 * @createDate:2020/12/2
 * @Describle
 */
@Service
class ServiceFacade {

    @Autowired
    UserService userService

    @Transactional
    saveUser(){
        userService.saveUser1()
        try {
            userService.saveUser2();
        } catch (Throwable throwable) {
            print throwable
        }
    }
}
