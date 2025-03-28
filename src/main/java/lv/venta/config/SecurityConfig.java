package lv.venta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public UserDetailsManager createTestUsers() {
		
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		UserDetails ud1 = User.builder()
				.username("karina")
				.password(encoder.encode("1234"))
				.authorities("USER")
				.build();
		
		UserDetails ud2 = User.builder()
				.username("john")
				.password(encoder.encode("qwerty"))
				.authorities("USER")
				.build();
		
		UserDetails ud3 = User.builder()
				.username("admin")
				.password(encoder.encode("9876"))
				.authorities("ADMIN")
				.build();
		
		InMemoryUserDetailsManager imudManager = new InMemoryUserDetailsManager(ud1,ud2,ud3);
		return imudManager;
	
	}
	@Bean
	public SecurityFilterChain configureEndpoints(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth
				.requestMatchers("/simple").hasAuthority("ADMIN")
				.requestMatchers("/data").hasAuthority("ADMIN")
				.requestMatchers("/testproduct").hasAuthority("ADMIN")
				.requestMatchers("/testallproducts").hasAuthority("ADMIN")
				.requestMatchers("/product/crud/create").hasAuthority("ADMIN")
				.requestMatchers("/product/crud/all").permitAll()
				.requestMatchers("/product/crud/one?id=**").permitAll()
				.requestMatchers("/product/crud/all/**").permitAll()
				.requestMatchers("/product/crud/update/**").hasAuthority("ADMIN")
				.requestMatchers("/product/crud/delete/**").hasAuthority("ADMIN")
				.requestMatchers("/product/stats/price/**").hasAnyAuthority("ADMIN", "USER")
				.requestMatchers("/product/stats/search/**").hasAnyAuthority("ADMIN", "USER")				
				);
		
		http.formLogin(auth->auth.permitAll());
		
		return http.build();
		
	}
	
	
	
	

}
