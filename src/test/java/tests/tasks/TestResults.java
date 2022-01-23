//package tests;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class TestResults {
//    public static class Student {
//        private String name;
//        private int score;
//
//        public Student(String name, int score) {
//            this.name = name;
//            this.score = score;
//        }
//
//        public int getScore() {
//            return score;
//        }
//
//        public String getName() {
//            return name;
//        }
//    }
//
//    public static List<String> studentsThatPass(Stream<Student> students, int passingScore) {
//        return students.filter(i -> i.getScore() >= passingScore)
//                .map(Student::getName)
//                .sorted(Comparator.reverseOrder())
//                .collect(Collectors.toList());
//    }
//
//    public static void main(String[] args) {
//        List<Student> students = new ArrayList<Student>();
//        students.add(new Student("Mike", 80));
//        students.add(new Student("James", 57));
//        students.add(new Student("Alan", 21));
//
//        studentsThatPass(students.stream(), 21).forEach(System.out::println);
//    }
//}
