import java.util.ArrayList;

public class aula08 {
    public static void main(String[] args) {
        //Clothing roupa=new Clothing(1, "uma peça de roupa", 'R', 120.0);

        //System.out.println(roupa.toString());
        //roupa.fold();

        Shirt camisa=new Shirt(1, "uma peça de roupa", 'R', 120.0, "M");
        System.out.println(camisa.toString());
        camisa.fold();
        camisa.Ola();
        camisa.doComplaint("António");
        Tent tenda1=new Tent(4, "Algodão", 2);
        Tent tenda2=new Tent(7, "Algodão", 4);
        System.out.println(tenda1.getIdTent());
        System.out.println(tenda2.getIdTent());
        //tenda.Ola();
        //tenda.doComplaint("Zéquinha");

    }
}
