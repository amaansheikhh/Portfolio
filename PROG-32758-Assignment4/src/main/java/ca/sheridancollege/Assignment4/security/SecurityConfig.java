package ca.sheridancollege.Assignment4.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private LoggingAccessDeniedHandler accessDeniedHandler;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Autowired
    @Lazy
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private DataSource dataSource;

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/user/**").hasAnyRole("USER","MANAGER")
                .antMatchers("/manager/**").hasAnyRole("MANAGER")
                .antMatchers("/","/**").permitAll()
                //allow access to the h2-console
                .antMatchers("/h2-console/**").permitAll()
                .and()
                .formLogin().loginPage("/login")
                .defaultSuccessUrl("/secured").and().logout().permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler);


            http.csrf().disable();
            http.headers().frameOptions().disable();
    }/*
    http.authorizeRequests()
            .antMatchers("/user/**").hasAnyRole("USER","MANAGER")
                .antMatchers("/","/**").permitAll()
                .and()
                .formLogin()
                .defaultSuccessUrl("/secured").and().logout().permitAll();
}*/

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       /* auth.inMemoryAuthentication()
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                //.("bugs").password("bunny").roles("USER")
                .withUser("bugs").password("bunny").roles("USER")
                .and()
                .withUser("daffy").password("duck").roles("USER","MANAGER");
    */
         auth.jdbcAuthentication()
                .dataSource(dataSource)
                .withDefaultSchema()
                //.withUser(userDetailsService())
                .passwordEncoder(passwordEncoder)
                .withUser("bugs").password(passwordEncoder.encode("bunny"))
                .roles("USER")
                .and()
                .withUser("daffy").password(passwordEncoder.encode("duck"))
                .roles("USER","MANAGER");
         /*
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .withDefaultSchema()
                //.withUser(userDetailsService())
                .passwordEncoder(passwordEncoder)
                .withUser("bugs").password(passwordEncoder.encode("bunny"))
                .roles("USER")
                .and()
                .withUser("daffy").password(passwordEncoder.encode("duck"))
                .roles("USER","MANAGER")
                .and()
                .withUser("amaan").password(passwordEncoder.encode("amaan"))
                .roles("admin");

*/
    }
        /*
        @Bean
        public JdbcUserDetailsManager jdbcUserDetailsManager() throws Exception{
            JdbcUserDetailsManager.
        }*/

    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager() throws Exception{
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
        jdbcUserDetailsManager.setDataSource(dataSource);
        return jdbcUserDetailsManager;
    }

}
