package services;

import models.BankAccount;
import utils.MyDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BookServices implements IService<BankAccount>{
    private Connection cnx;

    public BookServices() {
        cnx = MyDatabase.getInstance().getConnection();
    }

    @Override
    public void add(BankAccount bankAccount) throws SQLException {
        String req = "INSERT INTO `bankAccount`(`solde`, `idUser`) VALUES (?,?)";

        PreparedStatement stm  = cnx.prepareStatement(req);
        stm.setInt(1,bankAccount.getSold());
        stm.setInt(2,bankAccount.getUser().getId());

        stm.executeUpdate();
    }

    @Override
    public void update(BankAccount bankAccount) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public List<BankAccount> getAll() throws SQLException {
        return null;
    }

    @Override
    public BankAccount getById(int bankAccountId) throws SQLException {
        return null;
    }
}
