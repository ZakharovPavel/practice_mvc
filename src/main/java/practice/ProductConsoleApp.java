package practice;

import java.sql.*;

public class ProductConsoleApp {

    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String password = "pass";

    private static Connection connection;

    public static void connect() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connected to the PostgreSQL server succesfully");
    }

    public static void disconnect() throws SQLException {
        connection.close();
    }

    public static void getProductsByCustomer(String name) throws SQLException {
        PreparedStatement pst = connection.prepareStatement(
                "SELECT name FROM spring1.purchases \n " +
                        "RIGHT JOIN spring1.products p on purchases.product = p.id \n" +
                        "WHERE customer = (SELECT id FROM spring1.customers WHERE name = ?) \n" +
                        "GROUP BY p.name;");
        pst.setString(1, name);
        ResultSet rs = pst.executeQuery();
        if (rs.isBeforeFirst()) {
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } else {
            throw new SQLException("Wrong name");
        }
    }

    public static void getCustomersByProduct(String name) throws SQLException {
        PreparedStatement pst = connection.prepareStatement(
                "SELECT name FROM spring1.purchases \n " +
                        "RIGHT JOIN spring1.customers c on purchases.customer = c.id \n" +
                        "WHERE product = (SELECT id FROM spring1.products WHERE name = ?) \n" +
                        "GROUP BY c.name;");
        pst.setString(1, name);
        ResultSet rs = pst.executeQuery();
        if (rs.isBeforeFirst()) {
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } else {
            throw new SQLException("Wrong product");
        }
    }

    public static void deleteCustomer(String name) {
        PreparedStatement pst;
        try {
            pst = connection.prepareStatement(
                    "DELETE FROM spring1.customers WHERE name = ?");
            pst.setString(1, name);
            if (pst.executeUpdate() != 0) {
                System.out.println("Deletion successful");
            } else {
                throw new SQLException("Deletion failed");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void deleteProduct(String name) {
        PreparedStatement pst;
        try {
            pst = connection.prepareStatement(
                    "DELETE FROM spring1.products WHERE name = ?");
            pst.setString(1, name);
            if (pst.executeUpdate() != 0) {
                System.out.println("Deletion successful");
            } else {
                throw new SQLException("Deletion failed");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void main(String[] args) {

        try {
            connect();

            getCustomersByProduct("bread");
//            getProductsByCustomer("Bob");
//            deleteCustomer("Kevin");

            disconnect();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
