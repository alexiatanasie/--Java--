package main;

import classes.Sum;
import com.sun.source.tree.UsesTree;
import interfaces.BinaryOperator;
import interfaces.Displayable;
import interfaces.Printable;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        BinaryOperator binaryOperator=new Sum();
        System.out.println(binaryOperator.operate(2,3));
        binaryOperator=new BinaryOperator() {
            @Override
            public double operate(double operand1, double operand2) {
                return operand1-operand2;//cls anonima derivata din binaryop, nu are nume(anonima), nu o pot salva in alta parte pt ca nu stiu cum se numeste

            }
        };
        new Sum().operate(2, 3);//obiect anonim
        //ftc lamba nu se mai specifica tipul parametrilor, se subintelege
        binaryOperator=(o1,o2)->o1*o2;
        System.out.println(binaryOperator.operate(3,5));
        binaryOperator=(x,y)->{  //pun acolade daca vreau mai multe op, return e obligatoriu daca folosesc {}
            double sum=x+y;
            return sum/2;
        };
       // binaryOperator = (x, y) -> x + y;  ca sa se afiseze 9,
        double result=binaryOperator.operate(4,5);
        System.out.println(result); //aici se afiseaza 4.5 de la astea 2 adunate

        Displayable d=()-> System.out.println("hello lumeee");
        d.display();

        Printable p=pp-> System.out.println(pp);
        p.print("hi");

        //O funcție lambda este o formă scurtă de a scrie o funcție anonimă — adică o funcție fără nume, care poate fi transmisă sau stocată într-o variabilă.
        //Se folosește în special atunci când lucrezi cu interfețe funcționale (care au o singură metodă abstractă).

        //STREAM
        //Un stream este o secvență de date (elemente) care pot fi procesate într-un mod funcțional, adică fără bucle clasice (for, while) și fără a modifica direct colecțiile.
       /*
       filter- filtreaza elem dupa o conditie
       map-trnasforma fiecare elem al stream ului(ex UPPPER)
       sorted sorteaza (var cresc e asta )
       distinct - elimina duplicatele
       limit - pastreaza doar primele n elem
       collect -transforma rezultatul intr-o lista/set
       forEach executa ceva pt fiecare elem
       count nr cate elem sunt
       get extrage valoarea dintr-un optional, cand fol reducer,findFirst,max,min rezultatul e optional pt ca nu e garantat xa se gaseset o valoare,deci pun get asta
       reduce combina toate elem intr-un singur rezultat
       stream transforma o colectie(List,Set,Array) intr-un stream, adica o"banda"de elem care pot fi procesate functional
       */

        List<Integer>list=List.of(5,2,4,6,7,8);
        long number= list.stream().filter(x->x>=5).count();
        System.out.println(number);

        List<Integer>list2=list.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(list2);

        //sortare descrescatoare
        List<Integer>list22=list.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(list22);

        //nr pare
        List<Integer>par=list.stream().filter(n->n%2==0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(par);

        List<String>strings=List.of("Alexia","Anto","Andreea","Diva");
        String s=strings.stream().map(String::toUpperCase).reduce((x,y)->x+' '+y).get();
        System.out.println(s);

        strings.forEach(System.out::println); //parcurge fiecare elem din lista strings si il afis pe consola
        //e echivalent cu :
        // for (String s : strings) {
        //    System.out.println(s);
        //}
    }
}