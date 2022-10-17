package com.curso.inicio;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{	
		//definiciÃ³n roles y usuarios
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
	    .inMemoryAuthentication()
	    .withUser("user1")
	      .password("{noop}user1") //lo de {noop} se pone para no obligar a usar mecanismo de encriptaciÃ³n
	      .roles("INVITADO")
	      .and()
	    .withUser("user2")
	      .password("{noop}user2")
	      .roles("OPERADOR")
	      .and()
	      .withUser("user3")
	      .password("{noop}user3") //lo de {noop} se pone para no obligar a usar mecanismo de encriptaciÃ³n
	      .roles("ADMIN")
	      .and()
	      .withUser("user4")
	      .password("{noop}user4") //lo de {noop} se pone para no obligar a usar mecanismo de encriptaciÃ³n
	      .roles("OPERADOR","ADMIN");
		/*lo siguiente serÃ­a para el caso de que
		 * quisiÃ©ramos encriptar la password:
		String pw1=new BCryptPasswordEncoder().encode("user1");
		System.out.println(pw1);
		  auth
	        .inMemoryAuthentication()
	        .withUser("user1")
	          .password("{bcrypt}"+pw1)
	          //.password(pw1)
	          .roles("USER")
	          .and()
	        .withUser("admin")
	          .password("{bcrypt}"+new BCryptPasswordEncoder().encode("admin"))
	          .roles("USER", "ADMIN");
		 */
		
		/*la seguiente configuraciÃ³n serÃ¡ para el caso de 
		 * usuarios en una base de datos
		 * auth.jdbcAuthentication().dataSource(dataSource)
	    	.usersByUsernameQuery("select username, password, enabled"
	        	+ " from users where username=?")
	    	.authoritiesByUsernameQuery("select username, authority "
	        	+ "from authorities where username=?");
		 */
	}
	//definiciÃ³n de polÃ­ticas de seguridad
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		//solo los miembros del rol admin podrÃ¡n realizar altas
		//y para ver la lista de libros, tendrÃ¡n que estar autenticados
		//Cualquier caso distinto de estos, podrán acceder sin estar autenticados.
		.antMatchers(HttpMethod.POST,"/cursoAdd").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT,"/cursoUpdate").hasAnyRole("ADMIN", "OPERADOR")
		.antMatchers(HttpMethod.DELETE,"/cursoDelete/{idCurso}").hasAnyRole("ADMIN", "OPERADOR")
		.antMatchers(HttpMethod.GET,"/cursoSearch/{minPrecio}/{maxPrecio}").authenticated()
		.antMatchers(HttpMethod.GET,"/curso/{idCurso}").authenticated()
		.antMatchers(HttpMethod.GET,"/cursos").authenticated()
		//.antMatchers("/libro/**").authenticated() 
		//.antMatchers("/libros").authenticated()	//--> Todos los usuarios autenticados
		//.antMatchers("/libro/**").authenticated() -->protegeríamos todos la url que contega libro como dir raiz, tendrán que autenticarse
		
		.and()
		.httpBasic();
	
	}
	}

