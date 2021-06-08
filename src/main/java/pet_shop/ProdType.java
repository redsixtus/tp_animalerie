package pet_shop;

public enum ProdType {
    FOOD("nouriture"), ACCESSORY("accesoires"),CLEANING("netoiyage");

    private String type;

    ProdType(String type) {
        this.type = type;
    }
}
