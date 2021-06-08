package pet_shop;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("C")
public class Cat extends Animal implements Serializable {
    @Column(name = "CHIPID")
    private String chipid;

    public Cat(int id, LocalDate birth, String color, String chipid) {
        super(id, birth, color);
        this.chipid = chipid;
    }

    public Cat(LocalDate birth, String color, String chipid) {
        super(birth, color);
        this.chipid = chipid;
    }

    public Cat(String chipid) {
        this.chipid = chipid;
    }

    public Cat() {

    }
}
