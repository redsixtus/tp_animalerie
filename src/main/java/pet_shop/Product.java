package pet_shop;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name ="CODE")
    private String code;
    @Enumerated(EnumType.STRING)
    @Column(name ="TYPE")
    private ProdType type;
    @Column(name ="PRIX")
    private Double price;


    @ManyToMany(cascade={CascadeType.REMOVE,CascadeType.PERSIST})
    @JoinTable(name = "PRODUCT_PETSHOP",
            joinColumns = @JoinColumn(name = "ID_PETSHOP",referencedColumnName = "ID"),
            inverseJoinColumns= @JoinColumn(name = "ID_PRODUCT",referencedColumnName = "ID"))
    private Set<PetStore> petStores;


    {
        this.petStores= new HashSet<>();

    }

    public Product(String code, ProdType type, Double price) {
        this.code = code;
        this.type = type;
        this.price = price;
    }

    public Product(ProdType type, Double price) {
        this.type = type;
        this.price = price;
    }

    public Product(String code, ProdType type) {
        this.code = code;
        this.type = type;
    }

    public Product() {

    }



    public Product(String code, ProdType type, Double price, Set<PetStore> petStores) {
        this.code = code;
        this.type = type;
        this.price = price;
        this.petStores = petStores;
    }

    public Set<PetStore> getPetStores() {
        return petStores;
    }

    public void setPetStores(Set<PetStore> petStores) {
        this.petStores = petStores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ProdType getType() {
        return type;
    }

    public void setType(ProdType type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }






}
