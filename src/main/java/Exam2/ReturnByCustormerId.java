package Exam2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class ReturnByCustormerId {
    //读取属性文件流的方法
    public void load(InputStream inStream) throws IOException {}

    public  void ReturnFilmAll() throws Exception {
        FilmEntity filmEntity = new FilmEntity();
        Connection connection = JDBCTools.getConnection();
        String sql = "select * from film \n" +
                "where film_id = \n" +
                "any(select film_id \n" +
                "from customer,store,inventory\n" +
                "where customer.store_id = store.store_id and store.store_id = inventory.store_id\n" +
                "and customer.customer_id = ?)\n" +
                "ORDER BY last_update DESC;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Properties pro = new Properties();
        FileInputStream fis = new FileInputStream("D:\\Coding\\JavaTest1\\src\\main\\resources/customerid.properties");//属性文件流
        pro.load(fis);//将属性文件流装载到Properties对象中
        int value = Integer.parseInt(pro.getProperty("customer_id"));
        System.out.println(value);
        preparedStatement.setInt(1,value);

        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.print("File_id"+"------");
        System.out.print("title"+"------");
        System.out.print("description"+"-------");
        System.out.println("last_update"+"-------");
        while(resultSet.next()){
            /*cityEntity.setCountry(resultSet.getString("country"));
            cityEntity.setCity(resultSet.getString("city"));*/
            //输出城市信息
            System.out.print(resultSet.getString("film_id")+"------");
            System.out.print(resultSet.getString("title")+"------");
            System.out.print(resultSet.getString("description")+"--------");
            System.out.println(resultSet.getString("last_update")+"--------");
        }
    }
}
