package pt.uminho.simple_api.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        http.cors()
                .configurationSource(
                        request -> {
                            CorsConfiguration config = new CorsConfiguration();
                            config.setAllowCredentials(true);
                            config.addAllowedOrigin("*");
                            config.addAllowedHeader("*");
                            config.addAllowedMethod("DELETE");
                            config.addAllowedMethod("GET");
                            config.addAllowedMethod("PUT");
                            config.addAllowedMethod("POST");
                            return config.applyPermitDefaultValues();
                        });

        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .anyRequest()
                .authenticated();

    }
}
