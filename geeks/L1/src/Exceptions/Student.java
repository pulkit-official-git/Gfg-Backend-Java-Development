package Exceptions;

import java.sql.SQLException;

public class Student {

    public int findStudentByRollNo(int rollNo) throws ClassNotFoundException,EvenNumberException,SQLException {

        if (rollNo < 30) {
// calls third prty api which can show exception
            throw new ClassNotFoundException();

        } else if (rollNo%2==0) {
            throw new EvenNumberException();

        } else if (rollNo%2==1) {
            throw new OddNumberException();

        }else {
            throw new SQLException();
        }
//        return 1/0;
    }
//    public int findStudent(int rollNo) {
//        try {
//            if (rollNo < 30) {
//// calls third prty api which can show exception
//                throw new ClassNotFoundException();
//
//            } else if (rollNo%2==0) {
//                throw new EvenNumberException();
//
//            } else if (rollNo%2==1) {
//                throw new OddNumberException();
//
//            }else {
//                throw new SQLException();
//            }
//        } catch (ClassNotFoundException e) {
//
//        } catch (EvenNumberException e) {
//
//        } catch (OddNumberException e) {
//
//        } catch (SQLException e) {
//
//        }

//        return 1/0;
//    }
}
