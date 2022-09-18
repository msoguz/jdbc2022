package jdbc_practice;

import java.sql.*;

public class Query02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1) Drive yukle
        Class.forName("org.postgresql.Driver");

        //2) Baglanti olustur
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","Oguz1069");

        //3) Statement
        Statement st=con.createStatement();

        //SORU:Ogrenciler tablosundaki erkek ogrencileri listeleyiniz.
        ResultSet data=st.executeQuery("select * from ogrenciler where cinsiyet='E'");
        while(data.next()){
            System.out.println(data.getInt(1)+data.getString(2)+data.getString(3)+data.getString(4));
        }
        con.close();
        st.close();
        data.close();
    }
}
