package pdp.uz.rentcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class RentCarApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentCarApplication.class, args);
        System.out.println(UUID.randomUUID());
    }

}
