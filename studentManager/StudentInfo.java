package studentManager;

public class StudentInfo {
    public static void main(String[] args) {
        Classroom classroom = new Classroom("KRK");
        String name = "Miss Lee",
                subject = "Math",
                id = "00000";
        int addressing = 0;
        Teacher missLee = new Teacher(id, name, subject, addressing);
        classroom.setHomeTeacher(missLee);
        classroom.printHomeroomTeacherInfo();
        classroom.getStudentList();
        People tung = new People("056200", "tung lit onn");
        classroom.printClassroomInfo();
        classroom.addStudent(tung);
        classroom.printClassroomInfo();
        classroom.getStudentList();
    }
}



