package br.com.loginSeguro.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.loginSeguro.enums.PerfilEnum;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/login").permitAll()
		.antMatchers("/**").hasAnyRole( PerfilEnum.ADMIN.name(),
										PerfilEnum.GESTOR.name())
		.anyRequest().authenticated();
		
		http.formLogin()
				.loginPage("/login").permitAll()
				.defaultSuccessUrl("/inicialPage",true);
		
		http.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            	.invalidateHttpSession(true);

		http.csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("admin").password(passwordEncoder.encode("admin")).roles(PerfilEnum.ADMIN.name()).and()
		.withUser("gestor").password(passwordEncoder.encode("gestor")).roles(PerfilEnum.GESTOR.name());
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/images/**", "/css/**", "/webjars/**", "/console/**");
	}
}
