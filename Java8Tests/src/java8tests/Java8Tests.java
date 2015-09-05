/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package java8tests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;

/**
 *
 * @author ja
 */
public class Java8Tests {

    
    Runnable r1 = () -> System.out.println(this);

    public String toString() { return "sdfj kjsdf!"; }
    
    public static void main(String[] args) throws IOException {
        //new Java8Tests().r1.run();
        
        /*Files.lines(Paths.get("Nio.java"))
                .map(String::trim)
                .forEach(System.out::println);*/
        Function<String, String> atr = (n) -> {return "@" + n;};
        ForkJoinPool pool = new ForkJoinPool();
       // ParallelArray<Object> xs;
    }
    
}
