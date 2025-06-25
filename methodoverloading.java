public class methodoverloading {
    int add(int a,int b){
        return a+b;
    }
    int sub(int a, int b){
        return a-b;
    }
    int mul(int a, int b){
        return a*b;
    }
    int mod(int a, int b){
        return a/b;
    }
    int div(int a,int b){
        if(b==0) {
            System.out.println("error");
            return 0;
        }
        return a%b;
    }

    public static void main(String[] args) {
        methodoverloading s=new methodoverloading();
        System.out.println(s.add(5,10));
        System.out.println(s.sub(3,2));
        System.out.println(s.mul(3,2));
        System.out.println(s.mod(6,2));
        System.out.println(s.div(8,0));
    }
}

