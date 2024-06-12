package springbook.user.domain;

public class User {
    private String id;
    private String name;
    private String password;

    public User(){

    }
    public User(String id, String name, String password){
        this.id = id; this.name = name; this.password = password;
    }

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }
}
