package models;

public class BankAccount {
   private int id;
    private int sold;
    private User User;

    public BankAccount() {
    }

    public BankAccount(int sold, User User) {
        this.sold = sold;
        this.User = User;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User User) {
        this.User = User;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "sold=" + sold +
                ", User=" + User +

                '}';
    }
}
