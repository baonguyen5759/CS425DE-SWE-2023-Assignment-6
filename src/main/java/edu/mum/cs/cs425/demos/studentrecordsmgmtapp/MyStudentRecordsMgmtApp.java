package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

public class MyStudentRecordsMgmtApp {


    public static void main(String[] args) {
        Student[] students = new Student[6];
        students[0] = new Student(110001, "Dave", LocalDate.of(1945, Month.NOVEMBER, 18));
        students[1] = new Student(110002, "Anna", LocalDate.of(1990, Month.DECEMBER, 7));
        students[2] = new Student(110003, "Erica", LocalDate.of(1974, Month.JANUARY, 31));
        students[3] = new Student(110004, "Carlos", LocalDate.of(2009, Month.AUGUST, 22));
        students[4] = new Student(110005, "Bob", LocalDate.of(1990, Month.APRIL, 10));
        students[5] = new Student(110006, "Peter", LocalDate.of(2000, Month.MARCH, 5));

        System.out.println("===== 1. List of students =====");
        printListOfStudents(students);

        System.out.println("\n===== 2. List Of Platinum-Alumni Students =====");
        List<Student> platinumAlumniStudents = getListOfPlatinumAlumniStudents(students);
        platinumAlumniStudents.forEach(System.out::println);

        System.out.print("\n===== 3. int array is { 275, 157, 204, 103, 243, 244, 5, 60, 46, 6, 25, 3, 280, 275, 275, 282, 259, 189, 287, 132, 37, 195, 88, 222, 40, 293, 246, 166, 235 }");
        int[] arrInt = {275, 157, 204, 103, 243, 244, 5, 60, 46, 6, 25, 3, 280, 275, 275, 282, 259, 189, 287, 132, 37, 195, 88, 222, 40, 293, 246, 166, 235};

        System.out.println("\n\n=== 3.1 printHelloWorld ===");
        printHelloWorld(arrInt);

        System.out.println();
        System.out.println("=== 3.2  findSecondBiggest === ");
        int secondBiggest = findSecondBiggest(arrInt);
        System.out.println("Second biggest: " + secondBiggest);
    }

    static void printListOfStudents(Student[] students) {
        Arrays.sort(students, Comparator.comparing(Student::getName));
        Stream.of(students).forEach(System.out::println);
    }

    static List<Student> getListOfPlatinumAlumniStudents(Student[] students) {
        return Arrays.stream(students).filter(Student::isPlatinumAlumni).sorted(Comparator.comparing(Student::getDateOfAdmission).reversed()).collect(Collectors.toList());
    }

    static void printHelloWorld(int[] numbers) {
        for (int number : numbers) {
            boolean hasVal = false;
            if (number % 5 == 0) {
                System.out.print("Hello");
                hasVal = true;
            }

            if (number % 7 == 0) {
                System.out.print("World");
                hasVal = true;
            }

            if (hasVal) {
                System.out.println(" " + number);
            }
        }
    }

    /// This method assumes that numbers has more than or equal 2 elements
    static int findSecondBiggest(int[] numbers) {
        if (numbers.length == 2) {
            return Math.min(numbers[0], numbers[1]);
        } else {
            int secondBiggest = Math.min(numbers[0], numbers[1]);
            int biggest = Math.max(numbers[0], numbers[1]);

            for (int i = 2; i < numbers.length; i++) {
                int number = numbers[i];

                if (number > biggest) {
                    secondBiggest = biggest;
                    biggest = number;
                } else {
                    secondBiggest = Math.max(secondBiggest, number);
                }
            }
            return secondBiggest;
        }
    }
}