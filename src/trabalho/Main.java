package trabalho;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Work;
import entities.enums.WorkLevel;

public class Main {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		//departamento
		System.out.print("Entre department's name ");
		String dep = sc.next();
		
		//nome 
		System.out.print("Nome :");
		String names = sc.next();
		//level
		System.out.print("Level :");
		String levelS = sc.next();
		WorkLevel level = WorkLevel.valueOf(levelS);
		//valor 
		System.out.print("valor :");
		double valor = sc.nextDouble();
		
		Work work = new Work(names,level,valor,new Department(dep));
		
		System.out.print("How many contracts to this workwe ? ");
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			
			System.out.printf("Entry contract #%d data\n",i+1);
			//contrato
			//Data
			SimpleDateFormat smf1 = new SimpleDateFormat("dd/MM/yyyy");
			System.out.print("Date (DD/MM/YYYY) :");
			Date date = smf1.parse(sc.next());
			String fdate = smf1.format(date);
			System.out.println(fdate);
			
			//valor
			System.out.print("Valuer per Hour :");
			double valH = sc.nextDouble();
			
			//hour
			System.out.print("Duration (Hour) :");
			int durH = sc.nextInt();
			
			
			work.addContract(new HourContract(date,valH,durH));
		}
		//consulta
		SimpleDateFormat smf2 = new SimpleDateFormat("MM/yyyy");
		System.out.print("Entre Month amn year to Calculate income (MM/YYYY) :");
		Date date2 = smf2.parse(sc.next());
		String dt = smf2.format(date2);
		//converter Date para inteiro 
		Calendar cal = Calendar.getInstance();
		cal.setTime(date2);
		int month = 1 + cal.get(Calendar.MONTH);//convertendo para month
		int year = cal.get(Calendar.YEAR);//convertendo para year
		double income = work.income(year,month);//metodo da classe Work	
		
		System.out.println("Name :"+work.getName());
		System.out.println("Departament: "+work.getDepartment().getName());
		System.out.println("income for "+dt+":  "+(income+work.getBaseSalary()));
		sc.close();

	}

}
