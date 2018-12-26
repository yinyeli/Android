import java.sql.*;

/**
 * 专门跟数据库打交道的类
 *
 * @author ykn
 */
public class DB {

    // 获取连接
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/androidDB?user=test&password=123456");
        } catch (ClassNotFoundException e) {
            System.out.println("驱动程序未找到，请加入mysql.jdbc的驱动包。。。");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("执行数据库连接过程中出现了错误。。。");
            e.printStackTrace();
        }
        return conn;
    }

    // 获取表达式语句
    public static Statement getStatement(Connection conn) {
        Statement stmt = null;
        try {
            if (conn != null) {
                stmt = conn.createStatement();
            }
        } catch (SQLException e) {
            System.out.println("执行获取表达式语句过程中出现了错误。。。");
            e.printStackTrace();
        }
        return stmt;
    }

    // 获取查询的结果集
    public static ResultSet getResultSet(Statement stmt, String sql) {
        ResultSet rs = null;
        try {
            if (stmt != null) {
                rs = stmt.executeQuery(sql);
            }
        } catch (SQLException e) {
            System.out.println("执行查询过程中出现了错误。。。");
            e.printStackTrace();
        }
        return rs;
    }

    // 关闭连接
    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            System.out.println("执行关闭数据库连接过程中出现了错误。。。");
            e.printStackTrace();
        }
    }

    // 关闭表达式语句
    public static void close(Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
        } catch (SQLException e) {
            System.out.println("执行关闭表达式语句过程中出现了错误。。。");
            e.printStackTrace();
        }
    }

    // 关闭结果集
    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
        } catch (SQLException e) {
            System.out.println("执行关闭结果集过程中出现了错误。。。");
            e.printStackTrace();
        }
    }

    //增删改
    public static int elsql(Statement stmt,String sql){
        try {
            stmt.executeUpdate(sql);//执行sql插入语句
            return 1;
        }catch (SQLException e){
            System.out.println("执行增删改sql出错。。。。");
            e.printStackTrace();
            return 0;
        }

    }
} 