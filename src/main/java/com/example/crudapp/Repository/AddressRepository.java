package com.example.crudapp.Repository;

import com.example.crudapp.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
    @Query("select city from zipcodes  where city=:d")
    public List<Address> getUserByCity(@Param("d") String cityName);
}
