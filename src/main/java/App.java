import pet_shop.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {
    EntityManagerFactory emf;
    private static String CHERCHE_TON_MATOU = "SELECT a FROM Animal a WHERE a.petStore.id = :id";


    public static List<Animal> cherchetonmatou (PetStore petStore) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petshop");;
        EntityManager em = emf.createEntityManager();
        TypedQuery<Animal> query = em.createQuery(CHERCHE_TON_MATOU, Animal.class);
        query.setParameter("id", petStore.getId());
        return query.getResultList();
    }



    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petshop");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        PetStore petStore= new PetStore("CatShop","kevin trouillard" ,new Adresse("5","rue des lila","53000","Mayenne"));
        Animal animal= new Cat(LocalDate.of(2021,3,16),"blue","12345");
        Product product= new Product("1236", ProdType.FOOD,350.5);

        petStore.getAnimals().add(animal);
        petStore.getProducts().add(product);

        animal.setPetStore(petStore);

        em.persist(petStore);



        PetStore petStore2= new PetStore("FishShop","Obiwan Kennobie" ,new Adresse("5","boulevard de l'etoile noir","75000","Paris"));
        Animal animal2= new Fish(LocalDate.now(),"rouges",FishLivEnv.FRECH_WATER);
        Product product2= new Product("1236", ProdType.ACCESSORY,350.5);

        petStore2.getAnimals().add(animal2);
        petStore2.getProducts().add(product2);

        animal2.setPetStore(petStore2);

        em.persist(petStore2);

        PetStore petStore3= new PetStore("FishandCatShop","Indian Jones" ,new Adresse("6","rue du sacrée Graal","44000","Nantes"));
        Animal animal3= new Fish(LocalDate.now(),"Noir",FishLivEnv.FRECH_WATER);
        Animal animal4= new Cat(LocalDate.of(2020,6,15),"roux","1259");
        Product product3= new Product("12", ProdType.CLEANING,50.5);

        petStore3.getAnimals().add(animal3);
        petStore3.getAnimals().add(animal4);
        petStore3.getProducts().add(product3);
        animal4.setPetStore(petStore3);
        animal3.setPetStore(petStore3);

        em.persist(petStore3);

        //List<Animal> animals = cherchetonmatou(em.find(PetStore.class, 3));
        //System.out.println(animals);

        em.getTransaction().commit();


        em.close();
        emf.close();

    }

}
