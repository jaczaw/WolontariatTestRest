package pl.jz.rekrutacja.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Volunteer {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String imie;
        private String nazwisko;
        private String spec;
       // @OneToMany(mappedBy = "volunteer")
       // private List<Job> jobs = new ArrayList<>();


    public Volunteer() {
    }


    public Volunteer(String imie, String nazwisko, String spec) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.spec = spec;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

 /*   public List<Job> getJobs() {
        return jobs;
    }

   public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
 }

  */

    @Override
    public String toString() {
        return "Volunteer{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", spec='" + spec + '\'' +
                '}';
    }
}

