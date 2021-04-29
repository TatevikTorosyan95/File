package service;

import model.Student;

public class StudentService {
    public Student[] create() {
        StudentConverter conv = new StudentConverter();
        String[][] array = conv.converter();

        Student[] students = new Student[array.length];
        for (int i = 0; i < array.length; i++) {
            students[i] = new Student();
            students[i].setFirstName(array[i][0]);
            students[i].setLastName(array[i][1]);
            students[i].setYear(Integer.parseInt(array[i][2]));
            students[i].setGender(array[i][3].charAt(0));
            students[i].setMark(Double.parseDouble(array[i][4]));
        }
        return students;
    }

    public void printFullNames(Student[] student) {
        for (int i = 0; i < student.length; i++) {
                System.out.println("Full name: " + student[i].getFirstName()  + " " + student[i].getLastName());
        }
    }

    public void printAllMaleStudents(Student[] student) {
        for (int i = 0; i < student.length; i++) {
            if (student[i].getGender() == 'm') {
                student[i].studentInfo();
            }
        }
    }

    public void printAllFemalesMarkGreater(Student[] student) {
        for (int i = 0; i < student.length; i++) {
            if (student[i].getGender() == 'f' && student[i].getMark() > 50.4) {
                student[i].studentInfo();
            }
        }
    }

    public void printMinMarkInfo(Student[] student) {
        Student min  = student[0];
        for (Student s : student) {
            if(min.getMark() > s.getMark()) {
                min = s;
            }
        }
        min.studentInfo();
    }

    public void printBiggestMaleInfo(Student[] student) {
        Student s = null;
        for (int i = 0; i < student.length; i++) {
            if (student[i].getGender() == 'm') {
                if (s == null) {
                    s = student[i];
                    continue;
                }

                if (s.getYear() > student[i].getYear())
                    s = student[i];

            }
        }
        s.studentInfo();
    }

    public void printSortedByMark(Student[] student) {
        boolean isActive = true;
        int count = 0;
        while (isActive) {
            isActive = false;
            for (int i = 0; i < student.length-1-count; i++) {
                if (student[i].getMark() > student[i+1].getMark()) {
                    Student temp = student[i];
                    student[i] = student[i+1];
                    student[i+1] = temp;
                    isActive = true;
                }
            }
            count++;
        }
        System.out.println(student);
    }

    public void printFemaleSortedByYear(Student[] student) {
        int count = 0;
        for (Student s : student) {
            if (s.getGender() == 'f') {
                count++;
            }
        }

        Student[] result = new Student[count];
        int index = 0;
        for (Student s : student) {
            if (s.getGender() == 'f') {
                result[index] = s;
                index++;
            }
        }

        boolean isActive = true;
        int counter = 0;
        while (isActive) {
            isActive = false;
            for (int i = 0; i < result.length-1-counter; i++) {
                if (result[i].getYear() > result[i+1].getYear()) {
                    Student temp = result[i];
                    result[i] = result[i+1];
                    result[i+1] = temp;
                    isActive = true;
                }
            }
            counter++;
        }

        for (Student s : result) {
            s.studentInfo();
        }
    }
}
