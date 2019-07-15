package Exam2;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReturnByCountryID {

    public  void ReturnCityId() throws Exception {
        CityEntity cityEntity = new CityEntity();
        Connection connection = JDBCTools.getConnection();
        String sql = "select distinct country ,city  from city ,country where city.country_id = country.country_id";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.print("Country(国家）"+"------");
        System.out.println("City（城市）");
        while(resultSet.next()){
            /*cityEntity.setCountry(resultSet.getString("country"));
            cityEntity.setCity(resultSet.getString("city"));*/
            System.out.print(resultSet.getString("country")+"------");
            System.out.println(resultSet.getString("city"));
        }
    }
}
