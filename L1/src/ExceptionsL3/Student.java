package ExceptionsL3;

import java.sql.SQLException;

public class Student {

    int findStudentById(int id) throws SQLException , ClassNotFoundException,EvenException{
//        return 9/0;
//        throw new ArithmeticException();


        if(id >30){
            throw new SQLException();
        } else if (id%2==0) {
            throw new EvenException();

        }else if(id%2==1){
            throw new OddException();
        }else{
            throw new ClassNotFoundException();
        }
    }
}
