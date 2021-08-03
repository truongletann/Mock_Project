package com.mock.service.imp;


import com.mock.dto.UserDetailDTO;
import com.mock.entity.User;
import com.mock.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user==null) throw new UsernameNotFoundException("Account does not exist !");
        String roleName = userRepository.getRoleName(user.getUser_id());
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(roleName));

        return new UserDetailDTO(user.getUser_id(),user.getEmail(), user.getPassword(),user.getAvatar(),user.getFull_name(),authorities);
    }
}
