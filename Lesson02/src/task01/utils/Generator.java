package task01.utils;

class Generator {

    private static String[] firstNames = {"Jane", "Joe", "Peter", "Garry", "Julia", "Samantha", "Elizabeth", "Tom", "Richard"};
    private static String[] lastNames = {"Smith", "Peterson", "Watson", "MacLachlan", "Fox", "Anderson", "Green", "Newman"};
    private static String[] middleNames = {"P", "F", "D", "J", "S", "R", "T", "C"};
    private static String[] streets = {"1st avenue", "85th N street", "Backer street", "Main street", "Harbour Pointe blvd", "196th St SW", "Railroad Ave", "Westminster rd"};
    private static String[] cities = {"Everett", "Los Angeles", "San Francisco", "New York", "Seattle", "Lynnwood", "Las Vegas", "Olympia"};
    private static String[] states = {"WA", "CA", "NY", "TX", "UT", "OR", "IL", "IA"};
    private static String[] diseases = {"Flu", "Lupus", "Pneumonia", "Sarcoidosis", "Vasculitis", "Adenoma", "Epilepsy", "Chickenpox"};


    static String getFirstName() {
        return firstNames[(int)(Math.random()*firstNames.length)];
    }

    static String getLastName() {
        return lastNames[(int)(Math.random()*lastNames.length)];
    }

    static String getMiddleName() {
        return middleNames[(int)(Math.random()*middleNames.length)];
    }

    static String getAddress() {
        return "" + (int)(Math.random()*200) + " " + streets[(int)(Math.random()*streets.length)] +
                ", " + states[(int)(Math.random()*states.length)] + ", " + cities[(int)(Math.random()*cities.length)];
    }

    static String getPhone() {

        String result = "";
        for(int i = 0; i < 7; i++) {

            if (i == 3) {
                result = result + "-";
            }
            result = result + (int)(Math.random()*10);
        }
        return result;
    }

    static String getDisease() {
        return diseases[(int)(Math.random()*diseases.length)];
    }
}
