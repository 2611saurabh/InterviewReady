package org.spring.Practice.demo1;



//here we making strategy Design Pattern

interface IStrategy{
    void payment(double amount);
}

class UpiPayment implements IStrategy{

    public void payment(double amount){
        System.out.println("Payment done by Upi of->>"+amount);
    }
}

class CardPayment implements IStrategy{

    @Override
    public void payment(double amount) {
        System.out.println("Payment done by CardPayment of->>"+ amount);
    }
}

class  DebitCardPayment implements IStrategy{

    @Override
    public void payment(double amount) {
        System.out.println("Payment done by Debit Card->>"+amount);
    }
}


//contet which have object of strategy class

class PaymentProcessing{

    public IStrategy strategy;

    public void setStrategy(IStrategy strategy){
        this.strategy = strategy;
    }

    public void payAmount(double amount){

        if(strategy == null){
            System.out.println("Select Payment Option");
            return;
        }

        strategy.payment(amount);
    }
}


public class LearningStrategy {

    public static void main(String[] args) {

        PaymentProcessing context = new PaymentProcessing();

        context.setStrategy(new DebitCardPayment());
        context.payAmount(200.23000);
    }
}
