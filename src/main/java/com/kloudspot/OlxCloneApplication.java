package com.kloudspot;

import com.kloudspot.models.User;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OlxCloneApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OlxCloneApplication.class, args);

        User user = new User();
        user.getAddress();
	}

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub

    }

}
