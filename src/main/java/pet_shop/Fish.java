package pet_shop;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("F")
public class Fish extends Animal implements Serializable {
    @Enumerated(EnumType.STRING)
    @Column(name = "LIVINGENV")
    private FishLivEnv livingEnv;

    public Fish(int id, LocalDate birth, String color, FishLivEnv livingEnv) {
        super(id, birth, color);
        this.livingEnv = livingEnv;
    }

    public Fish(LocalDate birth, String color, FishLivEnv livingEnv) {
        super(birth, color);
        this.livingEnv = livingEnv;
    }

    public Fish(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    public Fish() {

    }

    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "livingEnv=" + livingEnv +
                '}';
    }
}
