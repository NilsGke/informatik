import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;



/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 05.10.2023
 * @author 
 */

public class AutoGUI extends JFrame {
  // Anfang Attribute
  private JTable carTable = new JTable(0, 5);
    private DefaultTableModel carTableModel = (DefaultTableModel) carTable.getModel();
  private JScrollPane carTableScrollPane = new JScrollPane(carTable);
  private JLabel lAutos = new JLabel();
  private JTextField Input_Kennzeichen = new JTextField();
  private JLabel lKennzeichen = new JLabel();
  private JLabel lTankvolumen = new JLabel();
  private JNumberField Input_Tankvolumen = new JNumberField();
  private JLabel lVerbrauch = new JLabel();
  private JNumberField Input_Verbrauch = new JNumberField();
  private JButton bHinzufuegen = new JButton();
  private JLabel lAutoHinzufuegen = new JLabel();
  private JLabel lFahren = new JLabel();
  private JNumberField Input_Strecke = new JNumberField();
  private JLabel lStrecke = new JLabel();
  private JLabel lAutoIndex = new JLabel();
  private JNumberField Input_AutoIndex = new JNumberField();
  private JButton bFahren = new JButton();
  private JLabel lTanken = new JLabel();
  private JLabel lMenge = new JLabel();
  private JNumberField Input_Menge = new JNumberField();
  private JNumberField Input_AutoIndex2 = new JNumberField();
  private JButton bTanken = new JButton();
  private JLabel lAutoIndex1 = new JLabel();
  // Ende Attribute
  
  ArrayList<Auto> autos = new ArrayList<Auto>();
  
