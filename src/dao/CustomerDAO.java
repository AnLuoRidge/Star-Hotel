package dao;

import javafx.collections.ObservableList;
import models.CustomerModel;

public interface CustomerDAO {

    public ObservableList<CustomerModel> showAll();

    public void insert(CustomerModel cm);

    public void update(CustomerModel cm);

    public void delete(int id);

    public ObservableList<CustomerModel> search(String customerID);

//    //添加方法
//    public void add(Person p)throws SQLException;
//
//    //更新方法
//    public void update(Person p)throws SQLException;
//
//    //删除方法
//    public void delete(int id)throws SQLException;
//
//    //查找方法
//    public Person findById(int id)throws SQLException;
//
//    //查找所有
//    public List<Person> findAll()throws SQLException;
}
