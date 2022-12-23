package task8;

import java.sql.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {


        try {
            String userName = "admin";
            String pass = "admin";
            String connectionURL = "jdbc:mysql://localhost:3306/test";
            connect(userName, pass, connectionURL);
        } catch (SQLException ignored) {

        }

    }

    private static void connect(String userName, String pass, String connectionURL) throws SQLException {
        HashMap<String, Integer> products = new HashMap();
        try (Connection connection = DriverManager.getConnection(connectionURL, userName, pass);
                Statement statement = connection.createStatement())
        {



            //statement.executeUpdate("CREATE schema MyTables");
            //statement.executeUpdate("drop table ProductsCategory;");

            /*String createTable = "CREATE TABLE ProductsCategory\n" +
                    "(\n"+
                    "id          int            AUTO_INCREMENT,\n" +
                    "ProductId          CHAR(30)      default ''      NOT NULL,\n";

            createTable += "PRIMARY KEY (id)\n" + ");";
            System.out.println(createTable);
            statement.executeUpdate(createTable);*/

//            statement.execute("insert into product_category (id_category, name_category) values (1, 'Cars')");
//            statement.execute("insert into product_category (id_category, name_category) values (2, 'Mobile_Phones')");
//            statement.execute("insert into product_category (id_category, name_category) values (3, 'Movies')");
//            statement.execute("insert into product_category (id_category, name_category) values (4, 'TV_shows')");

//            statement.executeUpdate("INSERT INTO products (name_product, id_category, price) values ('BMW1', 1, 1000)");
//            statement.executeUpdate("INSERT INTO products (name_product, id_category, price) values ('BMW2', 1, 1001)");
//            statement.executeUpdate("INSERT INTO products (name_product, id_category, price) values ('BMW3', 1, 1002)");
//            statement.executeUpdate("INSERT INTO products (name_product, id_category, price) values ('BMW4', 1, 1003)");

//            String s = "select * from products";
//            ResultSet res = statement.executeQuery(s);
//            while (res.next()) {
//                products.put(res.getString("name_product"),res.getInt("id_category"));
//                System.out.println(res.getString("name_product") + " " + res.getInt("id_category"));
//            }
//            System.out.println("Выводим все " + products.toString());

//            products.put("dog", 2);
            //statement.execute("insert into products (id_category, name_product) values (5, 'dog')");
//            System.out.println("Выводим после добавления " + products);
//
//            products.remove("dog");
//            statement.execute("delete from products where name_product='dog'");
//            System.out.println("Выводим после удаления " + products);
//

//            ResultSet res = statement.executeQuery(
//                    "select name_product, name_category from products p, product_category c " +
//                    "where p.id_category = c.id_category");
//            while (res.next()) {
//                System.out.println(res.getString("name_product") + " " + res.getString("name_category"));
//            }


            //statement.execute("update products set name_product = 'MECCEDES' where name_product = 'AUDI'");
//            products.remove("dog");
//            products.put("cat", 0);
//            System.out.println("Выводим после update " + products.toString());
//

            /*ResultSet res2 = statement.executeQuery("select * from products order by price DESC");
            while (res2.next()) {
                System.out.println(res2.getString("name_product") + " " + res2.getInt("price"));

            }*/
            //statement.execute("delete from products where name_product = 'BMW4'");
//            statement.executeUpdate("INSERT INTO products (name_product, id_category, price) values ('LG1', 4, 1)");
//            statement.executeUpdate("INSERT INTO products (name_product, id_category, price) values ('LG2', 4, 2)");
//            statement.executeUpdate("INSERT INTO products (name_product, id_category, price) values ('LG3', 4, 3)");
//            statement.executeUpdate("INSERT INTO products (name_product, id_category, price) values ('IPHONE1', 2, 4)");
//            statement.executeUpdate("INSERT INTO products (name_product, id_category, price) values ('IPHONE2', 2, 5)");
            ResultSet resultSet =
            statement.executeQuery("select name_category, count(name_product) as count_pr from products p, product_category c\n" +
                    "            where p.id_category = c.id_category\n" +
                    "            group by name_category");
            while (resultSet.next())
                System.out.println(
                        resultSet.getString("name_category") + " " +
                                resultSet.getInt("count_pr"));
        }
    }
}
