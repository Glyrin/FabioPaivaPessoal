public class Sock extends Clothing{
    private int size;

    public Sock(int id, String description, char colorCode, double price, int size) {
        super(id, description, colorCode, price);
        this.setSize(size);
    }

    @Override
    public String toString() {
        return "Sock{" + "size=" + size + "} " + super.toString();
    }

    @Override
    public void toDress() {
        System.out.println("A calçar meias...");
    }

    @Override
    public void fold() {
        System.out.println("A dobrar meias...");
    }



    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
