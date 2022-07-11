package com.clinic.dentum.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Bean
    public JwtTokenStore tokenStoreResource() {
        return new JwtTokenStore(accessTokenConverterResource());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverterResource() {
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        tokenConverter.setSigningKey("dentumPls23");
        return tokenConverter;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStoreResource());
    }
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/oauth/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/dentist/dentists", "/api/v1/pacient/pacients").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/pacient/{dni}", "/api/v1/dentist/{enrollment}",
                        "/api/v1/address/{dni}", "/api/v1/turn/{id}").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/api/v1/customer/register").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/dentist").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/api/v1/pacient", "/api/v1/address","/api/v1/turn").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/v1/dentist", "/api/v1/pacient","api/v1/turn").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/v1/address","/api/v1/customer/update/{id}").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/v1/dentist/{enrollment}", "/api/v1/pacient/{dni}",
                        "/api/v1/address/{dni}", "/api/v1/customer/delete/{id}","/api/v1/turn/{id}").hasRole("ADMIN")
                .anyRequest().authenticated();

    }

}
