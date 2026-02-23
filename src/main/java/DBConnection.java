import java.sql.*;
import io.github.cdimascio.dotenv.Dotenv;

public class DBConnection {

  public Connection getConnection() {
      Dotenv dotenv = Dotenv.load();
      try{
          String url = dotenv.get("DB_URL");
          String user = dotenv.get("DB_USER");
          String password = dotenv.get("DB_PASSWORD");
          assert url != null;
          return DriverManager.getConnection(url, user, password);
      }catch(SQLException e){
          throw new RuntimeException(e);
      }
  }


}