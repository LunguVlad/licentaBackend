package licenta.backend.models;

import javax.persistence.*;

@Entity
@Table(name="[user]")
public class User {
//    public final int ADMINISTRATOR = 0;
//    public final int LOCATAR = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private int phoneNumber;
    private int accountType;
    private int scara;
    @Column(unique = true)
    private int apartament;
    private int nrPersoane;
    private double cotaIndiviza;
    //boolean centrala??




    public User(){

    }

    public User(int id, String lastName, String firstName, String email, String password, int phoneNumber, int accountType, int scara, int apartament, int nrPersoane, double cotaIndiviza) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.accountType = accountType;
        this.scara = scara;
        this.apartament = apartament;
        this.nrPersoane = nrPersoane;
        this.cotaIndiviza = cotaIndiviza;
    }

    public User(int id, String lastName, String firstName, String email, String password, int phoneNumber, int accountType, int scara, int apartament) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.accountType = accountType;
        this.scara = scara;
        this.apartament = apartament;
    }

    public User(int id, String lastName, String firstName, String email, String password) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public int getNrPersoane() {
        return nrPersoane;
    }

    public void setNrPersoane(int nrPersoane) {
        this.nrPersoane = nrPersoane;
    }

    public double getCotaIndiviza() {
        return cotaIndiviza;
    }

    public void setCotaIndiviza(double cotaIndiviza) {
        this.cotaIndiviza = cotaIndiviza;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public int getScara() {
        return scara;
    }

    public void setScara(int scara) {
        this.scara = scara;
    }

    public int getApartament() {
        return apartament;
    }

    public void setApartament(int apartament) {
        this.apartament = apartament;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
