package project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class MySecurityConfiguration {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

// 			Only admins can access 
		// http.authorizeHttpRequests().requestMatchers("/order/status/**").hasRole("ADMIN");
// 			

//			
// 			// Needs authentication 
		http.authorizeHttpRequests().anyRequest().authenticated();
// 			
//     	 
		http.httpBasic();

// 
		http.csrf().disable(); // needed for POST requests
		http.cors();

		return http.build();
	}
}
