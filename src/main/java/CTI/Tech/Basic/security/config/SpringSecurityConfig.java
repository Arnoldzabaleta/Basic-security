package CTI.Tech.Basic.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsservice () {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("javatalent")
                .password("javatalent")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests ((authz) -> authz
                .requestMatchers("/message")
                //.anyRequest()
                .authenticated()
        )
                .httpBasic();
        return http.build();

    }


    }


