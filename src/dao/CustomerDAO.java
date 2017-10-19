package dao;

import javafx.collections.ObservableList;
import models.CustomerModel;

public interface CustomerDAO {

    public ObservableList<CustomerModel> showAll();

    public void insert(CustomerModel cm);

    public void update(CustomerModel cm);

    public void delete(int id);

    public ObservableList<CustomerModel> search(String keyword);

}
