package br.com.devthiagolopes.dao;

import br.com.devthiagolopes.exception.EntityNotFound;
import br.com.devthiagolopes.factory.ConnectionFactory;
import br.com.devthiagolopes.model.GoalCategorie;
import br.com.devthiagolopes.model.InvestimentType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvestimentTypeDAO {
    private Connection connection;

    public InvestimentTypeDAO() throws SQLException {
        this.connection = ConnectionFactory.getConnection();
    }

    private InvestimentType parseInvestimentType(ResultSet result) throws SQLException {
        int ivt_in_code = result.getInt("ivt_in_code");
        String ivt_st_type = result.getString("ivt_st_type");
        Date createdAt = result.getDate("createdAt");
        Date updatedAt = result.getDate("updatedAt");

        return new InvestimentType(ivt_in_code, ivt_st_type, createdAt, updatedAt);
    }

    public List<InvestimentType> getAll() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM investimentstypes");
        ResultSet result = stm.executeQuery();
        List<InvestimentType> list = new ArrayList<>();
        while (result.next()){
            list.add(parseInvestimentType(result));
        }
        return list;
    }

    public InvestimentType findById(int id) throws SQLException, EntityNotFound {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM investimentstypes WHERE ivt_in_code = ?");
        stm.setInt(1, id);
        ResultSet result = stm.executeQuery();
        if (!result.next()){
            throw new EntityNotFound("Investiment Type não encontrada");
        }
        return parseInvestimentType(result);
    }

    public void insert(InvestimentType investimentType) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("INSERT INTO investimentstypes (ivt_st_type, createdAt, updatedAt) VALUES (?, SYSDATE, SYSDATE)");
        stm.setString(1, investimentType.getIvt_st_type());
        stm.execute();
    }

    public void update(InvestimentType investimentType) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("UPDATE investimentstypes SET ivt_st_type = ?, createdAt = SYSDATE, updatedAt = SYSDATE WHERE ivt_in_code = ?");
        stm.setString(1, investimentType.getIvt_st_type());
        stm.setInt(2, investimentType.getIvt_in_code());
        stm.execute();
    }

    public void delete(int investimentid) throws SQLException, EntityNotFound {
        PreparedStatement stm = connection.prepareStatement("DELETE FROM investimentstypes WHERE ivt_in_code = ?");
        stm.setInt(1, investimentid);
        int line = stm.executeUpdate();
        if (line == 0) {
            throw new EntityNotFound("Não foi possivel excluir investiment type, id não encontrado");
        }
    }
}
