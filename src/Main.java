import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    private static <T extends Comparable<T>> void mergeSort(ArrayList<T> list, int low, int high) {

    }

    private static ArrayList<Student> readStudents() {
        ArrayList<Student> listStud = new ArrayList<>();
        try (Scanner scan = new Scanner(new File("students.txt"))) {
            while (scan.hasNext()) {
                listStud.add(new Student(scan.next(), scan.next(), scan.nextInt(), scan.nextDouble()));
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return listStud;
    }

    public static void main(String[] args) {
        ArrayList<Student> listStud = readStudents();
        System.out.println(listStud);
        Collections.sort(listStud);
        System.out.println(listStud);

        listStud = readStudents();
        System.out.println(listStud);
        listStud.sort(new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                return Double.valueOf(o2.getAverage()).compareTo(Double.valueOf(o1.getAverage()));
            }
        });
        System.out.println(listStud);

        listStud = readStudents();
        mergeSort(listStud, 0, listStud.size());

    }
}
