package com.freshvotes;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class UserDetailsServiceTest {

	@Test
	public void generateEncryptedPassword() {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "test456";
		String encodedPassword = encoder.encode(rawPassword);
		
		System.out.println(encodedPassword);
		
		assertThat(rawPassword).isNotSameAs(encodedPassword);
	}
}