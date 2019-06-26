package pl.jz.rekrutacja.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jz.rekrutacja.model.Job;

public interface JobRepository extends JpaRepository<Job,Long> {

}
