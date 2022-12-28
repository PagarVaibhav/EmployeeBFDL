package com.mpl.Service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails{

	 private static final long serialVersionUID = 1L;
     private String username;
     private String password;
     private boolean enabled;
     private Collection<? extends GrantedAuthority> authorities;

     public Collection<? extends GrantedAuthority> getAuthorities() {
         return authorities;
     }
     public String getPassword() {
         return password;
     }
   
     public String getUsername() {
         return username;
     }

     public boolean isAccountNonExpired() {
         return true;
     }

     public boolean isAccountNonLocked() {
         return true;
     }

     public boolean isCredentialsNonExpired() {
         return true;
     }
 
     public boolean isEnabled() {
         return enabled;
     }
     public void setUsername(String username) {
         this.username = username;
     }
     public void setPassword(String password) {
         this.password = password;
     }
     public void setEnabled(boolean enabled) {
         this.enabled = enabled;
     }
     public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
         this.authorities = authorities;
     }
}
