package Shared.repository;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;

public interface IGeneric_Repository {

    boolean save(Object object);
    boolean delete(IntegerProperty id);
    boolean update(IntegerProperty id);
    ObservableList<Object> read();
}
