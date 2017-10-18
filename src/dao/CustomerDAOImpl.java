package dao;

import javafx.collections.ObservableList;
import models.CustomerModel;
import database.*;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public ObservableList<CustomerModel> showAll() {
        return SelectApp.selectAll();
    }

    @Override
    public void insert(CustomerModel cm) {

    }

    @Override
    public void update(CustomerModel cm) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public CustomerModel search(int customerID) {
        return null;
    }
}
