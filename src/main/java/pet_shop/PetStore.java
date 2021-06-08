package pet_shop;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PETSHOP")
public class PetStore implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name ="NOM")
    private String name;
    @Column(name = "NAME_MANAGER")
    private String ManagerName;
    @Embedded
    private Adresse adresse;

    @ManyToMany(cascade={CascadeType.REMOVE,CascadeType.PERSIST})
    @JoinTable(name = "PRODUCT_PETSHOP",
            joinColumns = @JoinColumn(name = "ID_PRODUCT",referencedColumnName = "ID"),
            inverseJoinColumns= @JoinColumn(name = "ID_PETSHOP",referencedColumnName = "ID"))
    private Set<Product>products;

    @OneToMany(mappedBy = "petStore", cascade ={CascadeType.REMOVE,CascadeType.PERSIST})
    private Set<Animal> animals;


    {
        this.products= new HashSet<>();
        this.animals= new HashSet<>();
    }


    public PetStore() {
    }

    public PetStore(String name, String managerName, Adresse adresse) {
        this.name = name;
        this.ManagerName = managerName;
        this.adresse = adresse;
    }

    public PetStore(Set<Animal> animals) {
        this.animals = animals;
    }

    public PetStore(String name, String managerName, Adresse adresse, Set<Product> products, Set<Animal> animals) {
        this.name = name;
        ManagerName = managerName;
        this.adresse = adresse;
        this.products = products;
        this.animals = animals;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return ManagerName;
    }

    public void setManagerName(String managerName) {
        ManagerName = managerName;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }



    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "PetStore{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ManagerName='" + ManagerName + '\'' +
                ", adresse=" + adresse +
                ", products=" + products +
                ", animals=" + animals +
                '}';
    }
}
