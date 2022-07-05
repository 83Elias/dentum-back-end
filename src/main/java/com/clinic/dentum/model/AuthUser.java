package com.clinic.dentum.model;


import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Entity
@Table(name = "AUTH_USER")
@Data
public class AuthUser implements UserDetails {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "USER_NAME", unique = true)
	private String userName;

	@Column(name = "USER_PASSWORD")
	private String password;

	@Column(name = "CREATED_ON")
	private LocalDateTime createdAt;

	@Column(name = "UPDATED_ON")
	private LocalDateTime updatedAt;

	@Column(name = "dni")
	private String dni;

	@Column(name = "enabled")
	private boolean enabled=true;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "AUTH_USER_AUTHORITY", 
    joinColumns = @JoinColumn(name="user_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="rol_id",referencedColumnName ="id"))
	private List<AuthRol> authoritiesRol;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authoritiesRol;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {

        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
       
        return this.enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
     
        return this.enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
    
        return this.enabled;
    }

    @Override
    public boolean isEnabled() {
 
        return this.enabled;
    }

}
