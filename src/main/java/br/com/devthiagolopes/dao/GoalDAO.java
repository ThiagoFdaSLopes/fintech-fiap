package br.com.devthiagolopes.dao;

import br.com.devthiagolopes.exception.EntityNotFound;
import br.com.devthiagolopes.factory.ConnectionFactory;
import br.com.devthiagolopes.model.Goal;
import br.com.devthiagolopes.model.GoalCategorie;
import br.com.devthiagolopes.model.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoalDAO {
    private Connection connection;

    public GoalDAO() throws SQLException {
        this.connection = ConnectionFactory.getConnection();
    }

    private Goal parseGoal(ResultSet result) throws SQLException {
        int gls_in_code = result.getInt("gls_in_code");
        int usu_in_code = result.getInt("usu_in_code");
        int gsc_in_code = result.getInt("gsc_in_code");
        String gls_st_description = result.getString("gls_st_description");
        Date gls_dt_init = result.getDate("gls_dt_init");
        Date gls_dt_conclusion = result.getDate("gls_dt_conclusion");
        float gls_de_amount = result.getFloat("gls_de_amount");
        float gls_de_progress = result.getFloat("gls_de_progress");
        Date createdAt = result.getDate("createdAt");
        Date updatedAt = result.getDate("updatedAt");

        return new Goal(gls_in_code, usu_in_code, gsc_in_code, gls_st_description, gls_dt_init, gls_dt_conclusion, gls_de_amount, gls_de_progress, createdAt, updatedAt);
    }

    public List<Goal> getAll() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM goals");
        ResultSet result = stm.executeQuery();
        List<Goal> list = new ArrayList<>();
        while (result.next()){
            list.add(parseGoal(result));
        }
        return list;
    }

    public Goal findById(int id) throws SQLException, EntityNotFound {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM goals WHERE gls_in_code = ? ");
        stm.setInt(1, id);
        ResultSet result = stm.executeQuery();
        if (!result.next()){
            throw new EntityNotFound("Goal não encontrada");
        }
        return parseGoal(result);
    }

    public void insert(Goal goal) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("INSERT INTO goals (usu_in_code, gsc_in_code, gls_st_description, gls_dt_init, gls_dt_conclusion, gls_de_amount, gls_de_progress, createdAt, updatedAt) VALUES (?,?,?,?,?,?,?, SYSDATE, SYSDATE)");
        stm.setInt(1, goal.getUsu_in_code());
        stm.setInt(2, goal.getGsc_in_code());
        stm.setString(3, goal.getgls_st_description());
        stm.setDate(4, goal.getGls_dt_init());
        stm.setDate(5, goal.getGls_dt_conclusion());
        stm.setFloat(6, goal.getGls_de_amount());
        stm.setFloat(7, goal.getGls_de_progress());
        stm.execute();
    }

    public void update(Goal goal) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("UPDATE goals SET usu_in_code = ?, gsc_in_code = ?, gls_st_description = ?, gls_dt_init = ?, gls_dt_conclusion = ?, gls_de_amount = ?, gls_de_progress = ?, createdAt = SYSDATE, updatedAt = SYSDATE WHERE gls_in_code = ?");
        stm.setInt(1, goal.getUsu_in_code());
        stm.setInt(2, goal.getGsc_in_code());
        stm.setString(3, goal.getgls_st_description());
        stm.setDate(4, goal.getGls_dt_init());
        stm.setDate(5, goal.getGls_dt_conclusion());
        stm.setFloat(6, goal.getGls_de_amount());
        stm.setFloat(7, goal.getGls_de_progress());
        stm.setInt(8, goal.getGls_in_code());
        stm.execute();
    }

    public void delete(int goalId) throws SQLException, EntityNotFound {
        PreparedStatement stm = connection.prepareStatement("DELETE FROM goals WHERE gls_in_code = ?");
        stm.setInt(1, goalId);
        int line = stm.executeUpdate();
        if (line == 0) {
            throw new EntityNotFound("Não foi possivel excluir goal, id não encontrado");
        }
    }
}
