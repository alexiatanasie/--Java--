import java.util.BitSet;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Stack;
import java.util.Vector;

public class Section7 {

    //public enum Animals { //here is an error....wtfff
//        DOG, LION, CAT
//    }

    public static void main(String[] args) {
//        Animals a = Animals.CAT;
//        if (a == Animals.DOG) {
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }
    	
    	//LIFO
    	Stack stk=new Stack();
    	stk.push(1);
    	stk.push(2);
    	stk.push(3);
    	stk.push(5.7);
    	stk.push("ale!");
    	System.out.println(stk);
    	System.out.println(stk.get(4));
    	
    	stk.pop();
    	System.out.println(stk);
    	
    	stk.pop();
    	System.out.println(stk);
    	
    	//VECTOR
    	Vector vect=new Vector();
    	vect.addElement(2);
    	vect.addElement("Ale<3");
    	System.out.println(vect);
    	
    	System.out.println(vect.get(1));
    	
    	vect.addElement(2);
    	vect.addElement(23);
    	vect.addElement(21);
    	vect.addElement(24);
    	vect.addElement(12);
    	vect.addElement(62);
    	vect.addElement(25);
    	vect.addElement(20);
    	vect.addElement(72);
    	vect.addElement(82);
    	vect.addElement(29);
    	
    	Enumeration e=vect.elements();   
    	while(e.hasMoreElements()) {
    		System.out.println(e.nextElement());
    	}
    	System.out.println("vector initial " + vect);

        //sortare elemente
        List<Object> list = Collections.list(vect.elements());
        list.sort((o1, o2) -> {
            if (o1 instanceof Integer && o2 instanceof Integer) {
                return Integer.compare((Integer) o1, (Integer) o2);
            }
            return 0; //nu sortez elemente care nu sunt de tip Integer
        });

        
        System.out.println("vector sortat: " + list);

        Enumeration<Object> en = Collections.enumeration(list);
        System.out.println("elementele in ordine crescatoare:");
        while (en.hasMoreElements()) {
            System.out.println(en.nextElement());
        }
        
        //BITSET
        BitSet b1=new BitSet();
        BitSet b2=new BitSet();
        
        b1.set(0, false);
        b1.set(1, true);
        b1.set(2, true);
        b1.set(3, true);
        
        b2.set(0, true);
        b2.set(1, true);
        b2.set(2, false);
        b2.set(3, true);

        System.out.println(b1);
        System.out.println(b2);
        
        b1.and(b2);
        System.out.println(b1);
        
        b1.xor(b2);
        System.out.println(b1);
        
        //PROPERTIES
        Properties p=new Properties();
        p.put("Tenerifeee","BORA BORA");
        p.put("Honolulu","RM.VALCEA");
        p.put("OBOR CITY","LOS ANGELES");
        
        System.out.println(p);
        System.out.println(p.get("Honolulu"));
        
        
        Iterator i=p.keySet().iterator();
        while(i.hasNext()) {
        	String key=(String)i.next();
        	System.out.println(key+": "+p.getProperty(key));
        }
        
        
        //HASHTABLE
        Hashtable h=new Hashtable();
        h.put("1", "eins");
        h.put("2", "zwei");
        h.put("3","drei");
        h.put("4","vier");
        System.out.println(h);
        
        Enumeration ee=h.keys();
    
        while(ee.hasMoreElements()) {
        	String key =(String)ee.nextElement();
        	System.out.println(key+":"+h.get(key));
        }
    }
    
}
