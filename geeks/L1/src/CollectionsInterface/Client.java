package CollectionsInterface;

import java.util.*;

public class Client {
    public static void main(String[] args) {
        List<String>l1 = new ArrayList<String>();
        l1.add("khan");
        l1.add("harsh");
        l1.add("atri");
        l1.add("sai");
        System.out.println(l1);
        List<String>l2 = new LinkedList<String>();
        List<String>l3 = new Vector<>();
        List<String>l4 = new Stack<>();



        Set<String>s1=new HashSet<>();
        s1.add("khan");
        s1.add("harsh");
        s1.add("atri");
        s1.add("sai");
        System.out.println(s1);
        Set<String>s2=new TreeSet<>();
        s2.add("khan");
        s2.add("harsh");
        s2.add("atri");
        s2.add("sai");
        System.out.println(s2);
        Set<String>s3=new LinkedHashSet<>();
        s3.add("khan");
        s3.add("harsh");
        s3.add("atri");
        s3.add("sai");
        System.out.println(s3);
//        Set<String>s4=new EnumSet<>();


        Payment p1 = new Payment();
        p1.paymentStatus=PaymentStatus.APPROVED;
//        Payment p2 = new Payment();
//        p2.paymentStatus="Declined";
//        Payment p3 = new Payment();
//        p3.paymentStatus="In Process";
//        Payment p4 = new Payment();
//        p4.paymentStatus="I will not give";
//        Payment p5 = new Payment();
//        p5.paymentStatus="Which money";
        List<PaymentStatus>lps=List.of(PaymentStatus.FAILED, PaymentStatus.APPROVED, PaymentStatus.REJECTED);
        Set<PaymentStatus>sps=EnumSet.of(PaymentStatus.APPROVED, PaymentStatus.REJECTED, PaymentStatus.FAILED);
        Set<PaymentStatus>sps2=EnumSet.allOf(PaymentStatus.class);

        Queue<Integer> queue = new LinkedList<>(); // FIFO Queue

        // Enqueue (add elements)
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);

        System.out.println("Queue: " + queue);
        System.out.println(queue.peek());

        // Dequeue (remove elements in FIFO order)
        System.out.println("Removed: " + queue.poll()); // Removes 10
        System.out.println("Removed: " + queue.poll()); // Removes 20

        System.out.println("Queue after removal: " + queue);

        Queue<String> q1 = new PriorityQueue<>();
        q1.add("khan");
        q1.add("harsh");
        q1.add("atri");
        q1.add("sai");
        System.out.println("++++++++");
        System.out.println(q1);

        Collections.sort(l1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(l1);

        List<Student>l = new ArrayList<>();
        l.add(new Student(1,90,"rohan",91));
        l.add(new Student(2,80,"khan",92));
        l.add(new Student(3,70,"sai",93));
        Collections.sort(l,new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                if(o1.marks<o2.marks){
                    return -1;
                }else if(o1.marks>o2.marks){
                    return 1;
                }
                else return 0;
            }
        });
        System.out.println(l);
        for (Student s : l) {
            System.out.println(s.id + " "+s.marks);
        }


    }
}
