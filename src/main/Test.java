package main;

import model.Student;
import service.StudentService;

public class Test {
    public static void main(String[] args) {
//        FileService.createFolder("lesson\\java");
//        FileService.createFile("lesson\\java","java.txt");
//        FileService.write("lesson\\java\\java.txt", "Hayk,Arabyan,1998,m,77.5\nAni,Babayan,1980,f,47.5\nKarine,Vancyan,2000,f,87.5");

        StudentService service = new StudentService();
        Student[] students = service.create();

        System.out.println("Task1");
        service.printFullNames(students);

        System.out.println("Task2");
        service.printAllMaleStudents(students);

        System.out.println("Task3");
        service.printAllFemalesMarkGreater(students);

        System.out.println("Task4");
        service.printMinMarkInfo(students);

        System.out.println("Task5");
        service.printBiggestMaleInfo(students);

        System.out.println("Task6");
        service.printSortedByMark(students);

        System.out.println("Task7");
        service.printFemaleSortedByYear(students);

    }
}
