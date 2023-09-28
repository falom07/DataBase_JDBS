package Entity;

import java.util.Objects;

public class UserDetails {

    private int id;
    private int age;
    private String address;
    private String phone;

    public UserDetails() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetails userDetails = (UserDetails) o;
        return id == userDetails.id && age == userDetails.age && Objects.equals(address,userDetails.address)
                && Objects.equals(phone, userDetails.phone);
    }
    @Override
    public int hashCode(){
        int result = 1;
        result = result * 31 + id;
        result = result * 31 + age;
        result  = result * 31 + (address == null ? 0:address.hashCode());
        result  = result * 31 + (phone == null ? 0:phone.hashCode());
        return result;
    }
    @Override
    public String toString(){
        return "id " + id + "\nage " + age + "\naddress " + address + "\nphone " + phone;
    }
}
