package com.dao;

import com.config.ConnectionConfiguration;
import com.model.Car;
import com.model.Offer;
import com.model.Payment;

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

    public void getOfferDetails(Offer offer, String offerId){
        try{
            String sql = "select * from car_dealership.offer o where o.offer_id = ?";
            PreparedStatement preparedStatement = ConnectionConfiguration.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, offerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            offer.setVinNumber(resultSet.getString(2));
            offer.setUsername(resultSet.getString(3));
            offer.setOfferPrice(resultSet.getFloat(4));
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public int deleteOffersOnCar(String vinNumber){
        try{
            String sql = "delete from car_dealership.offer where vin_number = ?";
            PreparedStatement preparedStatement = ConnectionConfiguration.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, vinNumber);
            return preparedStatement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

    public int createPayments(String paymentId, String username, String vinNumber, float paymentAmount){
        try{
            String sql = "insert into car_dealership.payment values (?,?,?,0,?)";
            PreparedStatement preparedStatement = ConnectionConfiguration.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, paymentId);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, vinNumber);
            preparedStatement.setFloat(4, paymentAmount);
            return preparedStatement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

    public void changeCarOwnership(String username, String vinNumber, float offerPrice){
        try{
            String sql = "update car_dealership.car set car_type = 1, username = ?, value = ? where car_dealership.car.vin_number = ?";
            PreparedStatement preparedStatement = ConnectionConfiguration.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setFloat(2, offerPrice);
            preparedStatement.setString(3, vinNumber);
            preparedStatement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public int deleteRejectedOffer(String offerId){
        try{
            String sql = "delete from car_dealership.offer where offer_id = ?";
            PreparedStatement preparedStatement = ConnectionConfiguration.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, offerId);
            return preparedStatement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

    public boolean carExistsOnLot(String vinNumber){
        try{
            String sql = "select count(*) from car_dealership.car where car_dealership.car.vin_number = ? and car_type = 0";
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

    public int removeAllCarOffers(String vinNumber){
        try{
            String sql = "delete from car_dealership.offer where vin_number = ?";
            PreparedStatement preparedStatement = ConnectionConfiguration.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, vinNumber);
            return preparedStatement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

    public int removeCarFromLot(String vinNumber){
        try{
            String sql = "delete from car_dealership.car where vin_number = ?";
            PreparedStatement preparedStatement = ConnectionConfiguration.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, vinNumber);
            return preparedStatement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

}
