package br.com.systempus.systempus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig{

    @Bean
    public CorsFilter corsFilter(){
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");//Define a origem permitia
        config.addAllowedHeader("*");//Define os cabeçalhos permitidos
        config.addAllowedMethod("*");//Define os métodos HTTP permitidos

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration(("/**"), config);// "/**" é um padrão curinga que corresponde a qualquer URL

        return new CorsFilter(source);
    }
}