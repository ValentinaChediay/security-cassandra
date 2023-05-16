package com.spring.securitycassandra.service

import com.spring.securitycassandra.dao.UserRepository
import com.spring.securitycassandra.model.toUsernamePasswordPrincipal
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class DefaultUserDetailsService(private val userRepository: UserRepository) : ReactiveUserDetailsService {

  override fun findByUsername(username: String): Mono<UserDetails> =
    userRepository.findByUsername(username).map { it.toUsernamePasswordPrincipal() }
}