package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	
	 
	    @Autowired
	    private TestEntityManager entityManager;
	     
	    @Autowired
	    private UserRepository repo;
	    
	    @Test
	    public void testCreateUser(){
	    User user = new User();
	    user.setEmail("ravikumar@gmail.com");
	    user.setPassword("ravi2020");
	    user.setFirstName("ravi");
	    user.setLastName("kumar");
	    
	    User saveUser = repo.save(user);
	    
	    User exitUser = entityManager.find(User.class, saveUser.getId());
	    
	    assertThat(exitUser.getEmail()).isEqualTo(user.getEmail());
	    
	    }

}
