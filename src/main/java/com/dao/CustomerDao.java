package com.dao;

import com.config.ConnectionConfiguration;
import com.model.Offer;

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

    public boolean carExistsByVin(String vinNumber){
        try{
            String sql = "select count(*) from car_dealership.car c where c.vin_number = ?";
            PreparedStatement preparedStatement = ConnectionConfiguration.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, vinNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            if(resultSet.getInt(1) > 0){
                return true;
            } else {
                return false;
            }
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean offerExists(String offerId){
        try{
            String sql = "select count(*) from car_dealership.offer o where o.offer_id = ?";
            PreparedStatement preparedStatement = ConnectionConfiguration.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, offerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            if(resultSet.getInt(1) > 0){
                return true;
            } else {
                return false;
            }
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public int remakeOffer(String offerId, float offerPrice){
        try{
            String sql = "update car_dealership.offer set offer_price = ? where car_dealership.offer.offer_id = ?";
            PreparedStatement preparedStatement = ConnectionConfiguration.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setFloat(1, offerPrice);
            preparedStatement.setString(2, offerId);
            int i = preparedStatement.executeUpdate();
            return i;
        } catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

    public int makeNewOffer(Offer offer){
        try{
            String offerId = offer.getVinNumber().concat(offer.getUsername());
            String sql = "insert into car_dealership.offer values (?, ?, ?, ?);";
            PreparedStatement preparedStatement = ConnectionConfiguration.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, offerId);
            preparedStatement.setString(2, offer.getVinNumber());
            preparedStatement.setString(3, offer.getUsername());
            preparedStatement.setFloat(4, offer.getOfferPrice());
            int i = preparedStatement.executeUpdate();
            return i;
        } catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }
}
