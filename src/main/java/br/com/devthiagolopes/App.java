package br.com.devthiagolopes;

import br.com.devthiagolopes.dao.InvestimentTypeDAO;
import br.com.devthiagolopes.model.InvestimentType;

import java.sql.SQLException;
import java.util.List;

public class App
{
    public static void main( String[] args ) {
        try {
            InvestimentTypeDAO investimentTypeDAO = new InvestimentTypeDAO();

            String[] investmentsTypes = { "Ações", "Fundos Imobiliários", "Renda Fixa", "CDB", "LCI" };

            for (String investmentType : investmentsTypes) {
                InvestimentType investiment = new InvestimentType(investmentType);
                investimentTypeDAO.insert(investiment);
            }
            List<InvestimentType> investimentTypes = investimentTypeDAO.getAll();

            System.out.println("Temos um total de " +  investimentTypes.size() + " investimentos");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
