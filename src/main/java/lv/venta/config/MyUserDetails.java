package lv.venta.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lv.venta.model.MyUser;

public class MyUserDetails implements UserDetails{

	private MyUser user;
	
	public MyUserDetails(MyUser inputUser)
	{
		//TODO add validation to not null
		user = inputUser;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		SimpleGrantedAuthority sga = new SimpleGrantedAuthority(user.getAuthority().getTitle());
		ArrayList<SimpleGrantedAuthority> allAuths = new ArrayList<SimpleGrantedAuthority>();
		allAuths.add(sga);
		return allAuths;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

}
