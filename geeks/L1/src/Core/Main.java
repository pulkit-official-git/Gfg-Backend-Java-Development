package Core;

public class Main {
    public Main (){

    }
    public Main(int x){
        System.out.println(x);
    }
    private int x;
    public void setX(int x){
        this.x = x;
    }
    public static void main(String[] args) {

        Main main = new Main();
        System.out.println("Hello world!"+main);
    }
}

