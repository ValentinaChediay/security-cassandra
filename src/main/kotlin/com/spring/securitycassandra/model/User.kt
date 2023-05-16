package com.spring.securitycassandra.model

import org.springframework.data.annotation.Id
import org.springframework.data.cassandra.core.mapping.Column
import org.springframework.data.cassandra.core.mapping.Table
import java.io.Serializable

@Table("users")
class User(
  @Id
  val username: String,

  val password: String,

  @Column("user_role")
  val userRole: String,

  @Column("first_name")
  val firstName: String,

  @Column("last_name")
  val lastName: String,

  val email: String,

  @Column("account_enabled")
  val accountEnabled: Boolean,

  @Column("account_expired")
  val accountExpired: Boolean,

  @Column("account_locked")
  val accountLocked: Boolean,

  @Column("credential_expired")
  val credentialExpired: Boolean
) : Serializable {
  private val serialVersionUID = 1L
}

fun User.toUsernamePasswordPrincipal(): UsernamePasswordPrincipal =
  UsernamePasswordPrincipal(
    this.username,
    this.password,
    this.userRole,
    this.accountExpired,
    this.accountLocked,
    this.credentialExpired,
    this.accountEnabled,
    this.firstName,
    this.lastName,
    this.email
  )