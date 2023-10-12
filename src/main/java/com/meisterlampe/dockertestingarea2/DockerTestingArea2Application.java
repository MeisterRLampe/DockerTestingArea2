package com.meisterlampe.dockertestingarea2;

import com.meisterlampe.dockertestingarea2.entities.Role;
import com.meisterlampe.dockertestingarea2.entities.User;
import com.meisterlampe.dockertestingarea2.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class DockerTestingArea2Application implements CommandLineRunner {

    private final UserRepository userRepository;


    public DockerTestingArea2Application(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public static void main(String[] args) {
        SpringApplication.run(DockerTestingArea2Application.class, args);
    }


    public void run(String... args) {
        User adminAccount = userRepository.findByRole(Role.ADMIN);
        if(null == adminAccount){
            User user = new User();

            user.setEmail("admin@gmail.com");
            user.setFirstname("admin");
            user.setLastname("admin");
            user.setRole(Role.ADMIN);
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(user);
        }
    }
}
