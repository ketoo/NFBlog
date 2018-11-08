package com.nf.configurer;

import com.nf.services.NFIUserPermissionModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by James on 10/03/18.
 */
@Component
@Configuration
@EnableWebMvc
public class NFJWTFilter implements Filter
{
    private static final Logger logger = LoggerFactory.getLogger(NFJWTFilter.class);
    
    @Autowired
    private NFIUserPermissionModule userPermissionModule;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        ServletContext context = filterConfig.getServletContext();
        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(context);
        userPermissionModule = (NFIUserPermissionModule)applicationContext.getBean("userPermissionModule");
    }
    
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String path = request.getRequestURI();
        //String empId = (String) session.getAttribute("jwt")
        
        if (request.getMethod().equalsIgnoreCase("OPTIONS"))
        {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else
        {
            if (!checkToken(request))
            {
                response.setContentType("application/json");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            } else
            {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }
    
    @Override
    public void destroy()
    {
    
    }
    
    private boolean checkToken(HttpServletRequest request)
    {
        String userId = request.getHeader("UserID");
        String token = request.getHeader("Token");
        
        if (userId == null || userId.isEmpty()
                || token == null || token.isEmpty())
        {
            return false;
        }
    
        return userPermissionModule.checkJWT(userId, token);
    }
}
