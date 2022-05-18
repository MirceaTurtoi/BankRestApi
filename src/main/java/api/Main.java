package api;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;

@SpringBootApplication
@AllArgsConstructor
@Slf4j
@Transactional
public class Main implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Main.class ,args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
