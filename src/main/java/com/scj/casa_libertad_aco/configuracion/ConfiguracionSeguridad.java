
// package com.scj.casa_libertad_aco.configuracion;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;

    
// @Configuration
// public class ConfiguracionSeguridad {
    
//     protected void configure(HttpSecurity http) throws Exception {
// 		http.cors().and().csrf().disable()
// 			.authorizeRequests()
// 			.antMatchers("/registro**","/vivienda**","/programas**",
//                                 "/paises**","/formatos**","/datos_demog**","/bandejaArtic**",
//                                 "/bandaco**","/antecedentes**",
// 					"/configuration/**",
// 					"/**")
// 			.permitAll()
// 			.anyRequest().authenticated();
// 	}

// }


package com.scj.casa_libertad_aco.configuracion;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/**")
				.permitAll()
				.and()
				.csrf().disable();
	}
}
