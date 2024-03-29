package jdbc;

import java.sql.*;

public class C05_PreparedStatement {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","Oguz1069");
        Statement st=con.createStatement();

        //TODO:1. Örnek: Prepared statement kullanarak company adı IBM olan number_of_employees değerini 9999 olarak güncelleyin.

        //1.ADIM : Prepared statement query'sini olustur.
        String sql1="UPDATE companies SET number_of_employees=? WHERE company=?";

        //2. ADIM : PreparedStatement obje'sini olustur
        PreparedStatement pst1=con.prepareStatement(sql1);

        //3. ADIM : set....() method'lari ile soru isaretleri icin deger gir.
        pst1.setInt(1,9999);
        pst1.setString(2,"IBM");

        //4. ADIM : Execute Query    --> Query'yi calistir
        int updateRowSayisi=pst1.executeUpdate();
        System.out.println(updateRowSayisi + " satir guncellendi.");

        String sql2 = "SELECT * FROM companies";
        ResultSet result1=st.executeQuery(sql2);

        while(result1.next()) {
            System.out.println(result1.getInt(1)+"--"+result1.getString(2)+"--"+result1.getInt(3));

        }

        //*******************************************************
        // Google icin 15000 yapalim

        pst1.setInt(1,15000);
        pst1.setString(2,"GOOGLE");

        //4. ADIM : Execute Query    --> Query'yi calistir
        int updateRowSayisi2=pst1.executeUpdate();
        System.out.println(updateRowSayisi + " satir guncellendi.");

        String sql3 = "SELECT * FROM companies";
        ResultSet result2=st.executeQuery(sql2);

        while(result2.next()) {
            System.out.println(result2.getInt(1)+"--"+result2.getString(2)+"--"+result2.getInt(3));
        }

        System.out.println("********************************");
        read_data(con, "companies");

    }


    //TODO:2. Örnek: "SELECT * FROM <table name>" query'sini prepared statement ile kullanın.

    // Bir tablonun istenilen data'sini prepared statement ile cagirmak icin kullanilan method.
        public static void read_data(Connection con, String tableName) {

            try {
                String query = String.format("SELECT * FROM %s", tableName);// format methodu dinamik bir String olusturmak icin kullanilir.

                Statement statement=con.createStatement();
                //SQL query'yi calistir.
                ResultSet rs=statement.executeQuery(query);//Data'yi cagirip ResultSet konteynir'ina koyduk.

                while(rs.next()){

                    System.out.println(rs.getInt(1)+"--"+rs.getString(2)+"--"+rs.getInt(3));
                }


            } catch (Exception e){
                System.out.println(e);
            }

        }
}
