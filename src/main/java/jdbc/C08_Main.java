package jdbc;

import java.sql.Connection;

public class C08_Main {
    public static void main(String[] args) {
        //DBWork objesini olustur.
        C07_DBWork db=new C07_DBWork();

        //Connection fonksiyonunu cagir
        Connection con=db.connect_to_db("techproed","postgres","Oguz1069");

        //Yeni table olusturma methodunu cagir
        db.createTable(con, "employees");




    }
}
