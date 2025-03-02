package com.security.homepage.securityservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.homepage.entity.AppUser;
import com.security.homepage.repository.AppUserRepository;

@Service
public class AppUserSecurityService implements UserDetailsService{

	@Autowired
	AppUserRepository appUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<AppUser> appUser=appUserRepository.findByUsername(username);
		if(appUser.isPresent()) {
			var user=appUser.get();
			return User.builder()
					.username(user.getUsername())
					.password(user.getPassword())
					//.roles(user.getRole())
					.roles(roleList(user))
					.build();
		}else
			throw new UsernameNotFoundException(username);
		
	}

	public String[] roleList(AppUser user) {
		if(user.getRole()==null)
			return new String[] {"USER"};
		return user.getRole().split(",");
	}
}
