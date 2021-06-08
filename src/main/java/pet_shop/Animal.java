package pet_shop;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
@Entity
@Table(name = "ANIMAL")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
public class Animal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DATE_NAISSANCE")
    private LocalDate birth;
    @Column(name = "COULEUR")
    private String color;


    @ManyToOne
    @JoinColumn(name="ID_PETSHOP")
    private PetStore petStore;

    public Animal(int id, LocalDate birth, String color) {
        this.id = id;
        this.birth = birth;
        this.color = color;
    }

    public Animal(LocalDate birth, String color) {
        this.birth = birth;
        this.color = color;
    }

    public Animal() {
    }

    public Animal(LocalDate birth, String color, PetStore petStore) {
        this.birth = birth;
        this.color = color;
        this.petStore = petStore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", birth=" + birth +
                ", color='" + color + '\'' +
                ", petStore=" + petStore +
                '}';
    }
}
