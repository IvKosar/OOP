public class Client {

    private String name;
    private Integer age;
    private Enum sex;
    private String email;

    private Client (Client info) {
        this.name = info.name;
        this.age = info.age;
        this.sex = info.sex;
        this.email = info.email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Enum getSex() {
        return this.sex;
    }

    public void setSex(Enum sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public enum sex {
        MALE, FEMALE, OTHER
    }
}
