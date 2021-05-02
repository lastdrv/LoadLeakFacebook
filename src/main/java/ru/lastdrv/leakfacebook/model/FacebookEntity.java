package ru.lastdrv.leakfacebook.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FacebookEntity {
    @Id
    long phone;
    long id;
    String firstName;
    String secondName;
    String sex;
    String city;
    String restrict;
    String status;
    String work;
    String date;
    String unknown;
    String birthday;
}
