package com.akhi.store.general;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "address")
public class Address
    {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int    id;

    @Column(nullable = false)
    private String address;

    @Column(nullable = true)
    private String city;

    public int getId()
        {
        return id;
        }

    public void setId( int id )
        {
        this.id = id;
        }

    public String getAddress()
        {
        return address;
        }

    public void setAddress( String address )
        {
        this.address = address;
        }

    public String getCity()
        {
        return city;
        }

    public void setCity( String city )
        {
        this.city = city;
        }

    }
