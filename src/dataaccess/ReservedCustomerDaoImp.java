package dataaccess;


import Customers.Customers;
import Customers.GeneralList;
import Customers.ReservedCustomers;
import Dao.ReservedCustomerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
                Statement stm = conn.createStatement()) {
            row = stm.executeUpdate("DELETE FROM Customers2 WHERE IDNUMBER=" + obj.getCustomers().getCustomerID());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return row;
    }

    @Override
    public GeneralList<ReservedCustomers> findCustomerByPetname(String name) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

//        GeneralList<ReservedCustomers> List = new GeneralList<>();
//        String sql = "SELECT * FROM Customer2 WHERE pet_name like ?";
//        try (Connection conn = DBConnection.getConnection();
//                PreparedStatement stm = conn.prepareStatement(sql)) {
//            stm.setString(1, "%" + name + "%");
//            ResultSet rs = stm.executeQuery();
//            while (rs.next()) {
//                
//                
////   public ReservedCustomers(RoomType resRoom, Activities[] resAct, ReservedStatus status, int amount, String IdNumber, String fName, String lName, String phoneNumber) {
////        super(IdNumber, fName, lName, phoneNumber);
////        this.resRoom = resRoom;
////        this.resAct = resAct;
////        this.status = status;
////        this.amount = amount;
////    }
//
//                List.add(new ReservedCustomers(
//                        rs.getObject("resRoom"),  
//                        rs.getArray("resAct"),  
//                        rs.getObject("Status"),
//                        rs.getInt("amount"),
//                        rs.getString("IdNumber"),
//                        rs.getString("fName"),
//                        rs.getString("lName"),
//                        rs.getString("phoneNumber"),
//                        rs.getString("name"),
//                        rs.getString("age"),
//                        rs.getString("type")));
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        return List;
    }

    @Override
    public GeneralList<ReservedCustomers> findCustomerByname(Customers obj) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

//        GeneralList<ReservedCustomers> prodList = new GeneralList<>();
//        try (Connection conn = DBConnection.getConnection();
//                Statement stm = conn.createStatement()) {
//            String sql = "SELECT * FROM customer2 WHERE wishlist.cus_id=" + obj.get();
//            ResultSet rs = stm.executeQuery(sql);
//            while (rs.next()) {
//                prodList.add(new Product(rs.getInt("pro_id"), rs.getString("pro_name"), rs.getDouble("price")));
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return prodList;
    }

    @Override
    public ReservedCustomers loadyourStatus(Customers obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
