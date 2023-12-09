public class Tent implements IShop, ICoiso{
    private static int id=0;

    private int idTent;
    private int maxPessoas;
    private String material;
    private int nrQuartos;

    @Override
    public String toString() {
        return "Tent{" + "maxPessoas=" + maxPessoas + ", material='" + material + '\'' + ", nrQuartos=" + nrQuartos + '}';
    }

    @Override
    public void doReturn() {
        System.out.println("Devolver tenda.");
    }

    public void doComplaint(String name){
        System.out.println("Cliente "+name+" está a reclamar e a chorar!!");
    }

    public Tent(int maxPessoas, String material, int nrQuartos) {
        id++;
        this.idTent=id;
        this.setMaxPessoas(maxPessoas);
        this.setMaterial(material);
        this.setNrQuartos(nrQuartos);
    }

    public int getMaxPessoas() {
        return this.maxPessoas;
    }

    public void setMaxPessoas(int maxPessoas) {
        this.maxPessoas = maxPessoas;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getNrQuartos() {
        return this.nrQuartos;
    }

    public void setNrQuartos(int nrQuartos) {
        this.nrQuartos = nrQuartos;
    }

    public int getIdTent() {return this.idTent;}

    public void setIdTent(int id) {this.idTent = idTent;}
}
