package com.dao;

/**
 * Created with the help of the 2102 Enterprise class
 *
 * Contract for all Car-Dealership dao objects
 * @param <T> Class used for dao
 * @param <I> primary key used by the class
 */

public interface InterfaceDao<T, I> {

    //save an instance to the db
    int save(T t);

    //select an obect by primary key
    T getByPrimaryId(I id);

    //delete an object by primary key
    boolean remove(I id);

    //update an object in the db
    boolean update(T t);
}