  public AutoGUI() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 986; 
    int frameHeight = 596;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("AutoGUI");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    carTableScrollPane.setBounds(31, 97, 684, 422);
    carTable.setRowHeight(25);
    carTable.setAutoCreateRowSorter(false);
    carTable.getColumnModel().getColumn(0).setHeaderValue("Kennzeichen");
    carTable.getColumnModel().getColumn(1).setHeaderValue("Kilometerstand");
    carTable.getColumnModel().getColumn(2).setHeaderValue("Tankvolumen");
    carTable.getColumnModel().getColumn(3).setHeaderValue("Verbrauch");
    carTable.getColumnModel().getColumn(4).setHeaderValue("Tankinhalt");
    cp.add(carTableScrollPane);
    lAutos.setBounds(381, 30, 110, 39);
    lAutos.setText("Autos");
    lAutos.setFont(new Font("Dialog", Font.BOLD, 30));
    cp.add(lAutos);
    Input_Kennzeichen.setBounds(755, 106, 150, 20);
    Input_Kennzeichen.setToolTipText("Kennzeichen");
    cp.add(Input_Kennzeichen);
    lKennzeichen.setBounds(755, 80, 110, 20);
    lKennzeichen.setText("Kennzeichen");
    cp.add(lKennzeichen);
    lTankvolumen.setBounds(755, 132, 110, 20);
    lTankvolumen.setText("Tankvolumen");
    cp.add(lTankvolumen);
    Input_Tankvolumen.setBounds(755, 157, 75, 20);
    Input_Tankvolumen.setText("");
    cp.add(Input_Tankvolumen);
    lVerbrauch.setBounds(755, 183, 110, 20);
    lVerbrauch.setText("Verbrauch");
    cp.add(lVerbrauch);
    Input_Verbrauch.setBounds(755, 209, 75, 20);
    Input_Verbrauch.setText("");
    Input_Verbrauch.setToolTipText("Verbrauch");
    cp.add(Input_Verbrauch);
    bHinzufuegen.setBounds(755, 235, 75, 25);
    bHinzufuegen.setText("Hinzufügen");
    bHinzufuegen.setMargin(new Insets(2, 2, 2, 2));
    bHinzufuegen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bHinzufuegen_ActionPerformed(evt);
      }
    });
    cp.add(bHinzufuegen);
    lAutoHinzufuegen.setBounds(753, 30, 241, 39);
    lAutoHinzufuegen.setText("Auto Hinzufügen");
    lAutoHinzufuegen.setFont(new Font("Dialog", Font.BOLD, 20));
    cp.add(lAutoHinzufuegen);
    lFahren.setBounds(754, 272, 110, 28);
    lFahren.setText("bFahren");
    lFahren.setFont(new Font("Dialog", Font.BOLD, 20));
    cp.add(lFahren);
    Input_Strecke.setBounds(753, 329, 75, 20);
    Input_Strecke.setText("");
    cp.add(Input_Strecke);
    lStrecke.setBounds(752, 308, 110, 20);
    lStrecke.setText("Strecke");
    cp.add(lStrecke);
    lAutoIndex.setBounds(853, 308, 110, 20);
    lAutoIndex.setText("Auto (Index)");
    cp.add(lAutoIndex);
    Input_AutoIndex.setBounds(848, 330, 75, 20);
    Input_AutoIndex.setText("");
    cp.add(Input_AutoIndex);
    bFahren.setBounds(803, 354, 75, 25);
    bFahren.setText("Fahren");
    bFahren.setMargin(new Insets(2, 2, 2, 2));
    bFahren.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bFahren_ActionPerformed(evt);
      }
    });
    cp.add(bFahren);
    lTanken.setBounds(755, 406, 110, 28);
    lTanken.setText("Tanken");
    lTanken.setFont(new Font("Dialog", Font.BOLD, 20));
    cp.add(lTanken);
    lMenge.setBounds(754, 438, 110, 20);
    lMenge.setText("Menge");
    cp.add(lMenge);
    Input_Menge.setBounds(752, 466, 75, 20);
    Input_Menge.setText("");
    cp.add(Input_Menge);
    Input_AutoIndex2.setBounds(848, 464, 75, 20);
    Input_AutoIndex2.setText("");
    cp.add(Input_AutoIndex2);
    bTanken.setBounds(801, 496, 75, 25);
    bTanken.setText("Tanken");
    bTanken.setMargin(new Insets(2, 2, 2, 2));
    bTanken.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bTanken_ActionPerformed(evt);
      }
    });
    cp.add(bTanken);
    lAutoIndex1.setBounds(853, 437, 110, 20);
    lAutoIndex1.setText("Auto (Index)");
    cp.add(lAutoIndex1);
    // Ende Komponenten
    
    setVisible(true);
  }
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    AutoGUI gui = new AutoGUI();
    gui.updateTable();
    
    class printSelected extends TimerTask {
      public void run() {
        System.out.println(gui.carTable.getEditingRow()); 
      }
    }

    // And From your main() method or any other method
    Timer timer = new Timer();
    timer.schedule(new printSelected(), 0, 500);
    
  }
  public void bHinzufuegen_ActionPerformed(ActionEvent evt) {
    String Kennzeichen = Input_Kennzeichen.getText();
    double Tankvolumen = Input_Tankvolumen.getDouble();
    double Verbrauch = Input_Verbrauch.getDouble();
    Auto NeuesAuto = new Auto(Kennzeichen, Tankvolumen, Verbrauch);
    autos.add(NeuesAuto);
    updateTable();
  }

  public void bFahren_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  }

  public void bTanken_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  }
  
  public void updateTable () {
    // clear table
    for (int i = 0; i < carTableModel.getRowCount(); i++) {
      carTableModel.removeRow(i);
    }
    
    for (Auto auto: autos) {
      String[] data = new String[]{
        auto.getKennzeichen(),
        auto.getKilometerstand() + "km",
        auto.getTankvolumen() + "L",
        auto.getVerbrauch() + "L/100km",
        auto.getTankinhalt() + "L"
      };

      carTableModel.addRow(data);
    }
    
    
    
  }


  // Ende Methoden
}
