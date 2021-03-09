package com.dao;

import com.config.ConnectionConfiguration;
import com.model.Car;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDao implements InterfaceDao{
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

    public boolean carExists(String vinNumber){
        try{
            String sql = "select count(*) from car_dealership.car where car_dealership.car.vin_number = ?";
            PreparedStatement preparedStatement = ConnectionConfiguration.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, vinNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public int addCarToLot(Car car){
        try{
            String sql = "insert into car_dealership.car values (?, ?, ?, ?, ?, 0, 'Lot')";
            PreparedStatement preparedStatement = ConnectionConfiguration.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, car.getVinNumber());
            preparedStatement.setString(2, car.getMake());
            preparedStatement.setString(3, car.getModel());
            preparedStatement.setInt(4, car.getYear());
            preparedStatement.setFloat(5, car.getValue());
            int i = preparedStatement.executeUpdate();
            return i;
        } catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

    public boolean offerExists(String offerId){
        try{
            String sql = "select count(*) from car_dealership.offer o where o.offer_id = ?";
            PreparedStatement preparedStatement = ConnectionConfiguration.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, offerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
