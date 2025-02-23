package CollectionsL3;

import CollectionsInterface.PaymentStatus;

import java.util.*;

public class Client {

    public static void main(String[] args) {
        List<String>l1 = new ArrayList<String>();
        l1.add("khan");
        l1.add("sai");
        l1.add("harsh");
        l1.add("purvi");
        System.out.println(l1);
        List<String>l2=new LinkedList<>();
        List<String>l3=new Vector<>();
        List<String>l4=new Stack<>();

        Set<String>s1 = new HashSet<>();
        s1.add("khan");
        s1.add("sai");
        s1.add("harsh");
        s1.add("purvi");
        System.out.println(s1);

        Set<String>s2=new TreeSet<>();
        s2.add("khan");
        s2.add("sai");
        s2.add("harsh");
        s2.add("purvi");
        System.out.println(s2);

        Set<String>s3=new LinkedHashSet<>();
        s3.add("khan");
        s3.add("sai");
        s3.add("harsh");
        s3.add("purvi");
        System.out.println(s3);

        Payment p1 = new Payment();
        p1.paymentStatus= PaymentStatus.APPROVED;
        Payment p2 = new Payment();
        p2.paymentStatus=PaymentStatus.FAILED;
        Payment p3 = new Payment();
        p3.paymentStatus=PaymentStatus.PENDING;
        Payment p4 = new Payment();
        p4.paymentStatus=PaymentStatus.APPROVED;

//        EnumSet<PaymentStatus>E1 = EnumSet.of(PaymentStatus.APPROVED,PaymentStatus.PENDING);
        EnumSet<PaymentStatus>E2 = EnumSet.allOf(PaymentStatus.class);

        Queue<String>q = new LinkedList<>();

        q.add("khan");
        q.add("sai");
        q.add("harsh");
        q.add("purvi");
        System.out.println(q.peek());
        System.out.println(q.poll());


        Queue<String> q2 =  new PriorityQueue<>();
        q2.add("khan");
        q2.add("sai");
        q2.add("harsh");
        q2.add("purvi");
        System.out.println(q2);

        Collections.sort(l1,new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(l1);

        List<Student> lt = new ArrayList<Student>();
        lt.add(new Student(1,80,25,"harsh"));
        lt.add(new Student(2,70,25,"xy"));
        lt.add(new Student(3,90,25,"yz"));
        lt.add(new Student(4,50,25,"ln"));

        Collections.sort(lt,new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                if(o1.score<o2.score){
                    return 1;
                }
                else {
                    return -1;
                }
            }
        });
//        System.out.println(lt);
        for(Student s:lt){
            System.out.println(s.id+" "+s.name+" "+s.score);
        }





    }


}
