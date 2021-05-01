package ru.lastdrv.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Facebook {
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
