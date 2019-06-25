import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Test {
    //定义MySQL的数据库驱动程序
    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
    //定义MySQL数据库的连接地址
    public static final String DBURL = "jdbc:mysql://127.0.0.1:3306/personal_test1?&useSSL=false";
//    public static final String DBURL = "jdbc:mysql://192.168.100.141:3306/soeasy_asset?&useSSL=false";
    //MySQL数据库的连接用户名
    public static final String DBUSER = "root"; //soeasy_dev_admin
    //MySQL数据库的连接密码
    public static final String DBPASS = "xiaokai249";//Soeasy_123
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        //数据库查询语句
        String sql = "select * from test1_table";
        try {
            //加载驱动程序
            Class.forName(DBDRIVER);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //连接MySQL数据库时，要写上连接的用户名和密码
            con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            //实例化Statement对象
            stmt = con.createStatement();
            //执行数据库查询操作
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                System.out.println("========="+id);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(con);
        try {
            //关闭结果集
            rs.close();
            //关闭操作
            stmt.close();
            //关闭数据库
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}