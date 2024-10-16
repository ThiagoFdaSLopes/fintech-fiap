package br.com.devthiagolopes.dao;

import br.com.devthiagolopes.exception.EntityNotFound;
import br.com.devthiagolopes.factory.ConnectionFactory;
import br.com.devthiagolopes.model.GoalCategorie;
import br.com.devthiagolopes.model.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoalCategorieDAO {

    private Connection connection;

    public GoalCategorieDAO() throws SQLException {
        this.connection = ConnectionFactory.getConnection();
    }

    private GoalCategorie parseGoalCategorie(ResultSet result) throws SQLException {
        int gsc_in_code = result.getInt("gsc_in_code");
        String gsc_st_type = result.getString("gsc_st_type");
        Date createdAt = result.getDate("createdAt");
        Date updatedAt = result.getDate("updatedAt");

        return new GoalCategorie(gsc_in_code, gsc_st_type,createdAt, updatedAt);
    }

    public List<GoalCategorie> getAll() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM goalscategories");
        ResultSet result = stm.executeQuery();
        List<GoalCategorie> list = new ArrayList<>();
        while (result.next()){
            list.add(parseGoalCategorie(result));
        }
        return list;
    }

    public GoalCategorie findById(int id) throws SQLException, EntityNotFound {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM goalscategories WHERE gsc_in_code = ? ");
        stm.setInt(1, id);
        ResultSet result = stm.executeQuery();
        if (!result.next()){
            throw new EntityNotFound("Goal Categorie não encontrada");
        }
        return parseGoalCategorie(result);
    }

    public void insert(GoalCategorie goalCategorie) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("INSERT INTO goalscategories (gsc_st_type, createdAt, updatedAt) VALUES (?, SYSDATE, SYSDATE)");
        stm.setString(1, goalCategorie.getGsc_st_type());
        stm.execute();
    }

    public void update(GoalCategorie goalCategorie) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("UPDATE goalscategories SET gsc_st_type = ?, createdAt = SYSDATE, updatedAt = SYSDATE WHERE gsc_in_code = ?");
        stm.setString(1, goalCategorie.getGsc_st_type());
        stm.setInt(2, goalCategorie.getGsc_in_code());
        stm.execute();
    }

    public void delete(int goalCategorieId) throws SQLException, EntityNotFound {
        PreparedStatement stm = connection.prepareStatement("DELETE FROM goalscategories WHERE gsc_in_code = ?");
        stm.setInt(1, goalCategorieId);
        int line = stm.executeUpdate();
        if (line == 0) {
            throw new EntityNotFound("Não foi possivel excluir goal categorie, id não encontrado");
        }
    }
}
