package classjournal.entity;

public class Address {
    private String street;
    private String building;
    private String room;

    public Address(String street, String building, String room) {
        this.street = street;
        this.building = building;
        this.room = room;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (!street.equals(address.street)) return false;
        if (!building.equals(address.building)) return false;
        return room.equals(address.room);
    }

    @Override
    public int hashCode() {
        int result = street.hashCode();
        result = 31 * result + building.hashCode();
        result = 31 * result + room.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return street + " street, building " + building + ", room " + room;
    }
}
