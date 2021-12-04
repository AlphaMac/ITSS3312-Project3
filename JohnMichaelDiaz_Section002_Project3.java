import java.util.*;

import java.io.*;

public class JohnMichaelDiaz_Section002_Project3 {
	
	
	

	   
	    public static void main(String[] args) {
	    	
	    	 ArrayList<Student> studentArray = new ArrayList<Student>();
	    	 ArrayList<Course> courseArray = new ArrayList<Course>();
	    	 
	    	 while (true) {
		            
	    		 	Scanner allInputs = new Scanner(System.in);
		           
		            //Main Menu
		            System.out.println("--------Welcome to the Main Management System--------");
		            System.out.println("1.Student Management");
		            System.out.println("2.Course Management");
		            System.out.println("3.Exit");
		            System.out.println("Please enter your choice:");

			            switch (allInputs.next()) {
			            
		                case "1": //Student Management
		                	
		                	while (true) {
		        	            
		        	            System.out.println("--------Welcome to the Student Management System--------");
		        	            System.out.println("1.Add Students");
		        	            System.out.println("2.Modify Students");
		        	            System.out.println("3.View all students");
		        	            System.out.println("4.Search Students");
		        	            System.out.println("5.Display Student Job");
		        	            System.out.println("6.Sign out");
		        	            System.out.println("Please enter your choice:");

		        		            switch (allInputs.next()) {
		        	                case "1":
		        	                    System.out.println("Add Students");
		        	                    addStudent(studentArray);
		        	                    break;
		        	                case "2":
		        	                    System.out.println("Modify Students");
		        	                    updateStudent(studentArray);
		        	                    break;
		        	                case "3":
		        	                    System.out.println("View all students");
		        	                    printAllStudentsAndExport(studentArray);
		        	                    break;
		        	                case "4":
		        	                	System.out.println("Search Student");
		        	                	break;
		        	                case "5":
		        	                	System.out.println("Display Student Job");
		        	                	break;
		        	                case "6":
		        	                    
		        	                    break;
		        	            }
		        		        break;    
		        	        }
						case "2": //Course Management
							while (true) {
		        	            
		        	            System.out.println("--------Welcome to the Course Management System--------");
		        	            System.out.println("1.Add Course");
		        	            System.out.println("2.Assign Course to Students");
		        	            System.out.println("3.Sign out");
		        	            System.out.println("Please enter your choice:");

		        		            switch (allInputs.next()) {
		        	                case "1":
		        	                    System.out.println("Add Course");
		        	                    addCourse(courseArray);
		        	                    break;
		        	                case "2":
		        	                    System.out.println("Modify Students");
		        	                    courseStudentFileWrite(courseArray,studentArray);
		        	                    break;
		        	                case "3":
		        	                    
		        	                	//System.(0);
		        	                	break;
		        	            }
		        		            break;
		        	        }
						
		                default:
		                    System.out.println("Thank you for using the Management Modules!");
		                    
		                    System.exit(0);
		            }
	            
		        }
	        
	    }
	
