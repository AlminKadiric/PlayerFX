package com.lines.connected.playerfx.dao.entity;

import java.util.List;

public interface Dao <E>{
    E save(E entity);

    List<E> getAll();

    E get(Long id);

    E update(E entity);

    boolean delete(E entity);


}
