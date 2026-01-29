


import java.util.*;
class Hostel{
    Scanner sc=new Scanner(System.in);

    String name;
    int age;
    String contact;
    int roomNumber;
    int studentId;
    static int count;
    static int sfcount;
    double amount;
    String position;
    int stafid;
    String newContact;
    double feePaid=0;
    double totalFee=11000;

}




//Student Management:-
class Student extends Hostel{

    void set() {
        System.out.println("Enter Strudent's Name:-");
        name = sc.nextLine();
        System.out.println("Enter Student's Age:-");
        age = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Student's contact:-");
        contact = sc.nextLine();

        System.out.println("Student's ID is set as:-"+(count+1));
        studentId = count+1;
        System.out.println("Student's Room Number is set as:-"+(studentId+100));
        roomNumber = studentId+100;
        System.out.println();
    }


    void get() {
        System.out.println();
        System.out.println("Student's Name: " + name);
        System.out.println("Student's Age: " + age);
        System.out.println("Student's Contact: " + contact);
        System.out.println("Students Room Number: " + roomNumber);
        System.out.println("Student's ID: " + studentId);
    }


    void getStudentDetails(Student[] inf) {
        System.out.println("DETAILS ABOUTE STUDENTS:-");
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                inf[i].get();
            }
        } else {
            System.out.println("There are zero Students in Hostel.");
        }
    }


    void addStudent(Student[] inf) {
        if (count < 50) {
            Student inf1 = new Student();
            inf1.set();
            for (int i = 0; i < count; i++) {
                if (inf[i].roomNumber==inf1.roomNumber) {
                    System.out.println("Student have already been living in that Room.");
                    System.out.println("You can not have room number." + inf1.roomNumber);
                    return;
                }
            }
            inf[count] = inf1;
            count++;
        } else {
            System.out.println("Hostel is full.\n" + "You can not Add more Student.");
        }
    }



    void removeStudent(Student[] inf) {
        if (count > 0) {
            System.out.println("Enter the Student ID of the Student you want to remove :");
            int sStudentId = sc.nextInt();
            boolean check = false;
            for (int i = 0; i < count; i++) {
                if (inf[i].studentId == sStudentId) {
                    for (int j = i; j < count; j++) {
                        inf[j] = inf[j + 1];
                    }
                    count --;
                    check = true;
                    break;
                }
            }
            if (check == false) {
                System.out.println("Student is not found!");
                System.out.println();
            } else {
                System.out.println("Student has been removed successfully.");
            }
        } else {
            System.out.println("There are no Students in hostel to remove.");
        }
    }


    void updateStudentDetails(Student[] inf) {
        if (count > 0) {
            System.out.println("Enter the Student id of the Student Who you want to change details of:");
            int sStudentId = sc.nextInt();
            boolean check = false;
            for (int i = 0; i < count; i++) {
                if (inf[i].studentId == sStudentId) {
                    System.out.println("Enter the Student's new Name:");
                    sc.nextLine();
                    String nName = sc.nextLine();
                    System.out.println("Enter Student's new Age:-");
                    int nage = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Student's new contact:-");
                    String ncontact = sc.nextLine();
                    System.out.println("Enter Student's new ID(1 to 50):-");
                    int nstudentId = sc.nextInt();

                    if((nstudentId<0)||(nstudentId>50)){
                        System.out.println("You have entered wrong Student Id\nPlease try again");
                        return;
                    }
                    System.out.println("Student's new Room Number :-"+(nstudentId+100));
                    int nroomNumber =nstudentId+100;

                    inf[i].name = nName;
                    inf[i].age = nage;
                    inf[i].contact = ncontact;
                    inf[i].studentId = nstudentId;
                    inf[i].roomNumber=nroomNumber;
                    check = true;
                    break;
                }
            }
            if (check == false) {
                System.out.println("Student is not found.");
            } else {
                System.out.println("Student's detail is edited Succesfully");
            }
        } else {
            System.out.println("There are no Student in Hostel to Update details.");
        }
    }


    void searchByStudentName(Student[] inf) {
        if (count > 0) {
            System.out.println("Enter the Name of Student you want to search:");

            String sName = sc.nextLine();
            boolean check = false;
            for (int i = 0; i < count; i++) {
                if (inf[i].name.equalsIgnoreCase(sName)) {
                    System.out.println("The Student is Found!");
                    inf[i].get();
                    check = true;
                    break;
                }
            }
            if (check == false) {
                System.out.println("Student is not found!");
            }
        } else {
            System.out.println("There are zero Student in Hostel.");
        }
    }



    void shortByStudentId(Student[] inf) {
        if (count > 1) {
            Student temp = new Student();
            for (int i = 0; i < count; i++) {
                for (int j = i + 1; j < count; j++) {
                    if (inf[i].studentId > inf[j].studentId) {
                        temp = inf[i];
                        inf[i] = inf[j];
                        inf[j] = temp;
                    }
                }
            }
            System.out.println("Student's are shorted successfully.");
        } else {
            System.out.println("Shorting is not required.");
            System.out.println("Because there is only one Student in Hostel.");
        }
    }
}





