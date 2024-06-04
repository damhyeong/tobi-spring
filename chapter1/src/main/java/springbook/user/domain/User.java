package springbook.user.domain;

public class User {
    String id;
    String name;
    String password;

    public String getId(){
        return this.id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
