// Assignment 5 - Electricity Billing System (Method Overriding & Runtime Polymorphism)

class ElectricityConnection {
    int units;

    ElectricityConnection(int units) {
        this.units = units;
    }

    // Method to be overridden in child classes
    double calculateBill() {
        System.out.println("Calculating generic electricity bill...");
        return 0;
    }
}

class DomesticConnection extends ElectricityConnection {

    DomesticConnection() {
        super(150); // units defined directly (no user input)
    }

    @Override
    double calculateBill() {
        double bill;
        if (units <= 125) {
            bill = units * 10;
        } else {
            bill = units * 15;
        }
        return bill;
    }
}

class CommercialConnection extends ElectricityConnection {

    CommercialConnection() {
        super(80); // units defined directly (no user input)
    }

    @Override
    double calculateBill() {
        double bill;
        if (units <= 100) {
            bill = units * 20;
        } else {
            bill = units * 25;
        }
        return bill;
    }
}

public class ElectricityBilling {
    public static void main(String[] args) {
        // Parent-class references referring to child-class objects
        ElectricityConnection domestic = new DomesticConnection();
        ElectricityConnection commercial = new CommercialConnection();

        // Runtime polymorphism: overridden calculateBill() is called
        System.out.println("----- Electricity Bill Details -----");
        System.out.println("Domestic Connection");
        System.out.println("Units Consumed : " + domestic.units);
        System.out.println("Bill Amount    : Rs." + domestic.calculateBill());

        System.out.println("------------------------------------");

        System.out.println("Commercial Connection");
        System.out.println("Units Consumed : " + commercial.units);
        System.out.println("Bill Amount    : Rs." + commercial.calculateBill());
        System.out.println("------------------------------------");
    }
}
