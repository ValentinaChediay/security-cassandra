package com.spring.securitycassandra.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import reactor.core.publisher.Mono

@Controller
class LoginController {

  @GetMapping("/login")
  fun handleLogin(): Mono<String> = Mono.just("login")

}