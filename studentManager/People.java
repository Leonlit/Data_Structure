package studentManager;

public class People {
    private String name, id, race;

    public People (String id, String name) {
        this.id = id;
        this.name = name.toUpperCase();
    }

    public People (String name) {
        this.id = null;
        this.name = name.toUpperCase();
    }

    public String[] getInfo() {
        return new String[]{this.name, this.id};
    }

    public void setID (String newID) {
        this.id = newID;
    }

    public String getName() {
        return this.name;
    }

    public String getID () {
        return this.id;
    }

    public String getRace() {
        return this.race;   
    }
}

class Teacher extends People{
    private static String[] ADDRESSING = {"Miss", "Sir", "Madam", "Mister", ""};
    private String subject, addressing;

    public Teacher (String id, String name, String subject, int addressing) {
        super(id, name);
        this.subject = subject;
        this.addressing = ADDRESSING[addressing];
    }

    @Override
    public String[] getInfo(){
        return new String[] {this.addressing, super.getName(), super.getID(), this.subject,this.getRace()};
    }

    public void changeSubject (String newSubject) {
        System.out.printf("Changed the subject that %s %s from %s to %s", 
                        this.addressing, super.getName(), this.subject, newSubject);
        this.subject = newSubject;
    }
}
