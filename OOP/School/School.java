import java.util.ArrayList;

public class School {

  private String name;
  private Teacher headTeacher;
  private Student[] students;
  private Teacher[] teachers;
  private Course[] courses;

  public static void main(String[] args) {
    School gmb = new School("Mosbacher Berg");
    Teacher msManig = gmb.new Teacher("Frau Manig");
    gmb.headTeacher = msManig;
  }

  public School(String _name) {
    name = _name;
  }

  public void setHeadTeacher(Teacher headTeacher) {
    this.headTeacher = headTeacher;
  }

  public Teacher getHeadTeacher() {
    return this.headTeacher;
  }

  public String getSchoolName() {
    return this.name;
  }

  public void setSchoolName(String name) {
    this.name = name;
  }

  public class Course {

    public Teacher teacher;
    public Student[] students;
    public int grade;

    public Course(Teacher _teacher, Student[] _students, int _grade) {
      teacher = _teacher;
      students = _students;
      grade = _grade;
    }

    public void advanceToNextGrade() {
      this.grade++;
    }
  }

  public void addCourse(Teacher teacher, Student[] students, int grade) {
    courses[courses.length - 1] = new Course(teacher, students, grade);
  }

  public void removeCourse(Course course) {
    // remove coures from courses
    ArrayList<Course> courses = new ArrayList<>();
    for (Course _course : this.courses) {
      courses.add(_course);
    }
    courses.remove(course);
    this.courses = (School.Course[]) courses.toArray();

    // remove courses from students
    for (Student student : this.students) {
      student.removeCourse(course);
    }
  }

  public Course[] getCourses() {
    return courses;
  }

  public class Teacher {

    public String name;
    public Course[] courses;

    public Teacher(String _name) {
      name = _name;
    }
  }

  public void addTeacher(Teacher teacher) {
    this.teachers[this.teachers.length - 1] = teacher;
  }

  public void removeTeacher(Teacher teacher) {
    // remove teacher from teachers
    ArrayList<Teacher> teachers = new ArrayList<>();
    for (Teacher _teacher : this.teachers) {
      teachers.add(_teacher);
    }
    teachers.remove(teacher);
    this.teachers = (School.Teacher[]) teachers.toArray();

    // remove courses from this teacher
    for (Course course : teacher.courses) {
      this.removeCourse(course);
    }
  }

  public class Homework {

    public Course course;
    public String task;
  }

  public class Subject {

    public String name;
    public Teacher[] teachers = new Teacher[0];

    public Subject(String name, Teacher[] teachers) {
      this.name = name;
    }

    public void addTeacher(Teacher teacher) {
      this.teachers[this.teachers.length - 1] = teacher;
    }

    public void removeTeacher(Teacher teacher) {
      ArrayList<Teacher> teachers = new ArrayList<>();
      for (Teacher _teacher : this.teachers) {
        teachers.add(_teacher);
      }
      teachers.remove(teacher);
      this.teachers = (School.Teacher[]) teachers.toArray();
    }
  }

  public class Student {

    public String name;
    public int grade = 5;
    public Course[] courses = new Course[0];
    public Homework[] homework = new Homework[0];
    public WillToLive willToLive = WillToLive.Average;

    public Student(String name) {
      this.name = name;
    }

    public Student(String name, int grade) {
      this.name = name;
      this.grade = grade;
    }

    public void addCourse(Course course) {
      courses[courses.length] = course;
    }

    public void removeCourse(Course course) {
      ArrayList<Course> courses = new ArrayList<>();
      for (Course _course : this.courses) {
        courses.add(_course);
      }
      courses.remove(course);
      this.courses = (School.Course[]) courses.toArray();
    }

    public void advanceToNextGrade() {
      this.grade++;
    }

    public void addHomework(Homework homework) {
      this.homework[this.homework.length] = homework;
    }

    public void completeHomework(Homework homework) {
      removeObjectFromArray(this.homework, homework);
    }
  }

  public void addStudent(Student student) {
    this.students[this.students.length - 1] = student;
  }

  public Student[] getStudents(Student student) {
    return this.students;
  }

  private enum WillToLive {
    High,
    Average,
    Low,
  }

  private <T> void removeObjectFromArray(T[] list, T objToRemove) {
    ArrayList<T> arrayList = new ArrayList<>();
    for (T obj : list) {
      arrayList.add(obj);
    }
    arrayList.remove(objToRemove);
    list = (T[]) arrayList.toArray();
  }
}
