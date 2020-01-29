package com.avaya.proccess.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Resource(name = "userService")
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Autowired
	public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
	}

	@Bean
	public JwtAuthenticationFilter authenticationTokenFilterBean() throws Exception {
		return new JwtAuthenticationFilter();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/signin");
	}

	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
		 http.cors().and().csrf().disable().
		 authorizeRequests()
		 .antMatchers("/token/*", "/users/signup", "/users/signin").permitAll()
		 .anyRequest().authenticated()
		 .and()
		 .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
		 .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		 
		 http
		 .addFilterBefore(authenticationTokenFilterBean(),
				 UsernamePasswordAuthenticationFilter.class);
	 }

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//				.antMatchers(HttpMethod.POST, "/signup")
//				.permitAll()
//				.antMatchers("/", "/favicon.ico", "/**/*.png", "/**/*.gif",
//						"/**/*.svg", "/**/*.jpg", "/**/*.html", "/**/*.css",
//						"/**/*.js").permitAll().anyRequest().authenticated()
//				.and().cors().and().exceptionHandling()
//				.authenticationEntryPoint(unauthorizedHandler).and()
//				.sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//				.csrf().disable();
//
//		// Add our custom JWT security filter
//		http.addFilterBefore(authenticationTokenFilterBean(),
//				UsernamePasswordAuthenticationFilter.class);
//
//	}

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}
