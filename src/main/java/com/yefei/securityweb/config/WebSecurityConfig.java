package com.yefei.securityweb.config;

import com.yefei.securityweb.auth.CustomAuthenticationProvider;
//import com.yefei.securityweb.filter.VerifyFilter;
import com.yefei.securityweb.auth.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

/**
 * @Author: yefei
 * @Date: create in 2019-11-19
 * @Desc:
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> authenticationDetailsSource;
    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return s.equals(charSequence.toString());
            }
        });

        auth.authenticationProvider(customAuthenticationProvider);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 如果有允许匿名的url，填在下面 ： 允许访问获取验证码的地址
                .antMatchers("/getVerifyCode").permitAll()
                //其他任何请求需要认证
                .anyRequest().authenticated()
                .and()
                // 设置登陆页
                .formLogin().loginPage("/login")
                // 设置登陆成功页
                .defaultSuccessUrl("/").permitAll()
                //指定登陆失败处理的url
                .failureUrl("/login/error")
                //指定authenticationDetailsSource , 获得用户登陆时携带的额外信息
                .authenticationDetailsSource(authenticationDetailsSource)
                .and()
                //在校验用户名密码之前先校验验证码
                //.addFilterBefore(new VerifyFilter(), UsernamePasswordAuthenticationFilter.class)
                .logout().permitAll()
                .and()
                .rememberMe()
                .tokenRepository(persistentTokenRepository())
                //有效时间：单位s
                .tokenValiditySeconds(60)
                .userDetailsService(userDetailsService)
                ;

        // 关闭CSRF跨域
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) {
        // 设置拦截忽略文件夹，可以对静态资源放行
        web.ignoring().antMatchers("/css/**", "/js/**");
    }


    @Autowired
    private DataSource dataSource;

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        // 如果token表不存在，使用下面语句可以初始化该表；若存在，请注释掉这条语句，否则会报错。
//        tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }

}
