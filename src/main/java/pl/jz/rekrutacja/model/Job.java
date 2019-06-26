package pl.jz.rekrutacja.model;



import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate jobDate;
    private LocalTime startJobTime;
    private LocalTime endJobTime;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "volunteer_id")
    private Volunteer volunteer;

    public Job() {
    }

    public Job(LocalDate jobDate, LocalTime startJobTime, LocalTime endJobTime, Volunteer volunteer) {
        this.jobDate = jobDate;
        this.startJobTime = startJobTime;
        this.endJobTime = endJobTime;
        this.volunteer = volunteer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getJobDate() {
        return jobDate;
    }

    public void setJobDate(LocalDate jobDate) {
        this.jobDate = jobDate;
    }

    public LocalTime getStartJobTime() {
        return startJobTime;
    }

    public void setStartJobTime(LocalTime startJobTime) {
        this.startJobTime = startJobTime;
    }

    public LocalTime getEndJobTime() {
        return endJobTime;
    }

    public void setEndJobTime(LocalTime endJobTime) {
        this.endJobTime = endJobTime;
    }

    public Volunteer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Volunteer volunteer) {
        this.volunteer = volunteer;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", jobDate=" + jobDate +
                ", startJobTime=" + startJobTime +
                ", endJobTime=" + endJobTime +
                ", volunteer=" + volunteer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id.equals(job.id) &&
                jobDate.equals(job.jobDate) &&
                startJobTime.equals(job.startJobTime) &&
                endJobTime.equals(job.endJobTime) &&
                Objects.equals(volunteer, job.volunteer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startJobTime, endJobTime);
    }
}
