public abstract class Clothing implements ICoiso{
    // Zona de Atributos
    private int id=0;
    private String description="-description required-";
    private char colorCode='U'; //R-red, B-blue, G-verde, U-Undefined
    private double price=0.0;

    // Zona de Métodos
    public void fold(){
        System.out.println("a dobrar a roupa...");
    }

    @Override
    public String toString() {
        return "Clothing{" + "id=" + id + ", description='" + description + '\'' + ", colorCode=" + colorCode +
                ", price=" + price + '}';
    }


    public abstract void toDress();

    // Zona de construtores
    public Clothing(int id, String description, char colorCode, double price) {
        this.setId(id);
        this.setDescription(description);
        this.setColorCode(colorCode);
        this.setPrice(price);
    }

    // Zona Getters e Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public char getColorCode() {
        return colorCode;
    }
    public void setColorCode(char colorCode) {
        if(colorCode!='R' || colorCode!='B' || colorCode!='G'){
            this.colorCode = 'U';
        }else{
            this.colorCode = colorCode;
        }
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        if (price<0) {
            this.price = 0.0;
        }else{
            this.price = price;
        }
    }

}
