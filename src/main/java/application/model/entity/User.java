package application.model.entity;

import java.util.Objects;

public class User {

    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Role role;
    private Boolean enable;

    public enum Role {
        UNAUTHORISED_USER,
        AUTHORISED_USER,
        MANAGER,
        ADMIN;

        public String getAuthority() {
            return this.name();
        }
    }

    public User(){
    }

    public User(Long userId){
        this.id = userId;
    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String username, String password, String firstName, String lastName, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User(String username, String password, String firstName, String lastName,
                String email, String phoneNumber, Role role, Boolean enable) {
        this.username =  username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.enable = enable;
    }

    public User(Long id, String username, String password, String firstName, String lastName,
                String email, String phoneNumber, Role role, Boolean enable) {
        this.id = id;
        this.username =  username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.enable = enable;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public Role getRole(){
        return role;
    }
    public void setRole(Role role){
        this.role = role;
    }

    public boolean isEnable() {
        return enable;
    }

    public String getEnable() {
        String enable = "active";
        if(!this.enable) enable = "blocked";
        return enable;
    }
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        User user = (User) obj;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phoneNumber, user.phoneNumber) &&
                role == user.role;
    }

    @Override
    public String toString() {
        return "User { username = " + this.getUsername() +
                ", password = " + this.getPassword() +
                ",\n\t first name = " + this.getFirstName() +
                ", last name = " + this.getLastName() +
                ",\n\t email = " + this.getEmail() +
                ", phone number = " + this.getPhoneNumber() +
                ",\n\t role = " + this.getRole() +
                ", enable = " + this.getEnable() + "}";
    }
}
