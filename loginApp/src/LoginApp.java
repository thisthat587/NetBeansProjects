import java.sql.*;

public class LoginApp {

    public static void main(String[] args) {
        ResultSet rs;
        String url = "jdbc:mysql://localhost:3306/stdinfo";
        String user = "root";
        String password = "root";
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            if (con != null) {
                System.out.println("Connected to Database...\n");
                String query = "select * from std_details;";
                Statement st = con.createStatement();
                rs = st.executeQuery(query);

                while(rs.next()) {
                    int roll = rs.getInt("roll");
                    String name = rs.getString("name");
                    String dob = rs.getString("dob");
                    System.out.println("Roll : " + roll + " Name : " + name + " DOB : " + dob);
                }
            } else {
                System.out.println("Some error Occured...");
            }
        } catch (Exception e) {
            System.out.println("Some error Occured..." + e);
        }
    }
}
