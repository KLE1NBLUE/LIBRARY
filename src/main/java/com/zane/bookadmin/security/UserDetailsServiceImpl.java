package com.zane.bookadmin.security;

import com.zane.bookadmin.mapper.UserMapper;
import com.zane.bookadmin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findByUsername(username);
        if (user == null) throw new RuntimeException("用户名不存在");
        List<GrantedAuthority> authorities = new ArrayList<>();
        SimpleGrantedAuthority role = new SimpleGrantedAuthority("ROLE_" + user.getRole().getCode());
        authorities.add(role);
        System.out.println(user.getRole().getCode());
        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);
    }
}
