package kg.megacom.Salon.services;

import java.util.List;

public interface BaseServices <T> {
    T save(T t);
    T findById(Long id);
    List<T> findAll();

}