//STAFF MANAGEMENT
class Staff extends Hostel{

    Scanner sc=new Scanner(System.in);

    void set1(){
        System.out.println("Enter Staff's Name:-");
        name=sc.nextLine();
        System.out.println("Enter Staff's Age:-");
        age=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Staff's contact:-");
        contact=sc.nextLine();
        System.out.println("Enter Staff's position:-");
        position=sc.nextLine();
    }


    void get1(){

        System.out.println();
        System.out.println("Staff's Name: "+name);
        System.out.println("Staff's Age: "+age);
        System.out.println("Staff's Contact: "+contact);
        System.out.println("Staff's Position Number: "+position);

    }


    void getStaffDetails(Staff[] stinf){

        System.out.println("DETAILS ABOUTE Staff:-");
        if(sfcount>0) {
            for(int i=0;i<sfcount;i++){
                stinf[i].get1();
            }
        }
        else{
            System.out.println("There are zero Staff in Hostel.");
        }

    }


    void addStaff(Staff[] stinf){

        if(count<50){
            Staff stinf1=new Staff();
            stinf1.set1();
            for (int i = 0; i <sfcount; i++) {
                if(stinf[i].contact.equalsIgnoreCase(stinf1.contact)){
                    System.out.println("Staff already exist.");
                    System.out.println("You can not add '"+stinf[i].name+"' To Staff");
                    return;
                }
            }
            stinf[sfcount] = stinf1;
            sfcount++;
        }
        else{
            System.out.println("Hostel have full Staff.\n"+"You can not Add more Staff.");
        }

    }



    void removeStaff(Staff[] stinf){
        if(sfcount>0){
            System.out.println("Enter the Staff's Name that you want to remove :");

            String sName=sc.nextLine();
            boolean check=false;
            for(int i=0;i<sfcount;i++){
                if(stinf[i].name.equalsIgnoreCase(sName)){
                    for(int j=i;j<sfcount;j++){
                        stinf[j]=stinf[j+1];
                    }
                    sfcount --;
                    check=true;
                    break;
                }
            }
            if(check==false){
                System.out.println("Staff is not found!");
                System.out.println();
            }
            else{
                System.out.println("Staff has been removed successfully.");
            }
        }
        else{
            System.out.println("There are no Staff in hostel to remove.");
        }
    }

    void updateStaffDetails(Staff[] stinf){
        if(sfcount>0){
            System.out.println("Enter the Staff's' Name That you want to Update:");
            String sName=sc.nextLine();
            boolean check=false;
            for(int i=0;i<sfcount;i++){
                if(stinf[i].name.equalsIgnoreCase(sName)){
                    System.out.println("Enter the Staff's new Name:");
                    sc.nextLine();
                    String nName=sc.nextLine();
                    System.out.println("Enter Staff's new Age:-");
                    int nage=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Staff's new contact:-");
                    String ncontact=sc.nextLine();
                    System.out.println("Enter Staff's new Position");
                    String nPosition=sc.nextLine();

                    stinf[i].name=nName;
                    stinf[i].age=nage;
                    stinf[i].contact=ncontact;
                    stinf[i].position=nPosition;
                    check=true;
                    break;
                }
            }
            if(check==false){
                System.out.println("Staff is not found.");
            }
            else{
                System.out.println("Staff's detail is edited Succesfully");
            }
        }
        else{
            System.out.println("There are no Staff in Hostel to Update details.");
        }
    }
}

