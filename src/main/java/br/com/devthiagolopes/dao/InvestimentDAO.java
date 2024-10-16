package br.com.devthiagolopes.dao;

import br.com.devthiagolopes.exception.EntityNotFound;
import br.com.devthiagolopes.factory.ConnectionFactory;
import br.com.devthiagolopes.model.Investiment;
import br.com.devthiagolopes.model.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvestimentDAO {
    private Connection connection;

    public InvestimentDAO() throws SQLException {
        this.connection = ConnectionFactory.getConnection();
    }

    private Investiment parseInvestiment(ResultSet result) throws SQLException {
        int inv_in_code = result.getInt("inv_in_code");
        int ivt_in_code = result.getInt("ivt_in_code");
        int usu_in_code = result.getInt("usu_in_code");
        String inv_st_name = result.getString("inv_st_name");
        float inv_de_amount = result.getFloat("inv_de_amount");
        Date inv_dt_buy = result.getDate("inv_dt_buy");
        Date createdAt = result.getDate("createdAt");
        Date updatedAt = result.getDate("updatedAt");

        return new Investiment(inv_in_code, ivt_in_code, usu_in_code, inv_st_name, inv_de_amount, inv_dt_buy, createdAt, updatedAt);
    }

    public List<Investiment> getAll() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM investiments");
        ResultSet result = stm.executeQuery();
        List<Investiment> list = new ArrayList<>();
        while (result.next()){
            list.add(parseInvestiment(result));
        }
        return list;
    }

    public Investiment findById(int id) throws SQLException, EntityNotFound {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM investiments WHERE inv_in_code = ?");
        stm.setInt(1, id);
        ResultSet result = stm.executeQuery();
        if (!result.next()){
            throw new EntityNotFound("Investimento não encontrada");
        }
        return parseInvestiment(result);
    }

    public void insert(Investiment investiment) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("INSERT INTO investiments (ivt_in_code, usu_in_code, inv_st_name, inv_de_amount, inv_dt_buy, createdAt, updatedAt) VALUES (?, ?, ?, ?, ?, SYSDATE, SYSDATE)");
        stm.setInt(1, investiment.getIvt_in_code());
        stm.setInt(2, investiment.getUsu_in_code());
        stm.setString(3, investiment.getInv_st_name());
        stm.setFloat(4, investiment.getInv_de_amount());
        stm.setDate(5, investiment.getInv_dt_buy());
        stm.execute();
    }

    public void update(Investiment investiment) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("UPDATE investiments SET ivt_in_code = ?, usu_in_code = ?, inv_st_name = ?, inv_dt_buy = ?, createdAt = SYSDATE, updatedAt = SYSDATE WHERE inv_in_code = ?");
        stm.setInt(1, investiment.getIvt_in_code());
        stm.setInt(2, investiment.getUsu_in_code());
        stm.setString(3, investiment.getInv_st_name());
        stm.setDate(4, investiment.getInv_dt_buy());
        stm.setInt(5, investiment.getInv_in_code());
        stm.execute();
    }

    public void delete(int investimentId) throws SQLException, EntityNotFound {
        PreparedStatement stm = connection.prepareStatement("DELETE FROM investiments WHERE inv_in_code = ?");
        stm.setInt(1, investimentId);
        int line = stm.executeUpdate();
        if (line == 0) {
            throw new EntityNotFound("Não foi possivel excluir o investimento, id não encontrado");
        }
    }
}
