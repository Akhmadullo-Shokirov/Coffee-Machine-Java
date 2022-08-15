import java.util.Scanner;
public class CoffeeMachine {
    Scanner scanner = new Scanner(System.in);
    private int totalWater;
    private int totalMilk;
    private int totalCoffeeBeans;
    private int money;
    private int disposableCups;
    Espresso espresso = new Espresso();
    Latte latte = new Latte();
    Cappuccino cappuccino = new Cappuccino();

    public CoffeeMachine(int totalWater, int totalMilk, int totalCoffeeBeans, int money, int disposableCups) {
        this.totalWater = totalWater;
        this.totalMilk = totalMilk;
        this.totalCoffeeBeans = totalCoffeeBeans;
        this.money = money;
        this.disposableCups = disposableCups;
    }

    public void displayAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        switch (scanner.nextLine().toLowerCase()) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                buy(scanner.nextLine());
                break;
            case "fill":
                System.out.println("How many ml of water do you want to add: ");
                int inputWater = Integer.parseInt(scanner.nextLine());
                System.out.println("How many ml of milk do you want to add: ");
                int inputMilk = Integer.parseInt(scanner.nextLine());
                System.out.println("How many grams of coffee beans do you want to add: ");
                int inputCoffeeBeans = Integer.parseInt(scanner.nextLine());
                System.out.println("How many cups of coffee do you want to add: ");
                int inputCups = Integer.parseInt(scanner.nextLine());
                fill(inputWater, inputMilk, inputCups, inputCoffeeBeans);
                break;
            case "take":
                take();
                break;
            case "remaining":
                remaining();
                break;
            case "exit":
                exit();
                break;
            default:
                System.out.println("Please, enter a proper input value");
                displayAction();
        }
    }

    public void buy(String coffeeType) {
        switch (coffeeType.toLowerCase()) {
            case "1":
                if(this.totalWater >= espresso.getWater()) {
                    if(this.totalCoffeeBeans >= espresso.getCoffeeBeans()) {
                        if(this.disposableCups > 0) {
                            this.totalWater -= espresso.getWater();
                            this.totalCoffeeBeans -= espresso.getCoffeeBeans();
                            this.disposableCups -= 1;
                            this.money += espresso.getCost();
                            System.out.println("I have enough resources. Making you a coffee.");
                            displayAction();
                        } else {
                            System.out.println("Sorry, not enough cup.");
                            displayAction();
                        }
                    } else {
                        System.out.println("Sorry, not enough coffee beans.");
                        displayAction();
                    }
                } else {
                    System.out.println("Sorry, not enough water.");
                    displayAction();
                }
                break;
            case "2":
                if(this.totalWater >= latte.getWater()) {
                    if(this.totalMilk >= latte.getMilk()) {
                        if(this.totalCoffeeBeans >= latte.getCoffeeBeans()) {
                            if(this.disposableCups > 0) {
                                this.totalWater -= latte.getWater();
                                this.totalMilk -= latte.getMilk();
                                this.totalCoffeeBeans -= latte.getCoffeeBeans();
                                this.disposableCups -= 1;
                                this.money += latte.getCost();
                                System.out.println("I have enough resources. Making you a coffee.");
                                displayAction();
                            } else {
                                System.out.println("Sorry, not enough cup.");
                                displayAction();
                            }
                        } else {
                            System.out.println("Sorry, not enough coffee beans.");
                            displayAction();
                        }
                    } else {
                        System.out.println("Sorry, not enough milk.");
                        displayAction();
                    }
                } else {
                    System.out.println("Sorry, not enough water.");
                    displayAction();
                }
                break;
            case "3":
                if(this.totalWater >= cappuccino.getWater()) {
                    if(this.totalMilk >= cappuccino.getMilk()) {
                        if(this.totalCoffeeBeans >= cappuccino.getCoffeeBeans()) {
                            if(this.disposableCups > 0) {
                                System.out.println("I have enough resources. Making you a coffee.");
                                this.totalWater -= cappuccino.getWater();
                                this.totalMilk -= cappuccino.getMilk();
                                this.totalCoffeeBeans -= cappuccino.getCoffeeBeans();
                                this.disposableCups -= 1;
                                this.money += cappuccino.getCost();
                                displayAction();
                            } else {
                                System.out.println("Sorry, not enough cup.");
                                displayAction();
                            }
                        } else {
                            System.out.println("Sorry, not enough coffee beans.");
                            displayAction();
                        }
                    } else {
                        System.out.println("Sorry, not enough milk.");
                        displayAction();
                    }
                } else {
                    System.out.println("Sorry, not enough water.");
                    displayAction();
                }
                break;
            case "back":
                displayAction();
                break;
            default:
                System.out.println("Please enter a valid coffee type.");
                displayAction();
        }

    }

    public void fill(int water, int milk, int cups, int coffeeBeans) {

        this.totalWater += water;
        this.totalMilk += milk;
        this.totalCoffeeBeans += coffeeBeans;
        this.disposableCups += cups;

        System.out.println("The coffee machine is filled with " + water + " ml of water, " + milk + " ml of milk, " +
                            coffeeBeans + "g of coffee beans and " + cups + " disposable cups.");
        displayAction();
    }

    public void take() {
        System.out.println("I gave you " + this.money + "$ money.");
        this.money = 0;
        displayAction();
    }

    public void remaining() {
        System.out.println("The coffee machine has: " + this.totalWater + " ml of water, " + this.totalMilk + " ml of milk, " +
                            + this.disposableCups + " cups, " + this.totalCoffeeBeans + " gram coffee beans and " + this.money + "$ money.");
        displayAction();
    }

    public void exit() {
        scanner.close();
    }


}
