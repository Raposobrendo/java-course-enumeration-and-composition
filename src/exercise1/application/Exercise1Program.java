package exercise1.application;

import exercise1.entities.Department;
import exercise1.entities.HourContract;
import exercise1.entities.Worker;
import exercise1.entities.WorkerLevel;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;


public class Exercise1Program {
    public static void main(String[] Args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter ymFmt = DateTimeFormatter.ofPattern("MM/yyyy");

        String department, name;
        Double baseSalary;
        Integer quantityContracts;

        System.out.print("Enter department's name: ");
        department = sc.nextLine();

        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        name = sc.nextLine();

        System.out.print("Level (JUNIOR, MID_LEVEL, SENIOR): ");
        WorkerLevel level = WorkerLevel.valueOf(sc.nextLine().toUpperCase());

        System.out.print("Base salary: ");
        baseSalary = sc.nextDouble();

        System.out.print("How many contracts this worker have? ");
        quantityContracts = sc.nextInt();

        Worker worker = new Worker(name, level, baseSalary, new Department(department));

        for(int i = 0; i < quantityContracts; i++){
            sc.nextLine();
            System.out.printf("Enter contract #%d data\n", i+1);

            System.out.print("Date (DD/MM/YYYY): ");
            String dateStr = sc.nextLine();
            LocalDate date = LocalDate.parse(dateStr, fmt);

            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble();

            System.out.print("Duration (hours): ");
            Integer durationHours = sc.nextInt();

            HourContract contract = new HourContract(date, valuePerHour, durationHours);
            worker.addContract(contract);
        }

        sc.nextLine();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.nextLine();

        YearMonth ym = YearMonth.parse(monthAndYear, ymFmt);

        double income = worker.income(ym);

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getDepartment());
        System.out.println("Income for " + monthAndYear + " : " + String.format("%.2f", income));

        sc.close();
    }
}