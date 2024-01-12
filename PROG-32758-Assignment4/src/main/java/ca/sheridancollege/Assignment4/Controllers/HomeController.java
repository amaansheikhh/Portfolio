package ca.sheridancollege.Assignment4.Controllers;

import ca.sheridancollege.Assignment4.security.DatabaseAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {


    @Autowired
    @Lazy
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JdbcUserDetailsManager jdbcUserDetailsManager;
    @Autowired
    DatabaseAccess da;

    @GetMapping
    public String goHome(Authentication authentication, Model model) {
        if (authentication != null) {
            String userName = authentication.getName();
            List<String> roles = new ArrayList<>();
            List<GrantedAuthority> authorities = (List<GrantedAuthority>) authentication.getAuthorities();

            for (GrantedAuthority authority : authorities) {
                roles.add(authority.getAuthority());
            }
            model.addAttribute("userName", userName);
            model.addAttribute("roles", roles);
        }

        return "index";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping("/user")
    public String goToSecured() {
        return "secured/gateway";//user/index";//manager/manager_area";
    }

    @GetMapping("/manager")
    public String goToMangerSecured() {
        return "secured/manager/index";
    }

    @GetMapping("/manager/new-user")
    public String newUser(Model model) {
        List<String> authorities = da.getAuthorities();
        model.addAttribute("authorities", authorities);
        return "/secured/manager/new-user";
    }

    @PostMapping("manager/add-user")
    public String addUser(@RequestParam String userName, @RequestParam String password,
                          @RequestParam String[] authorities, Model model) {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for (String authority : authorities) {
            authorityList.add(new SimpleGrantedAuthority(authority));
        }
        /*
        String authority1 = authorities[0];
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authority1);
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority1);
        */
        String encodedPassword = passwordEncoder.encode(password);

        User user = new User(userName,encodedPassword,authorityList);

        jdbcUserDetailsManager.createUser(user);
        model.addAttribute("message","User Successfully added");

        return "/secured/gateway";
    }

    @GetMapping("/permission-denied")
    public String goToPermissionDenied(Model model,Authentication authentication){
        String userName = authentication.getName();
        model.addAttribute("userName", userName);
        return "error/permission-denied";
    }


}

