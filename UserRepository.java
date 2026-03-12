package com.kizva.repository;

import com.kizva.model.User;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // PostGIS query to find users within a certain distance (in meters)
    @Query(value = "SELECT * FROM users u WHERE ST_DWithin(u.location, :userLocation, :distance) = true", 
           nativeQuery = true)
    List<User> findNearbyUsers(@Param("userLocation") Point userLocation, @Param("distance") double distance);
    
    User findByUsername(String username);
}