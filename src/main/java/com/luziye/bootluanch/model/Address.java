package com.luziye.bootluanch.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Address implements Serializable {

  private static final long serialVersionUID = -8985545025228238771L;

  String city;
  String country;
  public Address() {
  }
  public Address(String city, String country) {
    this.city = city;
    this.country = country;
  }
}