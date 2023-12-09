public class Shirt extends Clothing implements IShop{
    // Zona de Atributos
    private String size;//S, M, L, XL

    // Zona de Métodos
    @Override
    public void fold(){
        System.out.println("a dobrar a camisa...");
    }

    @Override
    public String toString() {
        return "Shirt{" + "size='" + size + '\'' + "} " + super.toString();
    }

    @Override
    public void toDress() {
        System.out.println("A vestir camisa...");
    }

    @Override
    public void doReturn() {
        System.out.println("Devolver camisa.");
    }

    // Zona de construtores
    public Shirt(int id, String description, char colorCode, double price, String size){
        super(id, description, colorCode, price);
        this.setSize(size);
    }

    // Zona Getters e Setters
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
}
