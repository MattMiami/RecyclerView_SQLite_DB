package com.example.sqlite_recycler;

public class Contacto {

    private String dni;
    private String name;
    private String surname;
    private String mail;
    private String address;
    private String phone;
    private float GPS_x;
    private float GPS_y;

    public Contacto() {
    }

    public Contacto(String dni, String name, String surname, String mail, String address, String phone, Float GPS_x, Float GPS_y) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.address = address;
        this.phone = phone;
        this.GPS_x = GPS_x;
        this.GPS_y = GPS_y;
    }

    public String getDni() {return dni;}
    public String getName() {return name;}
    public String getSurname() {return surname;}
    public String getMail() {return mail;}
    public String getAddress() {return address;}
    public String getPhone() {return phone;}
    public Float getGPS_x() {return GPS_x;}
    public Float getGPS_y() {return GPS_y;}

    public void setDni(String dni) {this.dni = dni;}
    public void setName(String name) {this.name = name;}
    public void setSurname(String surname) {this.surname = surname;}
    public void setMail(String mail) {this.mail = mail;}
    public void setAddress(String address) {this.address = address;}
    public void setPhone(String phone) {this.phone = phone;}
    public void setGPS_x(Float GPS_x) {this.GPS_x = GPS_x;}
    public void setGPS_y(Float GPS_y) {this.GPS_y = GPS_y;}
}
