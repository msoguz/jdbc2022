package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C01_Execute {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO: 1. ADIM : Driver'a kaydol
        Class.forName("org.postgresql.Driver");

        //TODO: 2. ADIM : Database'e baglan
        Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","Oguz1069");

        //TODO: 3. ADIM : Statement olustur
        Statement st= con.createStatement();

        //TODO: 4. ADIM : Query calistir.

        //1.Example: "workers" adında bir table oluşturup "worker_id,worker_name, worker_salary" sütunlarını ekleyin.
       String sql1="CREATE TABLE workers(worker_id VARCHAR(50), worker_name VARCHAR(50), worker_salary INT)";
       boolean result= st.execute(sql1);
       //System.out.println(result); // false return eder. cunku data cagrilmadi.


        //2.Örnek: Table'a worker_address sütunu ekleyerel alter yapın.
        String sql2="ALTER TABLE workers ADD worker_adress VARCHAR(80)";
        st.execute(sql2);

        //3.Example: Drop workers table
        String sql3="DROP TABLE workers";
        st.execute(sql3);

        //TODO: 5. Adim : Baglanti ve statement'i kapat.
        con.close();
        st.close();
    }
}
