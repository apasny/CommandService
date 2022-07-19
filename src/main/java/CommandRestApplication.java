import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"api", "entity", "mapper", "repository"})
public class CommandRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommandRestApplication.class, args);
    }
}