package com.kayulu.springbootOneToOneMapping.dao;

import com.kayulu.springbootOneToOneMapping.entity.Instructor;
import org.springframework.stereotype.Repository;

public interface AppDAO {
    public void save(Instructor instructor);
}
