package com.examplejava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//import static jdk.internal.org.jline.utils.Colors.s;

public class StreamExample {

    public static void main(String[] args) {


        List<String> listString= new ArrayList<>();

        listString.add("Welcome");
        listString.add("Happy");
        listString.add("Learning");
        listString.add("stream practice");

        List<Integer> listInteger=new ArrayList<>();

        for(int i=1;i<=5;i++)
            listInteger.add(i);



        //Predicate to return only if the string lenght is even

        Predicate<String> lenPredicate= i -> i.length()%2==0;

        //Predicate to return only odd elements

        Predicate<Integer> oddPredicate= i-> i%2!=0;

         genericFilter(listString,lenPredicate).stream().forEach(s-> System.out.print(s+" "));
         System.out.println();
         genericFilter(listInteger,oddPredicate).stream().forEach(s-> System.out.print(s+" "));

        listString.stream().sorted().forEach(s-> System.out.print(s+" "));
        listInteger.stream().sorted().forEach(s-> System.out.print(s+" "));

        //Compartor for employee object
        Comparator<Employee> e=Comparator.comparing(Employee::getName);




    }

    static <T> List<T> genericFilter(List<T> list, Predicate<T> predicate)
    {
           return   list.stream().filter(predicate::test).collect(Collectors.toList());
    }

    static <T> List<T> genericCompartor(List<T> list, Comparator<T> comparator)
    {
        return  list.stream().sorted(comparator::compare).collect(Collectors.toList());
    }

}
