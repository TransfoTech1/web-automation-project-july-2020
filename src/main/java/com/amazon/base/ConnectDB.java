package com.amazon.base;

import java.sql.*;

public class ConnectDB {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String username = "root";
        String password = "root1234";
        String databaseName = "students";
        String query = "select * from student_table;";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        ResultSet table = statement.executeQuery(query);

        System.out.println("id " + "name");

        while (table.next()) {
            int id = table.getInt("id");
            String name = table.getString("name");
            System.out.println(id + "  " + name);
        }

        // how to add these id and name in 2 lists -- home work

        statement.close();
        connection.close();
    }


}
