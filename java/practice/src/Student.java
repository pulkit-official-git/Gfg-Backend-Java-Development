public class Student {
    private String name;
    private double psp;
    private String batchName;
    private String email;
    private StudentStatus status;

    public Student(String name, double psp, String batchName, String email, StudentStatus status) {

        if(0>psp || psp>100){
            throw new IllegalArgumentException("psp must be between 0 and 100");
        }
        this.name = name;
        this.psp = psp;
        this.batchName = batchName;
        this.email = email;
        this.status = StudentStatus.ACTIVE;
    }

    public void changeStatus(StudentStatus status){
        this.status = status;
    }
}
