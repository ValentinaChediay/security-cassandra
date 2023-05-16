package com.spring.securitycassandra.dao

import com.spring.securitycassandra.model.User
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import java.io.Serializable

@Repository
interface UserRepository: ReactiveCrudRepository<User, Serializable> {

  fun findByUsername(username: String): Mono<User>
}