package Exam2;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class ReturnByCountryID {

    //读取属性文件流的方法
    public void load(InputStream inStream) throws IOException {}

    public  void ReturnCityId() throws Exception {
        CityEntity cityEntity = new CityEntity();
        Connection connection = JDBCTools.getConnection();
        String sql = "select distinct country ,city,city_id  from city ,country where city.country_id = country.country_id and country.country_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Properties pro = new Properties();
        FileInputStream fis = new FileInputStream("D:\\Coding\\JavaTest1\\src\\main\\resources/CityId.properties");//属性文件流
        pro.load(fis);//将属性文件流装载到Properties对象中
        int value = Integer.parseInt(pro.getProperty("cityid"));
        System.out.println(value);
        preparedStatement.setInt(1,value);

        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.print("Country(国家）"+"------");
        System.out.print("City（城市）"+"------");
        System.out.println("CityID");
        while(resultSet.next()){
            /*cityEntity.setCountry(resultSet.getString("country"));
            cityEntity.setCity(resultSet.getString("city"));*/
            //输出城市信息
            System.out.print(resultSet.getString("country")+"------");
            System.out.print(resultSet.getString("city")+"------");
            System.out.println(resultSet.getString("city_id"));
        }
    }
}
