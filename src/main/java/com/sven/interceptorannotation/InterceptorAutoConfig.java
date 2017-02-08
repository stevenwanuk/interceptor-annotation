package com.sven.interceptorannotation;

import java.util.Map;

import javax.servlet.Servlet;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass({ Servlet.class, DispatcherServlet.class,
        WebMvcConfigurerAdapter.class })
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE + 10)
public class InterceptorAutoConfig
{
    @Bean
    public WebMvcConfigurerAdapter autoRegisterInterceptors(ApplicationContext appContext)
    {
        return new WebMvcConfigurerAdapter()
        {
            @Override
            public void addInterceptors(final InterceptorRegistry registry)
            {

                Map<String, Object> map = appContext.getBeansWithAnnotation(SvenInterceptor.class);
                for (String beanName : map.keySet())
                {

                    SvenInterceptor annotation =
                            appContext.findAnnotationOnBean(beanName, SvenInterceptor.class);
                    registry.addInterceptor(
                            (HandlerInterceptor) map.get(beanName)).addPathPatterns(
                                    annotation.inclusivePathPatterns()).excludePathPatterns(annotation.exclusivePathPatterns());
                }
            }
        };
    }
}
