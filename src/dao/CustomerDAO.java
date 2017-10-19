package dao;

import javafx.collections.ObservableList;
import models.CustomerModel;

public interface CustomerDAO {

    ObservableList<CustomerModel> showAll();

    void insert(CustomerModel ctm);

    void update(CustomerModel ctm);

    void delete(int id);

    ObservableList<CustomerModel> search(String keyword);

}
