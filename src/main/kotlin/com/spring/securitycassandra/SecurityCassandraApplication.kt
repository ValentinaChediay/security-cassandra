package com.spring.securitycassandra

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SecurityCassandraApplication

fun main(args: Array<String>) {
	runApplication<SecurityCassandraApplication>(*args)
}
