package task01;


public class Store {

    private String storeName;

    private String description;

    private Department[] departments;


    public Store(String storeName, int capacity) {
        this.storeName = storeName;
        description = "not available";
        departments = new Department[capacity];
    }

    public void showDepartments() {
        System.out.println();
        System.out.println("Store name: " + storeName);
        for(Department d : departments) {
            if(d!=null)
                System.out.println(d.toString());
        }
        System.out.println();
    }


    public void createDept(String name, String goods, String location) {

        for (int i = 0; i < departments.length; i++) {
            if(departments[i] == null) {
                departments[i] = new Department(name, goods, location);
                System.out.print("INFO: New department created.");
                System.out.println(departments[i].toString());
                return;
            }
        }
        System.out.println("INFO: Not enough capacity!");
    }


    public void closeDept(String departmentName) {

        for(int i = 0; i < departments.length; i++) {
            if(departments[i] != null && departments[i].getName().equals(departmentName)) {
                departments[i] = null;
                System.out.println("INFO: Department \'" + departmentName +  "\' closed");
                return;
            }
        }
        System.out.println("INFO: No such department in this store.");
    }


    public void relocateDept(String departmentName, String location) {

        for(int i = 0; i < departments.length; i++) {
            if(departments[i] != null && departments[i].getName().equals(departmentName)) {
                departments[i].setLocation(location);
                System.out.println("INFO: Department \'" + departmentName +  "\' relocated to " + location);
                return;
            }
        }
        System.out.println("INFO: No such department in this store.");
    }


    public void setDescription(String description) {
        this.description = description;
    }


    private class Department {

        private String name;

        private String goods;

        private String location;

        Department(String name, String goods, String location) {
            this.name = name;
            this.goods = goods;
            this.location = location;
        }

        @Override
        public String toString() {
            return "Department name: " + name + ", Department type: " + goods + ", Location: " + location;
        }

        String getName() {
            return name;
        }

        void setLocation(String location) {
            this.location = location;
        }
    }
}
