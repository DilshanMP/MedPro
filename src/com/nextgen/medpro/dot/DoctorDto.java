package com.nextgen.medpro.dot;

import com.nextgen.medpro.enums.GenderType;

public class DoctorDto {
    private String firstname;
    private String lastname;
    private String nic;
    private String contact;
    private String email;
    private String specializations;
    private String address;
    private GenderType gender;

    public DoctorDto() {
    }

    public DoctorDto(String firstname, String lastname, String nic, String contact, String email, String specializations, String address, GenderType gender) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.nic = nic;
        this.contact = contact;
        this.email = email;
        this.specializations = specializations;
        this.address = address;
        this.gender = gender;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecializations() {
        return specializations;
    }

    public void setSpecializations(String specializations) {
        this.specializations = specializations;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "DoctorDto{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", nic='" + nic + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", specializations='" + specializations + '\'' +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                '}';
    }
}
