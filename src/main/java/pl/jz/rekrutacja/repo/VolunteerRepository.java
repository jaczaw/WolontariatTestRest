package pl.jz.rekrutacja.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jz.rekrutacja.model.Volunteer;

public interface VolunteerRepository extends JpaRepository<Volunteer,Long> {

}
