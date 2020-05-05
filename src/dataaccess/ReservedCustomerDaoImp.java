package dataaccess;

import Customers.ReservedCustomers;
import Dao.ReservedCustomerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservedCustomerDaoImp implements ReservedCustomerDao {

    @Override
    public int addToReservedCustomer(ReservedCustomers obj) {
        int row = 0;
        String sql = "INSERT INTO Customers2 VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, obj.getCustomers().getCustomerID());
            pstm.setString(2, obj.getCustomers().getfName());
            pstm.setString(3, obj.getCustomers().getlName());
            pstm.setString(4, obj.getCustomers().getPhoneNumber());
            pstm.setString(5, obj.getCustomers().getPet().getName());
            pstm.setString(6, obj.getCustomers().getPet().getAge());
            pstm.setString(7, obj.getCustomers().getPet().getType().name());
            pstm.setString(8, obj.getResAct().name());
            pstm.setString(9, obj.getResRoom().name());
            pstm.setString(10, obj.getStatus().name());
            pstm.setInt(11, obj.getAmount());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return row;
    }

    @Override
    public int removeFromReservedCustomer(ReservedCustomers obj) {
        int row = 0;
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstm = conn.prepareStatement("DELETE FROM Customers2 WHERE IDNUMBER= (?)")) {
            pstm.setString(1, obj.getCustomers().getCustomerID());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return row;
    }

}