//**Room Management**
class RoomManagement extends Hostel {
    Scanner sc = new Scanner(System.in);


    void allocateRoomToStudent(Student[] inf) {
        if (count>0) {
            System.out.println("Enter Student ID to allocate room:");
            int id = sc.nextInt();
            boolean crn=true;
            for (int i = 0; i < count; i++) {
                if (inf[i].studentId == id) {
                    System.out.println("Enter the Room number you want to allocate (from 101 to 150):-");
                    int nrNumber=sc.nextInt();
                    if((nrNumber<101)||(nrNumber>150)){
                        System.out.println("you have entered the wrong room Number\nPlease try again");
                        return;
                    }
                    if(nrNumber==inf[i].roomNumber){
                        System.out.println("Room is already occupied.");
                        System.out.println("you can not allocate this room to some one");
                        return;
                    }
                    inf[i].roomNumber=nrNumber;
                    inf[i].studentId=nrNumber-100;
                    crn=false;
                    System.out.println("Student's Id is also changed");
                    System.out.println("Room allocated successfully");
                }
            }
            if(crn==true){
                System.out.println("Student not found");
            }
        }
        else{
            System.out.println("There is not student in Hostel to allocate room");
        }

        if(count>51) {
            System.out.println("No rooms available for allocation.");
        }
    }


    void vacantRoom(Student[] inf){
        if(count>0){
            System.out.println("Enter the room number you want to vacant");
            int nrn=sc.nextInt();
            boolean check=false;
            for(int i=0;i<count;i++){
                if(inf[i].roomNumber==nrn){
                    for(int j=i;j<count;j++){
                        inf[j]=inf[j+1];
                    }
                    count --;
                    check=true;
                    break;
                }
            }
            if(check==false){
                System.out.println("room not found!\n OR");
                System.out.println("Room is Already vacant");
                System.out.println();
            }
            else{
                System.out.println("room has been vacant successfully.");
            }
        }
        else{
            System.out.println("All the rooms are vacant");
        }
    }

    void checkRoomAvailability(Student[] inf) {
        System.out.println("Enter the Room number to check availability (from 101 to 150):");
        int roomNumber = sc.nextInt();
        if (roomNumber < 101 || roomNumber > 150) {
            System.out.println("Invalid room number.");
            return;
        }
        for (int i = 0; i < count; i++) {
            if (inf[i].roomNumber == roomNumber) {
                System.out.println("Room " + roomNumber + " is occupied.");
                return;
            }
        }
        System.out.println("Room " + roomNumber + " is available.");
    }

    void listOccupiedRooms(Student[] inf) {
        System.out.println("List of occupied rooms:");
        boolean found = false;
        for (int i = 0; i < count; i++) {
            System.out.println("Room Number: " + inf[i].roomNumber + " | Student ID: " + inf[i].studentId);
            found = true;
        }
        if (found==false) {
            System.out.println("No rooms are currently occupied.");
        }
    }

    void listAvailableRooms(Student[] inf) {
        System.out.println("List of available rooms:");
        boolean check=false;
        for (int i = 101; i <= 150; i++) {
            for(int j=0;j<count;j++){
                if (inf[j].roomNumber == i) {
                    System.out.println("\t\t\t\tRoom"+i+"is occupied.");
                    check=true;
                }
                else{
                    System.out.println("Room"+i+"is available.");
                }
            }
        }
        if(check==false){
            System.out.println("All the room are available.");
        }
    }
}



// **Fee Management**
class FeeManagement extends Hostel{
    Scanner sc = new Scanner(System.in);


