package com.dao;

import com.config.ConnectionConfiguration;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDao implements InterfaceDao{
    public int save(Object o) {
        return 0;
    }

    public Object getByPrimaryId(Object id) {
        return null;
    }

    public boolean remove(Object id) {
        return false;
    }

    public boolean update(Object o) {
        return false;
    }

    public int lotCount(){
        try{
            String sql = "select count(*) from car_dealership.car where car_dealership.car.car_type = 0";
            PreparedStatement preparedStatement = ConnectionConfiguration.getInstance().getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    public void showLot(int offset){
        try{
            String sql = "select * from car_dealership.car where car_dealership.car.car_type = 0 offset ? limit 5";
            PreparedStatement preparedStatement = ConnectionConfiguration.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, offset);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t\t" +
                                        resultSet.getString(3) + "\t" + resultSet.getInt(4) + "\t" +
                                        resultSet.getFloat(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
