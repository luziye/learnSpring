package com.luziye.bootluanch.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {

  private static final long serialVersionUID = -8985545025228238754L;

  String id;
  String firstname;
  String lastname;
  Address address;
  public Person() {
  }
  public Person(String firstname, String lastname) {
    this.firstname = firstname;
    this.lastname = lastname;
  }
}