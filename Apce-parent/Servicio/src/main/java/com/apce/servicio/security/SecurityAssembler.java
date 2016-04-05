package com.apce.servicio.security;

import org.springframework.security.core.userdetails.User;

import com.apce.modelo.Usuario;

public class SecurityAssembler {
	
	User buildUserFromUserEntity(Usuario userEntity) {

   /* String username = userEntity.getNombre();
    String password = userEntity.getPass();
    boolean enabled = userEntity.isActivo();
    boolean accountNonExpired = userEntity.isActivo();
    boolean credentialsNonExpired = userEntity.isActivo();
    boolean accountNonLocked = userEntity.isActivo();

    User user = new User(username, password, enabled,
      accountNonExpired, credentialsNonExpired, accountNonLocked, authorities, id);
    return user;
	 */
		return null;
	}

}
