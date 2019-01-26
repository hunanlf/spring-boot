package com.yf.testsecurity.config

import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component

@Component
class CustomUserDetailsService: AuthenticationUserDetailsService<CasAssertionAuthenticationToken> {

    override fun loadUserDetails(token: CasAssertionAuthenticationToken): UserDetails {
        return User(token.name,"", mutableSetOf(SimpleGrantedAuthority("ROLE_TEST")))
    }

}