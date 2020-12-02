package com.apress.springbootgroovydemo

import groovy.sql.Sql
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

/**
 * @creaor:yyi
 * @createDate:2020/12/2
 * @Describle
 */
@Service
@CompileStatic
class UserService {

    @Autowired
    Sql sql;

    @Transactional
    def saveUser1() {

        sql.executeInsert([id:123+Math.random()*10000.toInteger(),name:'ok1111',email:'test@test.com'],'''insert into users(id,name,email)values(:id,:name,:email)''')
    }

    @Transactional(propagation = Propagation.NESTED)
    def saveUser2() {

        sql.executeInsert([id:456,name:'ok22222',email:'test@test.com2222'],'''insert into users(id,name,email)values(:id,:name,:email)''')
        assert 1==2
    }
}
