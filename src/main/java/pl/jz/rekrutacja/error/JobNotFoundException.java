package pl.jz.rekrutacja.error;

public class JobNotFoundException extends RuntimeException {
    public JobNotFoundException(Long id) {
            super("Job id not found : " + id);
    }
}