    void payFees(Student[] inf) {
        System.out.println("Enter Student ID to pay fees:");
        int id = sc.nextInt();
        boolean found = false;

        for (int i = 0; i < Student.count; i++) {
            if (inf[i].studentId == id) {
                System.out.println("Enter amount to pay:");
                double amount = sc.nextDouble();

                if (amount <= (inf[i].totalFee - inf[i].feePaid)) {
                    inf[i].feePaid += amount;
                    System.out.println("Payment successful! " + amount + " paid.");
                } else {
                    System.out.println("Amount exceeds due fees!");
                }
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }


    void checkDueFees(Student[] inf) {
        System.out.println("Enter Student ID to check due fees:");
        int id = sc.nextInt();
        boolean found = false;

        for (int i = 0; i < Student.count; i++) {
            if (inf[i].studentId == id) {
                System.out.println("Student Name: " + inf[i].name);
                System.out.println("Total Fees: " + inf[i].totalFee);
                System.out.println("Paid Fees: " + inf[i].feePaid);
                System.out.println("Due Fees: " + (inf[i].totalFee - inf[i].feePaid));
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }


    void generateFeesReceipt(Student[] inf) {
        System.out.println("Enter Student ID to generate receipt:");
        int id = sc.nextInt();
        boolean found = false;

        for (int i = 0; i < Student.count; i++) {
            if (inf[i].studentId == id) {
                System.out.println("\n===== FEE RECEIPT =====");
                System.out.println("Student Name: " + inf[i].name);
                System.out.println("Student ID: " + inf[i].studentId);
                System.out.println("Total Fees: " + inf[i].totalFee);
                System.out.println("Paid Fees: " + inf[i].feePaid);
                System.out.println("Due Fees: " + (inf[i].totalFee - inf[i].feePaid));
                System.out.println("========================");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }


    void displayFees(Student[] inf) {
        System.out.println("\n=== Fee Details for All Students ===");
        if (Student.count == 0) {
            System.out.println("No students available.");
            return;
        }

        for (int i = 0; i < Student.count; i++) {
            System.out.println("\nStudent Name: " + inf[i].name);
            System.out.println("Student ID: " + inf[i].studentId);
            System.out.println("Total Fees: " + inf[i].totalFee);
            System.out.println("Paid Fees: " + inf[i].feePaid);
            System.out.println("Due Fees: " + (inf[i].totalFee - inf[i].feePaid));
        }
    }
}


class Main{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        System.out.println("************************************************************************************************************************");
        System.out.println("************************************************************************************************************************");
        System.out.println("                                            WELCOME TO HOSTEL MANAGEMENT SYSTEM");
        System.out.println("************************************************************************************************************************");
        System.out.println("************************************************************************************************************************");
        System.out.println("\n\nSelect From Following Options:-");
        System.out.println();


        Student std=new Student();
        Student[] inf=new Student[50];

        Staff stf=new Staff();
        Staff[] stinf=new Staff[15];


        RoomManagement rm = new RoomManagement();


        FeeManagement feeMgmt = new FeeManagement();


        while(true){
            System.out.println("************************************************************************************************************************");
            System.out.println("************************************************************************************************************************");
            System.out.println("1.STUDENT MANAGEMENT");
            System.out.println("2.ROOM MANAGEMENT");
            System.out.println("3.FEE MANAGEMENT");
            System.out.println("4.STAFF MANAGEMENT");
            System.out.println("5.EXIT THE PROGRAME");
            System.out.println("************************************************************************************************************************");
            System.out.println("************************************************************************************************************************");
            System.out.println("ENTER YOUR CHOISE:-");
            int ch=sc.nextInt();
            System.out.println();
            switch(ch){

                //Student Management:-
                case 1:
                    boolean w1=true;
                    System.out.println("WELCOME TO STUDENT MANAGEMENT SYSTEM!!");

                    System.out.println("\nSelect From Following Options:-\n");
                    while(w1){

                        System.out.println("************************************************************************************************************************");
                        System.out.println("1.Add Student");
                        System.out.println("2.Display Student");
                        System.out.println("3.Remove Student");
                        System.out.println("4.Update Student ");
                        System.out.println("5.Short Student's by ID");
                        System.out.println("6.Search Student");
                        System.out.println("7.Exit the Student Management");
                        System.out.println("************************************************************************************************************************\n");
                        System.out.println("ENTER YOUR CHOISE:-");
                        int ch1=sc.nextInt();
                        switch(ch1){
                            case 1:
                                std.addStudent(inf);
                                break;
                            case 2:
                                std.getStudentDetails(inf);
                                break;
                            case 3:
                                std.removeStudent(inf);
                                break;
                            case 4:
                                std.updateStudentDetails(inf);
                                break;
                            case 5:
                                std.shortByStudentId(inf);
                                break;
                            case 6:
                                std.searchByStudentName(inf);
                                break;
                            case 7:
                                System.out.println("EXITING THE STUDENT MANAGEMENT System.....");
                                w1=false;
                                break;

                            default:System.out.println("PLEASE SELECT FROM 1 TO 7.");
                                break;
                        }
                    }
                    break;

                case 2:
                    boolean w2=true;
                    System.out.println("\nWelcome to Room Management System:");
                    System.out.println("\nSelect From Following Options:-\n");
                    while(w2){

                        System.out.println("************************************************************************************************************************\n");
                        System.out.println("1.Allocate Room");
                        System.out.println("2. Vacate Room");
                        System.out.println("3. Check Room Availability");
                        System.out.println("4. List Occupied Rooms");
                        System.out.println("5. List Available Rooms");
                        System.out.println("6.Exit Room management");
                        System.out.println("************************************************************************************************************************\n");
                        System.out.println("Enter your choice:");
                        int ch2 = sc.nextInt();
                        switch (ch2) {
                            case 1:rm.allocateRoomToStudent(inf);
                                break;
                            case 2:rm.vacantRoom(inf);
                                break;
                            case 3:rm.checkRoomAvailability(inf);
                                break;
                            case 4:rm.listOccupiedRooms(inf);
                                break;
                            case 5:rm.listAvailableRooms(inf);
                                break;
                            case 6:
                                System.out.println("Exiting the Room management System....");
                                w2=false;
                                break;
                            default:
                                System.out.println("Invalid Choice.");
                        }
                    }

                    break;


                case 3:
                    boolean w3=true;
                    System.out.println("\n Welcome to the FEE MANAGEMENT System:");
                    System.out.println("\nSelect From Following Options:-\n");
                    while(w3){

                        System.out.println("************************************************************************************************************************\n");
                        System.out.println("1. Pay Fees");
                        System.out.println("2. Check Due Fees");
                        System.out.println("3. Generate Fees Receipt");
                        System.out.println("4. Display All Student Fees");
                        System.out.println("5. Exit Fees management");
                        System.out.println("************************************************************************************************************************\n");
                        System.out.println("Enter your choice:");
                        int ch3 = sc.nextInt();
                        switch (ch3) {
                            case 1:
                                feeMgmt.payFees(inf);
                                break;
                            case 2:
                                feeMgmt.checkDueFees(inf);
                                break;
                            case 3:
                                feeMgmt.generateFeesReceipt(inf);
                                break;
                            case 4:
                                feeMgmt.displayFees(inf);
                                break;
                            case 5:
                                System.out.println("Exiting Fees management system...");
                                w3=false;
                                break;
                            default:
                                System.out.println("Invalid Choice.");
                                break;
                        }
                    }
                    break;


                case 4:
                    boolean w4=true;
                    System.out.println("WELCOME TO STAFF MANAGEMENT SYSTEM!!");
                    System.out.println("\nSelect From Following Options:-\n");
                    while(w4){

                        System.out.println("************************************************************************************************************************");
                        System.out.println("1.Add Staff");
                        System.out.println("2.Desplay Staff");
                        System.out.println("3.Remove Staff");
                        System.out.println("4.Update Staff");
                        System.out.println("5.exit");
                        System.out.println("************************************************************************************************************************\n");
                        System.out.println("ENTER YOUR CHOISE:-");
                        int ch4=sc.nextInt();
                        switch(ch4){
                            case 1:stf.addStaff(stinf);
                                break;
                            case 2:stf.getStaffDetails(stinf);                break;
                            case 3:stf.removeStaff(stinf);
                                break;
                            case 4:stf.updateStaffDetails(stinf);
                                break;
                            case 5:
                                System.out.println("Exiting the Staff management System...");
                                w4=false;
                                break;
                            default:System.out.println("PLEASE SELECT FROM 1 TO 5.");
                                break;
                        }
                    }
                    break;



                case 5:System.out.println("Exiting the Programe.....");
                    System.exit(0);
                    break;
                default:System.out.println("PLEASE SELECT FROM 1 TO 5.");
                    break;
            }
        }
    }
}



