public class TypeCasting {
    public static void main(String[] args) {
        // implicit 
         //byte to int
         byte byteValue=10;
         int intValue=byteValue;
         System.out.println("byte to int:"+intValue);
         //int to long
         long longValue=intValue;
         System.out.println("int to long:"+longValue);
         //long to float
         float floatValue=longValue;
         System.out.println("long to float:"+floatValue);
         //float to double
         double doubleValue=floatValue;
         System.out.println("float to double:"+doubleValue);
         //explicit 
         double doubleVar=9.78;
        float floatVar=(float)doubleVar;
        System.out.println("double to float:"+floatVar);
        long longVar=(long)floatVar;
        System.out.println("float to long:"+longVar);
        int intVar=(int)longVar;
        System.out.println("long to int:"+intVar);
        int largeIntVar=130;
        byte byteVar=(byte)largeIntVar;
        System.out.println("int to byte:"+byteVar);
    }
    
}
