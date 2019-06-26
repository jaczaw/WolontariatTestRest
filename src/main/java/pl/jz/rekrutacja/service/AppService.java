package pl.jz.rekrutacja.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.jz.rekrutacja.repo.JobRepository;

public class AppService {

    //(a.startTime < b.endTime) AND (a.endTime > b.startTime)

    @Autowired
    private JobRepository jobRepository;



}
