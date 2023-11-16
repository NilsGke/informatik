import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 16.11.2023
 * @author 
 */

public class GUI extends JFrame {
  // Anfang Attribute
  private JTable jTable1 = new JTable(1, 10);
    private DefaultTableModel jTable1Model = (DefaultTableModel) jTable1.getModel();
    private JScrollPane jTable1ScrollPane = new JScrollPane(jTable1);
  private JButton bRandomZahlen = new JButton();
  private JButton bBubbleSort = new JButton();
  private JButton bInsertionSort = new JButton();
  // Ende Attribute
  
  private Liste liste = new Liste(10);
  
  public GUI() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 775; 
    int frameHeight = 417;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("GUI");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jTable1ScrollPane.setBounds(57, 42, 628, 46);
    jTable1.getColumnModel().getColumn(0).setHeaderValue("[0]");
    jTable1.getColumnModel().getColumn(1).setHeaderValue("[1]");
    jTable1.getColumnModel().getColumn(2).setHeaderValue("[2]");
    jTable1.getColumnModel().getColumn(3).setHeaderValue("[3]");
    jTable1.getColumnModel().getColumn(4).setHeaderValue("[4]");
    jTable1.getColumnModel().getColumn(5).setHeaderValue("[5]");
    jTable1.getColumnModel().getColumn(6).setHeaderValue("[6]");
    jTable1.getColumnModel().getColumn(7).setHeaderValue("[7]");
    jTable1.getColumnModel().getColumn(8).setHeaderValue("[8]");
    jTable1.getColumnModel().getColumn(9).setHeaderValue("[9]");
    cp.add(jTable1ScrollPane);
    bRandomZahlen.setBounds(285, 102, 163, 49);
    bRandomZahlen.setText("Random Zahlen");
    bRandomZahlen.setMargin(new Insets(2, 2, 2, 2));
    bRandomZahlen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bRandomZahlen_ActionPerformed(evt);
      }
    });
    cp.add(bRandomZahlen);
    bBubbleSort.setBounds(59, 143, 107, 49);
    bBubbleSort.setText("BubbleSort");
    bBubbleSort.setMargin(new Insets(2, 2, 2, 2));
    bBubbleSort.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bBubbleSort_ActionPerformed(evt);
      }
    });
    cp.add(bBubbleSort);
    bInsertionSort.setBounds(61, 208, 107, 49);
    bInsertionSort.setText("Insertion Sort");
    bInsertionSort.setMargin(new Insets(2, 2, 2, 2));
    bInsertionSort.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bInsertionSort_ActionPerformed(evt);
      }
    });
    cp.add(bInsertionSort);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public GUI
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new GUI();
  } // end of main
  
  public void bRandomZahlen_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    liste.randomize();
    anzeigen();
  } // end of bRandomZahlen_ActionPerformed
  

  private void anzeigen() {
    int[] array = liste.getListe();
    for (int i = 0; i < array.length; i++) jTable1Model.setValueAt(array[i], 0, i);
  }
  

  public void bBubbleSort_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    liste.bubbleSort();
    anzeigen();
  }

  


  public void bInsertionSort_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    liste.insertionSort();
    anzeigen();
  }

  // Ende Methoden
} // end of class GUI

