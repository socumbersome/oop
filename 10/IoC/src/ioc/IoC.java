/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ioc;

/**
 *
 * @author ja
 */
public class IoC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        SimpleContainer c = new SimpleContainer();
        
        c.RegisterType(Dummy.class, true);
        
        Dummy d1 = c.Resolve(Dummy.class);
        Dummy d2 = c.Resolve(Dummy.class);
        if(d1 == d2)
            System.out.println("gites");
        System.out.println(d1.count);
        System.out.println(d2.count);
        
        //Pair<Integer, String> p1 = new Pair<>(1, "jeden");
        c.RegisterType(Pair.class, false);
        Pair<String, Integer> p1 = c.Resolve(Pair.class);
        p1.a = "asdf";
        p1.b = 5;
        System.out.println(p1.a + " | " + p1.b);
    }
    
}
