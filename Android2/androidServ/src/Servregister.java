import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Servregister extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("register-doPost");
        System.out.println("register-doget");
        request.setCharacterEncoding("UTF-8");
        String user_id = request.getParameter("username");
        String user_pw = request.getParameter("password");
        PrintWriter out = response.getWriter();
        //调用数据库
        // 直接调用DB中的静态方法来为本类服务
        Connection conn = DB.getConnection();
        Statement stmt = DB.getStatement(conn);
        String sql =  "select * from users where user_id ='" + user_id
                + "'";
        ResultSet rs = DB.getResultSet(stmt, sql);
        try {
            if (rs.next()) {
                System.out.println("账号已存在");
                out.print("false2");
            } else {
                String sqlInsert = "insert into users(user_id,user_password) values('"+ user_id +"','" + user_pw + "')";
                System.out.println("执行sql语句："+sqlInsert);
                DB.elsql(stmt,sqlInsert);
                System.out.println("账号已增加");
                out.print("true");
            }
        } catch (SQLException e) {
            out.print("false");
            e.printStackTrace();
        }
    }

}
