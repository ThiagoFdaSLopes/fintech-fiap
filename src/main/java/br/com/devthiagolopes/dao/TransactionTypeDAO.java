package br.com.devthiagolopes.dao;

import br.com.devthiagolopes.exception.EntityNotFound;
import br.com.devthiagolopes.factory.ConnectionFactory;
import br.com.devthiagolopes.model.TransactionType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionTypeDAO {
    private Connection connection;

    public TransactionTypeDAO()throws SQLException {
        this.connection = ConnectionFactory.getConnection();
    }

    private TransactionType parseTransactionType(ResultSet result) throws SQLException {
        int tnt_in_code = result.getInt("tnt_in_code");
        String tnt_st_type = result.getString("tnt_st_type");
        Date createdAt = result.getDate("createdAt");
        Date updatedAt = result.getDate("updatedAt");
        return new TransactionType(tnt_in_code, tnt_st_type, createdAt, updatedAt);
    }

    public List<TransactionType> getAll() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM transactionstypes");
        ResultSet result = stm.executeQuery();
        List<TransactionType> list = new ArrayList<>();
        while (result.next()){
            list.add(parseTransactionType(result));
        }
        return list;
    }

    public TransactionType findById(int id) throws SQLException, EntityNotFound {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM transactionstypes WHERE tnt_in_code = ? ");
        stm.setInt(1, id);
        ResultSet result = stm.executeQuery();
        if (!result.next()){
            throw new EntityNotFound("Tipo de Transação não encontrada");
        }
        return parseTransactionType(result);
    }

    public void insert(TransactionType transactiontype) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("INSERT INTO transactionstypes (tnt_st_type, createdAt, updatedAt) VALUES (?, SYSDATE, SYSDATE)");
        stm.setString(1, transactiontype.getTnt_st_type());
        stm.execute();
    }

    public void update(TransactionType transactiontype) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("UPDATE transactionstypes SET tnt_st_type = ?, createdAt = SYSDATE, updatedAt = SYSDATE WHERE tnt_in_code = ?");
        stm.setString(1, transactiontype.getTnt_st_type());
        stm.setInt(2, transactiontype.getTnt_in_code());
        stm.execute();
    }

    public void delete(int transactiontypeId) throws SQLException, EntityNotFound {
        PreparedStatement stm = connection.prepareStatement("DELETE FROM transactionstypes WHERE tnt_in_code = ?");
        stm.setInt(1, transactiontypeId);
        int line = stm.executeUpdate();
        if (line == 0) {
            throw new EntityNotFound("Não foi possivel excluir o tipo de transação, id não encontrado");
        }
    }

}
