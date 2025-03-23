package Exceptions;

import ChainingConstructors.C;

import java.sql.SQLException;

public class Client {
    public static void main(String[] args) throws EvenNumberException {
        Student s1 = new Student();
        try{
            s1.findStudentByRollNo(40);
        }catch (ClassNotFoundException e){

        }catch (EvenNumberException e){
            System.out.println("even number exception");
            throw new EvenNumberException();

        }catch (SQLException e){
            System.out.println("Sql Error");
        }finally {
//            always executed irrespective of exception happens or not
            System.out.println("I am inside finally block");
//            mainly used to clean up things
//            close opened connections

        }
        System.out.println("I am out");

//        called method throwing exception

    }
}
