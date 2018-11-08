package com.nf.configurer;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 10/03/18.
 */
@Component
@Configuration
@EnableWebMvc
public class NFCorsConfigurerAdapter extends WebMvcConfigurerAdapter
{
    @Bean
    public FilterRegistrationBean getTokenValidationFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        
        List<String> urlPatterns = new ArrayList<String>();

        urlPatterns.add("/admin/*");
        
        filterRegistrationBean.setFilter(new NFJWTFilter());
        filterRegistrationBean.setUrlPatterns(urlPatterns);
        filterRegistrationBean.setOrder(Integer.MAX_VALUE);
        return filterRegistrationBean;
    }
}
