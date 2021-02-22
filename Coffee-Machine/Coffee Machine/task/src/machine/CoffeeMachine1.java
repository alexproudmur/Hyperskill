package machine;

import java.util.Scanner;

public class CoffeeMachine1 {
    int water = 400;
    int milk = 540;
    int beans = 120;
    int cups = 9;
    int money = 550;

    public static void main(String[] args) {
        CoffeeMachine1 coffeeMachine = new CoffeeMachine1();
        Scanner scanner = new Scanner(System.in);
        String a;

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            a = scanner.next();
            switch (a) {
                case "buy":
                    coffeeMachine.buyFunc(scanner);
                    break;
                case "take":
                    System.out.println("I gave you $" + coffeeMachine.money);
                    coffeeMachine.money = 0;
                    break;
                case "fill":
                    System.out.println("Write how many ml of water do you want to add:");
                    int w = scanner.nextInt();
                    coffeeMachine.water += w;

                    System.out.println("Write how many ml of milk do you want to add:");
                    int m = scanner.nextInt();
                    coffeeMachine.milk += m;

                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    int cb = scanner.nextInt();
                    coffeeMachine.beans += cb;

                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    int cups = scanner.nextInt();
                    coffeeMachine.cups += cups;
                    break;
                case "remaining":
                    coffeeMachine.printState();
                    break;
            }
        } while (!a.equals("exit")) ;
    }

    public void printState() {
        System.out.println("The coffee machine has:");
        System.out.println(this.water + " of water");
        System.out.println(this.milk + " of milk");
        System.out.println(this.beans + " of coffee beans");
        System.out.println(this.cups + " of disposable cups");
        System.out.println("$" + this.money + " of money");
        System.out.println();
    }

    public void buyFunc(Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String b = scanner.next();
        switch (b) {
            case "1":
                if (!checkEspresso()) {
                    buyEspresso();
                } else {
                    System.out.println(returnProblemEspresso());
                }
                break;
            case "2":
                if (!checkLatte()) {
                    buyLatte();
                } else {
                    System.out.println(returnProblemLatte());
                }
                break;
            case "3":
                if (!checkCappuccino()) {
                    buyCappuccino();
                } else {
                    System.out.println(returnProblemCappuccino());
                }
                break;
            case "back":
                break;
        }
    }

    public void buyEspresso() {
        System.out.println("I have enough resources, making you a coffee!\n");
        this.water -= 250;
        this.beans -= 16;
        this.money += 4;
        this.cups--;
    }

    public void buyLatte() {
        System.out.println("I have enough resources, making you a coffee!\n");
        this.water -= 350;
        this.milk -= 75;
        this.beans -= 20;
        this.money += 7;
        this.cups--;
    }

    public void buyCappuccino() {
        System.out.println("I have enough resources, making you a coffee!\n");
        this.water -= 200;
        this.milk -= 100;
        this.beans -= 12;
        this.money += 6;
        this.cups--;
    }

    public boolean checkEspresso() {
        return (this.water - 250) < 0 || (this.beans - 16) < 0 || (this.cups - 1) < 0;
    }

    public boolean checkLatte() {
        return (this.water - 350) < 0 || (this.beans - 20) < 0 || (this.cups - 1) < 0 || (this.milk - 75) < 0;
    }

    public boolean checkCappuccino() {
        return (this.water - 200) < 0 || (this.beans - 12) < 0 || (this.cups - 1) < 0 || (this.milk - 100) < 0;
    }

    public String returnProblemEspresso() {
        if (this.water - 250 < 0) {
            return "Sorry, not enough water!";
        } else if (this.beans - 16 < 0) {
            return "Sorry, not enough coffee beans!";
        } else if (this.cups - 1 < 0) {
            return "Sorry, not enough cups!";
        }
        return "";
    }

    public String returnProblemLatte() {
        if (this.water - 350 < 0) {
            return "Sorry, not enough water!";
        } else if (this.beans - 20 < 0) {
            return "Sorry, not enough coffee beans!";
        } else if (this.cups - 1 < 0) {
            return "Sorry, not enough cups!";
        } else if (this.milk - 75 < 0) {
            return "Sorry, not enough milk!";
        }
        return "";
    }

    public String returnProblemCappuccino() {
        if (this.water - 200 < 0) {
            return "Sorry, not enough water!";
        } else if (this.beans - 12 < 0) {
            return "Sorry, not enough coffee beans!";
        } else if (this.cups - 1 < 0) {
            return "Sorry, not enough cups!";
        } else if (this.milk - 100 < 0) {
            return "Sorry, not enough milk!";
        }
        return "";
    }
}