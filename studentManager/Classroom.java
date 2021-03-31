package studentManager;

public class Classroom {
    private static int MAX_CLASSROOM_TABLE = 40;
    private People[] students = new People[MAX_CLASSROOM_TABLE - 1]; // reduce one so that one table can be reserved for teacher
    private Teacher homeroomTeacher;
    private int classSize = 0;
    private String name;

    public Classroom (String className) {
        this.name = className.toUpperCase();
    }

    public void setHomeTeacher (Teacher homeroomTeacher) {
        this.homeroomTeacher = homeroomTeacher;
        Utility.separatorStart();
        System.out.printf("%s has been assigned as the homeroom teacher for classroom %s\n",
                         homeroomTeacher.getName(), this.name);
        Utility.separatorEnd();
    }

    public void changeHomeroomTeacher (Teacher newHomeroomTeacher) {
        this.homeroomTeacher = newHomeroomTeacher;
        System.out.printf("%s has been assigned as the new homeroom teacher for classroom %s\n",
                         homeroomTeacher, this.name);
        
    }

    public Teacher getHomeroomTeacher () {
        return homeroomTeacher;
    }

    public void printHomeroomTeacherInfo() {
        String info[] = this.homeroomTeacher.getInfo();

        Utility.separatorStart();
        System.out.printf("Teacher Info for %s %s", info[0], info[1]);
        Utility.separator();
        System.out.printf("ID                : %s\n", info[2]);
        System.out.printf("Name              : %s\n", info[1]);
        System.out.printf("Subject           : %s\n", info[3]);
        System.out.printf("Race              : %s\n", info[4]);
        Utility.separatorEnd();

    }

    public void addStudent (People student) {
        if (classSize < MAX_CLASSROOM_TABLE - 1) {
            this.students[classSize] = student;
            classSize += 1;
            System.out.printf("Added %s into %s", student.getName(), this.name);
        }else {
            System.out.printf("%s is already Full. Please consider placing the student into a different classroom"
                            , this.name);
        }
    }

    public void removeStudent (String studentID) {
        int position = getStudentLocation(studentID);
        if (position > -1) {
            String name = students[position].getName();
            for (int index = position; index < classSize - 1;index++) {
                students[index] = students[index + 1]; 
            }
            System.out.printf("Removed %s from the classroom %s.", name, this.name);
            classSize -= 1;
            if (classSize < 0) {
                classSize = 0;
            }
        }else {
            System.out.printf("Can't find student with ID %s!", studentID);
        }
    }

    public void getStudentList() {
        studentInfoHeader();
        if (classSize == 0) {
            System.out.println("\nNo Data was found!!!");
        }
        for (int x = 0; x < classSize; x++) {
            People currStudent = students[x];
            printInfo(currStudent, x);
        }
        Utility.separatorEnd();
    }

    public void printStudentInfo(String id){
        studentInfoHeader();
        int studentArrPosition = getStudentLocation(id);
        if (studentArrPosition > -1) {
            People theStudent = students[studentArrPosition];
            printInfo(theStudent, studentArrPosition);
        }else {
            System.out.printf("Student not found based on the id : %s", id);
        }
        Utility.separatorEnd();
    }

    private void studentInfoHeader() {
        Utility.separatorStart();
        System.out.println("Showing Student/s Information.");
        Utility.separator();
        System.out.println("\nNum\t\tName\t\tID");
        Utility.separator();
    }

    private int getStudentLocation(String id) {
        for (int x = 0; x < classSize; x++) {
            if (students[x].getID() == id) {
                return x;
            }
        }
        return -1;
    }

    private void printInfo (People People, int position) {
        String[] info = People.getInfo();
        System.out.printf("\n%s\t\t%s\t\t%s\n", (position + 1), info[0], info[1]);
    }

    public void printClassroomInfo(){
        Utility.separatorStart();
        System.out.println("Classroom Info");
        Utility.separator();        
        System.out.printf("Classroom name              : %s\n", this.name);
        System.out.printf("Homeroom teacher            : %s\n", this.homeroomTeacher.getName());
        System.out.printf("Classroom current size      : %d\n", classSize);
        System.out.printf("Classroom current free space: %d\n", MAX_CLASSROOM_TABLE - 1 - classSize);
        Utility.separatorEnd();
    }
}