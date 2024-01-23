package com.uniLim.info.security

import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager


class UserDetailsManager {
    @Bean
    fun userDetailsService(bCryptPasswordEncoder: BCryptPasswordEncoder): UserDetailsService {
        val manager = InMemoryUserDetailsManager()
        manager.createUser(
            User.withUsername("user")
                .password(bCryptPasswordEncoder.encode("userPass"))
                .roles("USER")
                .build()
        )
        manager.createUser(
            User.withUsername("admin")
                .password(bCryptPasswordEncoder.encode("adminPass"))
                .roles("USER", "ADMIN")
                .build()
        )
        return manager
    }

//    @Bean
//    fun filterChain(http: HttpSecurity): SecurityFilterChain {
//        http.csrf { it.disable() }
//            .authorizeHttpRequests { auth ->
//                auth.requestMatchers(HttpMethod.GET, "/check_msg").permitAll()
//                    .requestMatchers(HttpMethod.GET, "/check_err").permitAll()
//                    .requestMatchers(HttpMethod.POST, "/sync_msg").permitAll()
//                    .requestMatchers(HttpMethod.POST, "/sync_err").permitAll()
//                    .anyRequest().authenticated()
//            }
//            .httpBasic(withDefaults())
//            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
//
//        return http.build()
//    }

}