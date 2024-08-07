import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int UserId, password,quantity = 0,price = 0,change;
        double vat = 0.13;
        float discount,amount = 0,payamount;
        String item,temp,userInput;

        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.print("Enter User ID: ");
            userInput = input.next();
            if (userInput.equalsIgnoreCase("quit")) {
                System.out.println("Program terminated.");
                break;
            }
            UserId = Integer.parseInt(userInput);

            System.out.print("Enter Password: ");
            userInput = input.next();
            if (userInput.equalsIgnoreCase("quit")) {
                System.out.println("Program terminated.");
                break;
            }
            password = Integer.parseInt(userInput);

            if (password == 12345) {
                System.out.println("You have successfully logged in!");

                ArrayList<String> items = new ArrayList<>();
                ArrayList<Integer> quantities = new ArrayList<>();
                ArrayList<Integer> prices = new ArrayList<>();

                
                while (true) {
                    System.out.print("Enter the name of the item or type done: ");
                    item = input.next();
                    if (item.equalsIgnoreCase("quit")) {
                        System.out.println("Program terminated.");
                        return;
                    }
                    if (item.equalsIgnoreCase("done")) {
                        break;
                    }
                    items.add(item);

                    System.out.print("Enter the quantity of item " + item+": ");
                    userInput = input.next();
                    if (userInput.equalsIgnoreCase("quit")) {
                        System.out.println("Program terminated.");
                        return;
                    }
                    quantity = Integer.parseInt(userInput);
                    quantities.add(quantity);

                    System.out.print("Enter the price of item " + item+": ");
                    userInput = input.next();
                    if (userInput.equalsIgnoreCase("quit")) {
                        System.out.println("Program terminated.");
                        return;
                    }
                    price = Integer.parseInt(userInput);
                    prices.add(price);

                }

                for (int i = 0; i < items.size(); i++) {
                    amount += quantities.get(i) * prices.get(i);
                }

                System.out.println("Should vat be included(yes/no): ");
                temp = input.next();
                if (temp.equalsIgnoreCase("quit")) {
                    System.out.println("Program terminated.");
                    break;
                }
                if (temp.equals("yes")) {
                    amount = (int) (amount + amount * vat);
                }

                System.out.println("enter discount amount in percentage: ");
                userInput = input.next();
                if (userInput.equalsIgnoreCase("quit")) {
                    System.out.println("Program terminated.");
                    break;
                }
                discount = Float.parseFloat(userInput);

                if (discount < 100 || discount > 0) {
                    amount = amount - amount * (discount / 100);
                } else {
                    System.out.println("invalid discount amount e");
                }

                System.out.println("item:         quantity:         price:");

                for (int i = 0; i < items.size(); i++) {
                    System.out.println(items.get(i) + "            "+quantities.get(i) +"              "+ prices.get(i));
                }
                    System.out.printf("Rs." + amount + " is the total amount");

                System.out.println("Enter the payment amount: ");
                userInput = input.next();
                if (userInput.equalsIgnoreCase("quit")) {
                    System.out.println("Program terminated.");
                    break;
                }
                payamount = Float.parseFloat(userInput);


                change = (int) (payamount - amount);

                System.out.println("return amount = ");
                if (change >= 1000) {
                    System.out.println("1000-" + (change / 1000));
                    change = change % 1000;
                }
                if (change >= 500) {
                    System.out.println("500-" + (change / 500));
                    change = change % 500;
                }
                if (change >= 100) {
                    System.out.println("100-" + (change / 100));
                    change = change % 100;
                }
                if (change >= 50) {
                    System.out.println("50-" + (change / 50));
                    change = change % 50;
                }
                if (change >= 20) {
                    System.out.println("20-" + (change / 20));
                    change = change % 20;
                }
                if (change >= 10) {
                    System.out.println("10-" + (change / 10));
                    change = change % 10;
                }
                if (change >= 5) {
                    System.out.println("5-" + (change / 5));
                    change = change % 5;
                }
                if (change >= 1) {
                    System.out.println("1-" + (change));
                }
            }
            else {
                System.out.println("wrong password!");
            }
            break;
        }
    }
}
















