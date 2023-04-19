package com.example.demo.model;

import java.io.Serializable;
import java.util.Collection; 
import java.util.List;
import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.Table; 
import org.springframework.security.core.GrantedAuthority; 
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.NoArgsConstructor; 

@Data
@NoArgsConstructor
@Entity 
@Table(name = "app_user") 
public class User implements Serializable { 

   /** 
   * 
   */ 
    private static final long serialVersionUID = 1L;

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "USER_NAME")
    private String username; 
    @Column(name = "ENCRYTED_PASSWORD")
    private String password;
    @Column(name = "ENABLED")
    private boolean enable;
    @Column(name = "ROLE")
    private String role;
   
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.role = "USER";
		this.enable = true;
	}
	
	public boolean hasRole(String roleName) {
         
        return this.getRole().equals(roleName);
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", enable="
				+ enable + ", role=" + role + "]";
	}
   
	
	
}