package com.woniu.config;
import com.woniu.filter.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    private MyAuthenticationSuccessHandler successHandler;

    @Autowired
    private MyAuthenticationFailureHandler failureHandler;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtTokenFilter jwtTokenFilter;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MyAccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //通过我们自己定义的实现类来做认证
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //跨域
        http.cors(Customizer.withDefaults());

        // http.httpBasic().and()
        //         .authorizeRequests() //所有请求都需要鉴权
        //         .anyRequest().authenticated(); //所有请求都需要认证（登录）

        http.authorizeRequests() //鉴权
                .antMatchers("/login","/assets/img/*","/returnUrl").permitAll()//放行的请求
                .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()  //允许option请求通过
                .anyRequest().authenticated(); //其他的所有请求都需要认证

        http.formLogin() //自定义登录页
                .loginPage("/static/login.html") //登录页页面
                .loginProcessingUrl("/login") //处理认证请求的路径，对应表单的action
                .usernameParameter("username").passwordParameter("password") //对应表单中的name
                //.defaultSuccessUrl("/home")//认证成功默认跳转的路径
                //.failureUrl("/error1").permitAll(); //失败跳转路径
                .successHandler(successHandler)  //登录成功的处理
                .failureHandler(failureHandler)  //登录失败
                .and().exceptionHandling()//.authenticationEntryPoint(myAuthenticationEntryPoint) //未登录时，前后端分离
                .accessDeniedHandler(accessDeniedHandler)   //权限不足
                .and().addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)  //将jwt校验过滤器放在认证过滤器之前

        ;
        //关闭csrf跨域
        http.csrf().disable();
        //让session失效
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }


}
