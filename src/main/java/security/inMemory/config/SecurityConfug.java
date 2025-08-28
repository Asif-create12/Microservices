package security.inMemory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfug {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((request) -> request.requestMatchers
                ("/", "/login", "/welcome", "/message").permitAll().anyRequest().authenticated()).httpBasic(basic -> {
        });

        return http.build();

    }
        @Bean
        public InMemoryUserDetailsManager userDetailsService() {
            UserDetails adminUser = User.withDefaultPasswordEncoder()
                    .username("asif")
                    .password("asif@123")
                    .roles("ADMIN")   // ✅ better to use roles, not plain authorities
                    .build();

            UserDetails normalUser = User.withDefaultPasswordEncoder()
                    .username("raju")
                    .password("raju@123")
                    .roles("USER")
                    .build();

            return new InMemoryUserDetailsManager(adminUser, normalUser);
        }
}
