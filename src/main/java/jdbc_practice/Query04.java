package jdbc_practice;

import java.sql.*;

public class Query04 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1) Drive yukle
        Class.forName("org.postgresql.Driver");

        //2) Baglanti olustur
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","Oguz1069");

        //3) Statement
        //Statement st=con.createStatement();
        PreparedStatement ps=con.prepareStatement("insert into ogrenciler values(?,?,?,?");
        //PreparedStatement, Statement'e gore daha dinamik ve datatbase'de daha az yer kapliyor.
        ps.setInt(1, 200);
        ps.setString(2, "Veli Can");
        ps.setString(2, "12");
        ps.setString(4,"E");

        ps.executeUpdate();
        System.out.println("Veri girisi yapildi. ");

    }
}
