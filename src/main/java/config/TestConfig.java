package config;

import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import repositories.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) {
        User user1 = new User(null, "John Doe", "john@example.com", "123456789", "password123");
        User user2 = new User(null, "Jane Smith", "jane@example.com", "987654321", "password456");

        userRepository.save(user1);
        userRepository.save(user2);

        System.out.println("Dados populados com sucesso!");
    }
}