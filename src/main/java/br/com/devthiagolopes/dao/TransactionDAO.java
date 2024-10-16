package br.com.devthiagolopes.dao;

import br.com.devthiagolopes.exception.EntityNotFound;
import br.com.devthiagolopes.factory.ConnectionFactory;
import br.com.devthiagolopes.model.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class TransactionDAO {
    private Connection connection;

    public TransactionDAO() throws SQLException {
        this.connection = ConnectionFactory.getConnection();
    }

    private Transaction parseTransaction(ResultSet result) throws SQLException {
        int trn_in_code = result.getInt("trn_in_code");
        int tnt_in_code = result.getInt("tnt_in_code");
        int usu_in_code = result.getInt("usu_in_code");
        float trn_de_amount = result.getFloat("trn_de_amount");
        String trn_st_description = result.getString("trn_st_description");
        Date createdAt = result.getDate("createdAt");
        Date updatedAt = result.getDate("updatedAt");

        return new Transaction(trn_in_code, tnt_in_code, usu_in_code, trn_de_amount, trn_st_description, createdAt, updatedAt);
    }

    public List<Transaction> getAll() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM transactions");
        ResultSet result = stm.executeQuery();
        List<Transaction> list = new ArrayList<>();
        while (result.next()){
            list.add(parseTransaction(result));
        }
        return list;
    }

    public Transaction findById(int id) throws SQLException, EntityNotFound {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM transactions WHERE trn_in_code = ? ");
        stm.setInt(1, id);
        ResultSet result = stm.executeQuery();
        if (!result.next()){
            throw new EntityNotFound("Transação não encontrada");
        }
        return parseTransaction(result);
    }

    public void insert(Transaction transaction) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("INSERT INTO transactions (tnt_in_code, usu_in_code, trn_de_amount, trn_st_description, createdAt, updatedAt) VALUES (?, ?, ?, ?, SYSDATE, SYSDATE)");
        stm.setInt(1, transaction.getTnt_in_code());
        stm.setInt(2, transaction.getUsu_in_code());
        stm.setFloat(3, transaction.getTrn_de_amount());
        stm.setString(4, transaction.getTrn_st_description());
        stm.execute();
    }

    public void update(Transaction transaction) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("UPDATE transactions SET tnt_in_code = ?, usu_in_code = ?, trn_de_amount = ?, trn_st_description = ?, createdAt = SYSDATE, updatedAt = SYSDATE WHERE trn_in_code = ?");
        stm.setInt(1, transaction.getTnt_in_code());
        stm.setInt(2, transaction.getUsu_in_code());
        stm.setFloat(3, transaction.getTrn_de_amount());
        stm.setString(4, transaction.getTrn_st_description());
        stm.setInt(5, transaction.getTrn_in_code());
        stm.execute();
    }

    public void delete(int transactionId) throws SQLException, EntityNotFound {
        PreparedStatement stm = connection.prepareStatement("DELETE FROM transactions WHERE trn_in_code = ?");
        stm.setInt(1, transactionId);
        int line = stm.executeUpdate();
        if (line == 0) {
            throw new EntityNotFound("Não foi possivel excluir transação, id não encontrado");
        }
    }
}
