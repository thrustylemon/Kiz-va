package com.kizva.model;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import org.locationtech.jts.geom.Point;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonView(UserViews.Public.class)
    private String username;

    @JsonView(UserViews.MatchTier.class)
    private double compatibilityScore;

    @JsonView(UserViews.Private.class)
    private String email;

    @JsonView(UserViews.Private.class)
    private String password;

    // PostGIS Geometry type for location matching
    private Point location; 
}