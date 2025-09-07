package iuh.fit.se.bai1_jsp_thaotacvoiform.models;

import java.time.LocalDate;

public class Student {
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private String email;
    private String mobileNumber;
    private String gender;
    private String address;
    private String city;
    private String pinCode;
    private String state;
    private String country;
    private String hobbies;
    private String course;

    public Student() {
    }

    public Student(String firstName, String lastName, LocalDate birthdate, String email, String mobileNumber, String gender, String address, String city, String pinCode, String state, String country, String hobbies, String course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.pinCode = pinCode;
        this.state = state;
        this.country = country;
        this.hobbies = hobbies;
        this.course = course;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public LocalDate getBirthdate() { return birthdate; }
    public String getEmail() { return email; }
    public String getMobileNumber() { return mobileNumber; }
    public String getGender() { return gender; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getPinCode() { return pinCode; }
    public String getState() { return state; }
    public String getCountry() { return country; }
    public String getHobbies() { return hobbies; }
    public String getCourse() { return course; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setBirthdate(LocalDate birthdate) { this.birthdate = birthdate; }
    public void setEmail(String email) { this.email = email; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }
    public void setGender(String gender) { this.gender = gender; }
    public void setAddress(String address) { this.address = address; }
    public void setCity(String city) { this.city = city; }
    public void setPinCode(String pinCode) { this.pinCode = pinCode; }
    public void setState(String state) { this.state = state; }
    public void setCountry(String country) { this.country = country; }
    public void setHobbies(String hobbies) { this.hobbies = hobbies; }
    public void setCourse(String course) { this.course = course; }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", hobbies='" + hobbies + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}