package com.company;

public class Main {

    public static void main(String[] args) {
	Person[] p ={new Person("Alireza","Rayani"),new Person("Zahra","Mozafari")};

        for (Person person : p) {

            System.out.println(person.FirstName);
        }

    }
}
