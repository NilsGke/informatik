

public class Bagger extends Fahrzeug {
    private String Werkzeug;

    Bagger(String Name, String Kennzeichen, double Tankvolumen, double Verbrauch) {
        super(Name, Kennzeichen, Tankvolumen, Verbrauch);
    }

    public void setWerkzeug(String Werkzeug) {
        this.Werkzeug = Werkzeug;
    }

    public void useWerkzeug() {
        System.out.println("Bagger Bagger, mit: " + Werkzeug);
    }
}
