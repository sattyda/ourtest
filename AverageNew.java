package FunctionalP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Objects.isNull;

public class AverageNew {

    static  int threshold = 0;
    static  String lastGuy = "";
    static int lastCounter = 0;
    public static void main(String[] args) {

        ArrayList<String> studentsmorethan50 = new ArrayList<>();

        HashMap<Integer, Student> hashMap =  new HashMap<>();
        for (int i = 0; i < 100 ; i++){
            hashMap.put(i , getStudent());
        }

        Stream stream = hashMap.entrySet().stream();
        stream.forEach( o -> {
            Student student = (Student)(((Map.Entry)o).getValue());
            System.out.println(student.name + " , " + student.score);
        } );

//        stream = hashMap.entrySet().stream();
//
//
//        stream.filter( o -> {
//            Student student = (Student) (((Map.Entry) o).getValue());
//
//            return student.score >= 50;
//        }).forEach( o -> {
//            Student student = (Student) (((Map.Entry) o).getValue());
//            studentsmorethan50.add(student.name + " , " + student.score);
//        });
//
//        for (String str : studentsmorethan50) {
//            System.out.println(str);
//        }
//
        stream = hashMap.entrySet().stream();


        HashMap<Integer, Student> myToppers = new HashMap<>();
        myToppers.put(1 , new Student("def" , 0L, 0));
        myToppers.put(2 , new Student("def" , 0L, 0));
        myToppers.put(3 , new Student("def" , 0L, 0));

        stream.forEach(o -> {
            Student student = (Student) (((Map.Entry) o).getValue());
            if(student.score < myToppers.get(3).score){

            } else if( student.score >= myToppers.get(3).score &&  student.score < myToppers.get(2).score){
                myToppers.put(3 , student);
            }else if( student.score >= myToppers.get(2).score &&  student.score < myToppers.get(1).score){
                myToppers.put(3 , myToppers.get(2));
                myToppers.put(2 , student);

            } else if( student.score >= myToppers.get(1).score ){
                myToppers.put(3 , myToppers.get(2));
                myToppers.put(2 , myToppers.get(1));
                myToppers.put(1 , student);
            }
        });

        System.out.println("\n\n\n\n");

        for (Student student : myToppers.values()) {
            System.out.println(student.name + " , " + student.score);
        }


        stream = hashMap.entrySet().stream();


        int maxCounter = 10;
        ArrayList< String> lastStudents = new ArrayList<>();

//
//        stream.forEach(o -> {
//            Student student = (Student) (((Map.Entry) o).getValue());
//            if (lastCounter < maxCounter ) {
//                lastCounter++;
//                lastStudents.add(student.name);
//               if(student.score > threshold){
//                   threshold = student.score;
//                   lastGuy = student.name;
//               }
//            } else{
//                if(student.score < threshold){
////                    System.out.println(myBottoms.indexOf((String) lastGuy));
//
//                    threshold = student.score;
//                    lastStudents.remove( lastStudents.indexOf((String) lastGuy));
//                    lastStudents.add(student.name);
//                    lastGuy = student.name;
//
//                }
//            }
//        });

        for (String s: lastStudents
             ) {
            System.out.println(s);
        }

    }

    public static Student getStudent(){
        String ch = "abcdefghijklmnopqrstuvwxyz";
        String name = "";
        for (int i = 0 ; i < 6; i++){
            name = name + ch.charAt((int)(1+ Math.random()*24));
        }
        Long rollNumber = Student.myRoolls++;
        int score = (int)(0+ Math.random()*100);

        if(score == 0){
            return new Student(name, rollNumber);
        } else {
            return new Student(name, rollNumber, score);
        }
    }
}


class Student{
    public static Long myRoolls = 0L;
    String name;
    Long rollNumber;
    int score;
    Student( String name, Long rollNumber){
        this.name = name;
        this.rollNumber = rollNumber;
    }

    Student( String name, Long rollNumber , int score){
        this.name = name;
        this.rollNumber = rollNumber;
        this.score = score;
    }
}

/////// 1. all students with more than 50%
/////// 2. Top 3 Students
/////// 3. Students who did not appear for exam ///
//////  4. last 10% of student
//////  5. find 85th percentile

////// Inversion Of Control //
 
