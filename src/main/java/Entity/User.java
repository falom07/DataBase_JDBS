package Entity;

import java.util.Objects;

public class User {
    private int id;
    private String name;

    public User(){}

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name,user.name);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 31 + id;
        result = result * 31 + (name == null ? 0:name.hashCode());
        return result;
    }

    @Override
    public String toString(){
        return "User {" +
                "id = " + id +
                "name = " + name + " }";
    }
}