	//Student Add
	public static void addStudent(ArrayList<Student>array){
		
		//Random Number Generator
		Random r = new Random();
		int randomInt = r.nextInt(100);
        
        Scanner allInputs = new Scanner(System.in);
        
        String id = String.valueOf(randomInt);
        System.out.println("Please enter the student first name:");
        String fName = allInputs.nextLine();
        System.out.println("Please enter the student last name:");
        String lName = allInputs.nextLine();
        System.out.println("Please enter the student's level:");
        String level = allInputs.nextLine();
        //Active status is active by default
        String active = "true";
        

       
        Student studentArray = new Student();
        studentArray.setid(id);
        studentArray.setfName(fName);
        studentArray.setlName(lName);
        studentArray.setLevel(level);
        studentArray.setActive(active);
      
        array.add(studentArray);

        System.out.println("Add Student Success!");
        

    }
	//Course Add
	public static void addCourse(ArrayList<Course>array){
        
        Scanner allInputs = new Scanner(System.in);
        System.out.println("Please enter a course number:");
        String cid = allInputs.nextLine();
        System.out.println("Please enter the course name:");
        String cName = allInputs.nextLine();
        
        Course courseArray = new Course();
        courseArray.setcid(cid);
        courseArray.setcName(cName);
      
        array.add(courseArray);

        System.out.println("Add Course Success!");
        

    }
	//Search Array
	public static void StudentSearch(ArrayList<Student>array){
        if(array.size()==0){
            System.out.println("No information, Please add information and query!");
            return;
        }
        Scanner allInputs = new Scanner(System.in);
        System.out.println("School Id\t First name\t Last name\t Level\t Active");
 
        for(int i=0;i< array.size();i++){
        	Student studentArray = array.get(allInputs.nextInt());
            System.out.println(studentArray.getid()+"\t"+studentArray.getfName()+"\t"+studentArray.getlName()+"\t"+studentArray.getLevel()+"\t"+studentArray.getActive());
        }
    
    }
	//Display Students and Export Students
	public static void printAllStudentsAndExport(ArrayList<Student>array){
        if(array.size()==0){
            System.out.println("No information, Please add information and query!");
            return;
        }
        
        System.out.println("School Id\t First name\t Last name\t Level\t Active");
       
    try {
        FileWriter export = new FileWriter("StudentReport.txt", true);
        for(int i=0;i< array.size();i++){
            Student studentArray = array.get(i);
            System.out.println(studentArray.getid()+"\t"+studentArray.getfName()+"\t"+studentArray.getlName()+"\t"+studentArray.getLevel()+"\t"+studentArray.getActive());
        export.write(studentArray.getid()+"\t"+studentArray.getfName()+"\t"+studentArray.getlName()+"\t"+studentArray.getLevel()+"\t"+studentArray.getActive() + "\n");
            }
            export.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }	
	//Assign Student to Course
	public static void courseStudentFileWrite(ArrayList<Course>array, ArrayList<Student>array1){
        if(array.size()==0){
            System.out.println("No information, Please add information and query!");
            return;
        }
        
        System.out.println("Student Id\t Course Id");
       
    try {
        FileWriter export = new FileWriter("CourseAssignment.txt", true);
        for(int i=0;i< array.size();i++){
            Course courseArray = array.get(i);
            Student studentArray = array1.get(i); 
            System.out.println(studentArray.getid()+"\t"+ courseArray.getcid());
        export.write(studentArray.getid()+"\t"+courseArray.getcid()+ "\n");
            }
            export.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
	//Edit Student
	public static void updateStudent(ArrayList<Student>array){
        
        Scanner allInputs = new Scanner(System.in);
        System.out.println("Please enter the student number to be modified:");
        String id = allInputs.nextLine();

       
        System.out.println("Please enter the new first name of the student:");
        String fName = allInputs.nextLine();
        System.out.println("Please enter the new last name of the student:");
        String lName = allInputs.nextLine();
        System.out.println("Please enter the new level for the student:");
        String level = allInputs.nextLine();
        System.out.println("Please enter the new activity status for the student:");
        String active = allInputs.nextLine();

        Student studentArray = new Student();
        studentArray.setid(id);
        studentArray.setfName(fName);
        studentArray.setlName(lName);
        studentArray.setLevel(level);
        studentArray.setActive(active);

        
        for(int i=0;i<array.size();i++){
            Student student = array.get(i);
            if(student.getid().equals(id)){
                array.set(i,studentArray);
                break;
            }
        }
        
        System.out.println("Successfully modified!");
        

    }
	//Student Class
	public static class Student {
		
	    private String id;
	    private String fName;
	    private String lName;
	    private String level;
	    private String active;
	    //Construct method
	    public Student() {
	    }
	    //Construct for parameters
	    public Student(String id, String fName, String lName, String level, String active) {//Hold down Shift Select All Construct Method with Four Parameters
	        this.id = id;
	        this.fName = fName;
	        this.lName = lName;
	        this.level = level;
	        this.active = active;
	    }
	   
	    public String getid() {
	        return id;
	    }

	    public String getfName() {
	        return fName;
	    }

	    public String getlName() {
	        return lName;
	    }

	    public String getLevel() {
	        return level;
	    }
	    
	    public String getActive() {
	        return active;
	    }

	    public void setid(String id) {
	        this.id = id;
	    }

	    public void setfName(String fName) {
	        this.fName = fName;
	    }

	    public void setlName(String lName) {
	        this.lName = lName;
	    }

	    public void setLevel(String level) {
	        this.level = level;
	    }
	    
	    public void setActive(String active) {
	        this.active = active;
	    }
	}
	//Student_Employee Subclass
	
	public class Student_Employee extends Student{
		
		private String employment;
	    private String job;
	    public Student_Employee() {
	    }
		public String getEmployment() {
			return employment;
		}
		public String job() {
			return job;
		}
		public void setEmployment(String employment) {
			this.employment = employment;
		}
		public void setJob(String job) {
			this.job = job;
		}
	}
	//Course Class

	public static class Course {
	    private String cid;
	    private String cName;
	    public Course() {
	    }
	    //Construct for parameters
	    public Course(String cid, String cName) {
	        this.cid = cid;
	        this.cName = cName;
	    }
	    
	    public String getcid() {
	        return cid;
	    }

	    public String getcourse() {
	        return cName;
	    }

	    public void setcid(String cid) {
	        this.cid = cid;
	    }

	    public void setcName(String cName) {
	        this.cName = cName;
	    }

	}
}