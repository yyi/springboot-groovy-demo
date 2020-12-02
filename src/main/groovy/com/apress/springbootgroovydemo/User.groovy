package com.apress.springbootgroovydemo

import groovy.transform.Canonical
import groovy.transform.CompileStatic

import javax.persistence.*

@Entity
@Table(name="users")
@Canonical
@CompileStatic
//@groovy.transform.Immutable
class User implements  GroovyInterceptable{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    long id
    String name
    String email

    def ok() {
        def test = new Test()
        return test.test()
    }
}
