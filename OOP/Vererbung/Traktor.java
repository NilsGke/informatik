

public class Traktor extends Fahrzeug {

    private double Zugkraft;
    public String Fahrzeugtyp = "Traktor";
    
    

    Traktor(String Name, String Kennzeichen, double Tankvolumen, double Verbrauch, double Zugkraft) {
        super(Name, Kennzeichen, Tankvolumen, Verbrauch);
        this.Zugkraft = Zugkraft;
    }


    public double getZugkraft() {
        return Zugkraft;
    }

}
