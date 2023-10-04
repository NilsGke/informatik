public class Auto {

  private String Kennzeichen;
  private double Kilometerstand;
  private double Tankvolumen;
  private double Verbrauch;
  private double Tankinhalt;

  public Auto(String Kennzeichen, double Tankvolumen, double Verbrauch) {
    this.Kennzeichen = Kennzeichen;
    this.Tankvolumen = Tankvolumen;
    this.Verbrauch = Verbrauch;
    Tankinhalt = 0;
    Kilometerstand = 0;
  }

  public String getKennzeichen() {
    return Kennzeichen;
  }

  public double getKilometerstand() {
    return Kilometerstand;
  }

  public double getTankinhalt() {
    return Tankinhalt;
  }

  public void tanken(double Menge) {
    if (Menge > this.Tankvolumen - this.Tankinhalt) {
      System.out.println(
        "Du hast " +
        (Menge - this.Tankvolumen - this.Tankinhalt) +
        " Liter zu viel getankt 🤨"
      );
      this.Tankinhalt = this.Tankvolumen;
    } else {
      this.Tankinhalt += Menge;
    }
  }

  public void vollTanken() {
    this.Tankinhalt = this.Tankvolumen;
  }

  public double calcStreckeBisLeer() {
    return this.Tankinhalt / (this.Verbrauch / 100);
  }

  public void fahren(double Strecke) {
    double VerbrauchFuerStrecke = Strecke * (this.Verbrauch / 100);

    System.out.print("Brrrrrrrrrrrrr 🚗");

    if (VerbrauchFuerStrecke > this.Tankinhalt) {
      Strecke = this.Tankinhalt / (this.Verbrauch / 100);
      this.Kilometerstand += Strecke;
      this.Tankinhalt = 0;
      System.out.println("Die Strecke war zu lang, dein Tank ist nun leer 😯");
    } else {
      this.Kilometerstand += Strecke;
      this.Tankinhalt -= VerbrauchFuerStrecke;
    }
  }

  public void leerFahren() {
    this.Kilometerstand += this.Tankinhalt / (this.Verbrauch / 100);
    this.Tankvolumen = 0;
  }

  public double aktuellerVerbrauch(double Strecke, double Menge) {
    return (double) 100 / Menge * Strecke;
  }

  public void langeStreckeFahren(double Strecke) {
    int Tankpausen = 0;

    while (Strecke > 0) {
      double streckeBisLeer = calcStreckeBisLeer();
      if (Strecke > streckeBisLeer) {
        fahren(streckeBisLeer);
        Strecke -= streckeBisLeer;
        this.vollTanken();
        Tankpausen++;
      } else {
        this.Kilometerstand -= Strecke;
        this.Tankinhalt -= Strecke / (this.Verbrauch / 100);
        Strecke = 0;
      }
    }

    System.out.println("du musstest " + Tankpausen + " mal tanken ⛽");
  }
}
