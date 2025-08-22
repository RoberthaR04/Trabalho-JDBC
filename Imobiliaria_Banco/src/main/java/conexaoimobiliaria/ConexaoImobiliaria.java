package conexaoimobiliaria;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoImobiliaria {
    private static final String url = "jdbc:mysql://localhost:3306/Imobiliaria";
    private static final String user = "root";
    private static final String password = "RSR14fran21&";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, user, password);
    }
}