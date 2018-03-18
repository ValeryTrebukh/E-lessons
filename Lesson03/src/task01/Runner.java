package task01;

public class Runner {


    public void run() {

        Store citadel = new Store("Citadel", 10);
        citadel.setDescription("citadeloutlets.com");

        citadel.createDept("Michael Kors", "accessories", "616");
        citadel.createDept("Adidas", "footwear", "583");
        citadel.createDept("Puma", "footwear", "662");
        citadel.createDept("Reebok", "footwear", "721");
        citadel.createDept("Starbucks", "food", "200");

        citadel.showDepartments();

        citadel.closeDept("Adidas");
        citadel.closeDept("Nike");

        citadel.relocateDept("Puma", "666");

        citadel.showDepartments();
    }
}
