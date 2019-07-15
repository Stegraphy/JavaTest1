package Exam2;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReturnByCountryID {

    public  void ReturnCityId() throws Exception {
        CityEntity cityEntity = new CityEntity();
        Connection connection = JDBCTools.getConnection();
        String sql = "select distinct country ,city,city_id  from city ,country where city.country_id = country.country_id";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
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
