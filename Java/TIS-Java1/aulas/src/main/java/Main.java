import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(); // cria ArrayList, não aceita dados Primitivos
        arrayList.add("Java"); // Adiciona ao ArrayList
        arrayList.add("C++");
        System.out.println(arrayList);

        ArrayList<Integer> arrayList2 = new ArrayList<>(); // aceita dados primitivos com um wrapper

        Integer varInt=5;
        Double varDouble=5.3;
        Character carVhar='A';
        Boolean varBool=false;
        System.out.println(varInt+varInt); // nem sempre permite fazer contas com objetos
        // pode ser preciso converter, existem métodos próprios para isso
        System.out.println(varInt.intValue());// isto devolve o valor int que estava no objetp Integer

        arrayList2.add(9);
        arrayList2.add(12);
        arrayList2.add(9);
        arrayList2.add(3);
        arrayList2.add(1,4);// adiciona na posição e arrasta tudo para a frente
        System.out.println(arrayList2);
        System.out.println(arrayList2.get(2));// vai buscar o dado no indice definido
        System.out.println(arrayList2.get(arrayList2.size()-1));// vai buscar o ultimo elemento do arraylist
        System.out.println(arrayList2.lastIndexOf(9));// vai buscar indice do ultimo valor fornecido
        System.out.println(arrayList2.indexOf(9));// vai buscar indice do primeiro valor fornecido
        System.out.println(arrayList2.contains(12));// verifica se o objeto existe no arraylist, retorna true or false
        arrayList2.set(0, 10);// especificamos o indice e o valor a substituir
        System.out.println(arrayList2);

        arrayList2.remove(3); // remove pelo indice
        System.out.println(arrayList2);

        ArrayList<String> arrayList3 = new ArrayList<>();
        arrayList3.add("Java");
        arrayList3.add("Python");
        arrayList3.add("C++");
        arrayList3.add("C#");
        arrayList3.add("HTML");
        arrayList3.add("CSS");
        //arrayList3.remove("C#"); // remover pelo conteúdo do objeto, só remove a primeira ocorrencia do objeto
        System.out.println(arrayList3);

        // remover percorrendo o arraylist

        /*
        for (String elems : arrayList3) {
            if (elems.equals("C#")) {
                arrayList3.remove(elems);
            }
        }
        System.out.println(arrayList3);
         */

        ArrayList<String> arrCoisas = new ArrayList<>();
        arrCoisas.add("HTML");
        arrCoisas.add("CSS");
        arrayList3.removeAll(arrCoisas); // remove de arrayList3 todos os elementos do arrCoisas, Têm de ter o mesmo tipo
        System.out.println(arrayList3);

        // copiar de um arrayList para outro
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();
        ArrayList<String> arr3 = new ArrayList<>();

        arr1.add("Leandro");
        arr1.add("Fábio");
        arr1.add("Pedro");
        arr1.add("Inês");
        arr1.add("Cristina");
        arr1.add("Lucas");

        for (String elems:arr1) {
            arr2.add(elems);
        }

        arr3.addAll(arr1);

        System.out.println(arr1);
        System.out.println(arr2);
        System.out.println(arr3);
    }
}
