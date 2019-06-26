package pl.jz.rekrutacja.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.jz.rekrutacja.error.JobNotFoundException;
import pl.jz.rekrutacja.error.VolNotFoundException;
import pl.jz.rekrutacja.model.Job;
import pl.jz.rekrutacja.model.Volunteer;
import pl.jz.rekrutacja.repo.JobRepository;
import pl.jz.rekrutacja.repo.VolunteerRepository;
import java.util.List;


@RestController
public class VolunteeRest {


    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private VolunteerRepository volunteerRepository;

    // Find all job
    @GetMapping("/jobs")
       List<Job> findAll() {

        return jobRepository.findAll();
    }

    // Find all Vol
    @GetMapping("/vol")
    List<Volunteer> findAllVol() {

        return volunteerRepository.findAll();
    }

    //(a.startTime < b.endTime) AND (a.endTime > b.startTime)
    @GetMapping("/dubel")
    int countDuble() {
        List<Job> lista = jobRepository.findAll();
        int count = 0;

        for (Job job:lista){

            if(job.getStartJobTime().isBefore(job.getEndJobTime()) &&
                    job.getEndJobTime().isAfter(job.getStartJobTime())){
                count++;
            }
       }
        return count;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/job")
    Job newJob(@RequestBody Job newJob) {
        return jobRepository.save(newJob);
    }


    @GetMapping("/job/{id}")
    Job findOneJob(@PathVariable Long id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new JobNotFoundException(id));
    }
    @GetMapping("/vol/{id}")
    Volunteer findOneVol(@PathVariable Long id) {
        return volunteerRepository.findById(id)
                .orElseThrow(() -> new VolNotFoundException(id));
    }


    @PutMapping("/job/{id}")
    Job saveOrUpdateJob(@RequestBody Job newJob, @PathVariable Long id) {

        return jobRepository.findById(id)
                .map(x -> {
                    x.setJobDate(newJob.getJobDate());
                    x.setStartJobTime(newJob.getStartJobTime());
                    x.setEndJobTime(newJob.getEndJobTime());
                    x.setVolunteer(newJob.getVolunteer());
                    return jobRepository.save(x);
                })
                .orElseGet(() -> {
                    newJob.setId(id);
                    return jobRepository.save(newJob);
                });
    }


    @DeleteMapping("/job/{id}")
    void deleteJob(@PathVariable Long id) {
        jobRepository.deleteById(id);
    }


}
