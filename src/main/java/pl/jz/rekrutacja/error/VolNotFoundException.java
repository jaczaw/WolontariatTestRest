package pl.jz.rekrutacja.error;

public class VolNotFoundException extends RuntimeException {
    public VolNotFoundException(Long id) {
            super("Volunteer id not found : " + id);
    }
}
