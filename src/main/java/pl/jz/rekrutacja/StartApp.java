package pl.jz.rekrutacja;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.jz.rekrutacja.model.Job;
import pl.jz.rekrutacja.model.Volunteer;
import pl.jz.rekrutacja.repo.JobRepository;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class StartApp {

    public static void main(String[] args) {
        SpringApplication.run(StartApp.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(JobRepository repository) {
        return args -> {
            repository.save(new Job(LocalDate.parse("2019-07-01"), LocalTime.parse("07:00"),LocalTime.parse("15:00"), new Volunteer("Jacek1","Zawislak1","Spec1")));
            repository.save(new Job(LocalDate.parse("2019-07-01"), LocalTime.parse("08:00"),LocalTime.parse("15:00"), new Volunteer("Jacek2","Zawislak12","Spec12")));
            repository.save(new Job(LocalDate.parse("2019-07-01"), LocalTime.parse("01:00"),LocalTime.parse("06:00"), new Volunteer("Jacek3","Zawislak13","Spec13")));
            repository.save(new Job(LocalDate.parse("2019-07-01"), LocalTime.parse("05:00"),LocalTime.parse("06:00"), new Volunteer("Jacek4","Zawislak14","Spec14")));

        };
    }
}
