import java.util.Scanner;
 public class Student_grades{
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        int subjects;
        char grade='d';
        double average;
        double total=0;
        System.out.println("enter number of subjects for a student");
        subjects = sc.nextInt();
        
        int marks[] = new int[subjects];// creation of array for maarks entering
         for(int i=0; i < subjects; i++){
            System.out.println("Enter marks for subject " + (i+1) + ":");
            marks[i] = sc.nextInt();
            total += marks[i];
         }
         average = total / subjects;
          if(average >= 90){
            System.out.println(grade = 'A');
          }
          else if (average >=80){
             System.out.println(grade = 'B');
          }
          else if(average >= 70){
             System.out.println(grade = 'c');
          }
          else if(average >= 60){
             System.out.println(grade = 'D');
          }
          else if(average >= 50){
             System.out.println(grade = 'E');
          }
          else{
             System.out.println("fail");
          }
          System.out.println("\n total marks = "+total);
          System.out.println("avaerage percentage = "+average+ "%");
          System.out.println("grade = " + grade);
          sc.close();

    }
 }