package com.nf.configurer;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by James on 10/03/18.
 */
@Component
@Configuration
@EnableWebMvc
public class NFCorsFilter implements Filter {
    
    public void init(FilterConfig filterConfig) throws ServletException
    {
        ServletContext context = filterConfig.getServletContext();
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.addHeader("Access-Control-Allow-Origin", "*");
        httpResponse.addHeader("Access-Control-Allow-Headers", "*");
        httpResponse.addHeader("Access-Control-Allow-Methods", "PUT,POST,GET,DELETE,OPTIONS");
        
         // ajax请求的时候如果带有xhrFields:{withCredentials:true}，
         //那么服务器后台在配置跨域的时候就必须要把Access-Control-Allow-Credentials这个请求头加上去

        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");//允许发送Cookie信息
        httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 支持HTTP 1.1.
        httpResponse.setHeader("Pragma", "no-cache"); // 支持HTTP 1.0. response.setHeader("Expires", "0");
        chain.doFilter(request, response);
    }
    
    public void destroy() {
        // TODO Auto-generated method stub
    }
}