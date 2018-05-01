package dao;

public enum DB {
    MYSQL("mysqldb"),
    PSQL("postgresqldb");

    private String name;

    DB(String dbName) {
        name = dbName;
    }

    public String getName() {
        return name;
    }
}
