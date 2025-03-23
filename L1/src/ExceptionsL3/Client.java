package ExceptionsL3;


import java.sql.SQLException;

public class Client {

    public static void main(String[] args) throws EvenException {
        Student s1 = new Student();
        try{
            s1.findStudentById(6);
        }catch (EvenException e){
            System.out.println("Even Exception");
            throw new EvenException();
        }catch (SQLException e){

            System.out.println("SQL Exception");
        }catch (ClassNotFoundException e){
            System.out.println("Class Exception");
        }finally {
            System.out.println("reached in finally");
        }
        System.out.println("I am out of finally");


    }
}
