package br.com.campsocity.pojo;

public class Player {

    private String name;

    private String nickname;

    private int age;

    private String city;

    private String state;

    private Boolean paymentOnDay;

    private String document;

    private String position;

    private String photo;

    private String team;

    private String teamToken;

    private Boolean bruised;

    private String status;

    private String phone;

    private String email;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Boolean getPaymentOnDay() {
        return paymentOnDay;
    }

    public void setPaymentOnDay(Boolean paymentOnDay) {
        this.paymentOnDay = paymentOnDay;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Boolean getBruised() {
        return bruised;
    }

    public void setBruised(Boolean bruised) {
        this.bruised = bruised;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTeamToken() {
        return teamToken;
    }

    public void setTeamToken(String teamToken) {
        this.teamToken = teamToken;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}