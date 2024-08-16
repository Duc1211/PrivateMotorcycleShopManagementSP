package format.service;

import connect.ConnectDB;
import model.ChartModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiceReport {
    public List<ChartModel> getData() throws SQLException {
        List<ChartModel> list = new ArrayList<>();
        String sql = "select DATE_FORMAT(Date,'%M') as M, SUM(Total) as Total, SUM(Cost) as Cost, SUM(Profit) as Profit from Invoice GROUP BY DATE_FORMAT(Date,'%Y-%M') order by Date DESC limit 6";
        Statement p = (Statement) ConnectDB.getInstance().getConnection().prepareStatement(sql);
        ResultSet r = p.executeQuery(sql);
        while (r.next()) {
            String month = r.getString(1);
            double total = r.getDouble(2);
            double cost = r.getDouble(3);
            double profit = r.getDouble(4);
            list.add(new ChartModel(month, new double[]{total, cost, profit}));
        }
        r.close();
        p.close();
        return list;
    }
}
