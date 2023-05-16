package com.spring.securitycassandra.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.ReactiveAuthenticationManager
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
@EnableWebFluxSecurity
class SecurityConfig(private val userDetailsService: ReactiveUserDetailsService) {

  @Bean
  fun springSecurityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain =
    http
      .authorizeExchange()
      .pathMatchers("/login", "/*.css").permitAll()
      .anyExchange().authenticated()
      .and().authenticationManager(authenticationManager())
      .formLogin().loginPage("/login")
      .and().build()

  private fun authenticationManager(): ReactiveAuthenticationManager {
    val authenticationManager = UserDetailsRepositoryReactiveAuthenticationManager(userDetailsService)
    authenticationManager.setPasswordEncoder(passwordEncoder())
    return authenticationManager
  }

  private fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder(10)

}