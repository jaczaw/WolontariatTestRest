package pl.jz.rekrutacja.util;

import pl.jz.rekrutacja.model.Job;

import java.time.LocalTime;
import java.util.List;

public class HelperDouble {

    public static boolean checkDateAndTime(Job job, LocalTime dataOd, LocalTime dataDo)
    {
        if( dataOd.isBefore(job.getEndJobTime())  && dataDo.isAfter(job.getStartJobTime()))
        {
            return true;
        }
        return false;
    }

  }
