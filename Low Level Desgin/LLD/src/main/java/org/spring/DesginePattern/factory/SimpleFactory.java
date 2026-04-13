package org.spring.DesginePattern.factory;

/*
interface Burger{
    public void prepare();
}

class BasicBurger implements Burger{

    public void prepare(){
        System.out.println("Basic Burger Prepare");
    }
}

class StandardBurger implements Burger{

    @Override
    public void prepare() {
        System.out.println("Standard Burger Prepare");
    }
}

class PremiumBurger implements Burger{

    @Override
    public void prepare(){
        System.out.println("Primium Burger");
    }
}

//Factory who create Burger
class BurgerFactory{
    public Burger createBurger(String type){

        if(type == "basic"){
            System.out.println("11");
            return new BasicBurger();
        }
        else if(type == "standard"){
            return new StandardBurger();
        }
        else if(type == "premium"){
            return new PremiumBurger();
        }
        else{
            System.out.println("Ivalid request");

        }

        return null;
    }
}

public class SimpleFactory {

    public static void main(String[] args) {

        //create object type burger factory
        BurgerFactory burgerFactory = new BurgerFactory();
        Burger burger = burgerFactory.createBurger("basic");

        if (burger != null) {
            burger.prepare();
        }
    }
}

 */
