class Main {
 public static void main(String[] args) {
   mystery(4);
 }

 public static void mystery(int n){
   if (n <= 0) {
     return;
   }
   for (int i = 0; i < n; i++){
     System.out.print("-");
   }
   for (int i = 0; i < n; i++){
     System.out.print("+");
   }
   System.out.println();

   mystery(n-1);
 }
}