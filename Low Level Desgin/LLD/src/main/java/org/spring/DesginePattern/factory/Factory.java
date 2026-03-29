package org.spring.DesginePattern.factory;

/*

interface Burger{

    public void prepare();
}


class BasicBurger implements Burger{

    @Override
    public void prepare() {
        System.out.println("Basic Burger Prepare");
    }
}

class StandardBurger implements Burger{

    @Override
    public void prepare() {
        System.out.println("Satandard Burger Prepare");
    }
}

class PrimiumBurger implements Burger{

    @Override
    public void prepare() {
        System.out.println("Premium Burger");
    }
}

class BasicWheat implements Burger{
    @Override
    public void prepare() {
        System.out.println("Basic Wheat");
    }
}

class StandardWheat implements Burger{

    @Override
    public void prepare() {
        System.out.println("Standard Wheat");
    }
}

class PremiumWheat implements Burger{

    @Override
    public void prepare() {
        System.out.println("Premium Wheat");
    }
}


interface BurgerFactory{

    public Burger createBurger(String type);
}

class SinghBurger implements BurgerFactory{

    public Burger createBurger(String type){
        if(type == "basic"){
            return new BasicBurger();
        }
        else  if(type == "standard"){
            return new StandardBurger();
        } else if (type == "premium") {

            return new PrimiumBurger();

        }
        else{
            System.out.println("Invalid reuqest");
        }

        return null;
    }
}

class KingBurger implements BurgerFactory{

    public Burger createBurger(String type){
        if(type == "basic"){
            return new BasicWheat();
        }
        else  if(type == "standard"){
            return new StandardWheat();
        } else if (type == "premium") {

            return new PremiumWheat();

        }
        else{
            System.out.println("Invalid reuqest");
        }

        return null;
    }
}


public class Factory {


    public static void main(String[] args) {

        BurgerFactory burgerFactory = new KingBurger();
        Burger burger = burgerFactory.createBurger("standard");

        burger.prepare();
    }
}


 */