package BDP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// cred ca stii ce e JDialog dar totodata iti mai zic ca am vrut sa creez o fereastra in care sa permit interactiunea utilizatorului cu butoanele 
public class ExceptionSelector extends JDialog {
    private boolean correct = false;
    private ExceptionHandler handler;

    public ExceptionSelector(Enemy enemy, ExceptionHandler handler) {
        this.handler = handler;

        setTitle("Selecteaza tipul corect de exceptie");
        setModal(true);
        setSize(400, 190);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        JButton b1 = createBlackButton("ArithmeticException");
        JButton b2 = createBlackButton("NullPointerException");
        JButton b3 = createBlackButton("ArrayIndexOutOfBoundsException");

        add(b1); add(b2); add(b3);

        ActionListener listener = e -> {
        	
        	// prin intermediul ActionListener pot sa asociez ce buton am selectat lui b pentru ca mai departe vreau sa l folosesc pentru 
        	// a imparti pe cazuri ce exceptie se va selecta concret
            JButton b = (JButton) e.getSource();
            //stiu ca smecheria asta suna a chatgpt dar sa stii ca e smecherie de la curs din cartea de certificare si spune asa: 
            // ma rog ca am vrut sa fac o "smecherie" care sa mi permita ca atunc icand selectez o varianta din cele 3 exceptii sa poata fi tratate si cum altfel decat un switch
            // dar revenind: " ? extends Exception " (avand in vedere ca acum avem o clasa aici)
            // permite accesul la toate clasele care sunt un subtip al clasei Exception 
            
            
            Class<? extends Exception> chosen = switch (b.getText()) {
                case "ArithmeticException" -> ArithmeticException.class;
                case "NullPointerException" -> NullPointerException.class;
                case "ArrayIndexOutOfBoundsException" -> ArrayIndexOutOfBoundsException.class;
                default -> null;
            };
// aici e o comparatie ca am vrut sa vad daca utilizatorul nimereste varianta corecta atunci correct va fi true
            //si va fi trimis mai departe daca nu atunci setez correct pe false si dupa verific mai apoi daca va fi corecta verificarea
            //voi arunca un nou obiect de tip Exception care va ajunge in ExceptionHandler .. de asta am facut handler.handle...
            if(chosen == enemy.getCorrectException()) {
                correct = true; //daca e true atunci in EnemyPanel va fi citit astfel incat sa treaca mai departe in joc (verifica EnemyPanel si commentariile)
            } else {
                correct = false; // aici la fel dar aici e ideea ca jocul se opreste si totodata se afiseaza un mesaj daca se executa if ul
                if(handler != null) {
                    handler.handle(new Exception("Ai ales gresit!"));
                }
            }

            //dupa ce s au efectuat toate si utilizatorul a pierdut vreau sa opresc jocul 
            dispose();
        };

        b1.addActionListener(listener);
        b2.addActionListener(listener);
        b3.addActionListener(listener);
    }

    public boolean isCorrect() {
        return correct;
    }
    
    private JButton createBlackButton(String text) {
        JButton b = new JButton(text);

        b.setBackground(Color.BLUE);
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setBorderPainted(false);
        b.setOpaque(true);

        b.setFont(new Font("Arial", Font.BOLD, 14));
        b.setPreferredSize(new Dimension(220, 40));

        b.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                b.setBackground(Color.DARK_GRAY);
            }

            public void mouseExited(MouseEvent e) {
                b.setBackground(Color.BLUE);
            }
        });

        
        return b;
    }

}
