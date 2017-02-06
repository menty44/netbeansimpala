/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fred.dao;

/**
 *
 * @author fred
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.fred.utility.DBUtility;
import com.fred.model.Rates;

public class SiddhuCrudDao {

    private Connection connection;

    public SiddhuCrudDao() {
        connection = DBUtility.getConnection();
    }

    public void addRate(Rates rates) {
        try {

            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into rates(id,ratename,ratevalue) values (?,?,?)");
            preparedStatement.setInt(1, rates.getId());
            preparedStatement.setString(2, rates.getRatename());
            preparedStatement.setString(3, rates.getRatevalue());
            //preparedStatement.setString(4, user.getEmail());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRate(int id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from rates where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRate(Rates rates) throws ParseException {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update rates set ratename =  ?, ratevalue =  ?" + "where id =  ?");
            preparedStatement.setString(1, rates.getRatename());
            preparedStatement.setString(2, rates.getRatevalue());
            preparedStatement.setInt(3, rates.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Rates> getAllRates() {
        List<Rates> rates = new ArrayList<Rates>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from rates");
            
            while (rs.next()) {
                Rates rate = new Rates();
                //rates.setId(rs.getString("id"));
                rate.setId(rs.getInt("id"));
                rate.setRatename(rs.getString("rateName"));
                rate.setRatevalue(rs.getString("rateValue"));

                rates.add(rate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rates;
    }

    public Rates getRateById(int id) {
        Rates rate = new Rates();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from rates where id =  ?");
                    preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                rate.setId(rs.getInt("id"));
                rate.setRatename(rs.getString("rateName"));
                rate.setRatevalue(rs.getString("rateValue"));


}
} catch (SQLException e) {
            e.printStackTrace();
        }
        return rate;
    }

}
