import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatGraphic extends JFrame{
    static final int WIDTH = 1024;
    static final int HEIGHT = 768;
    public ChatGraphic(){
        setTitle("BriZzChat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        JMenuBar mainMenu = new JMenuBar();
        JMenu mFile = new JMenu("File");
        JMenu mEdit = new JMenu("Edit");
        JMenuItem miFileNew = new JMenuItem("New");
        JMenuItem miFileExit = new JMenuItem("Exit");
        setJMenuBar(mainMenu);
        mainMenu.add(mFile);
        mainMenu.add(mEdit);
        mFile.add(miFileNew);
        mFile.addSeparator();
        mFile.add(miFileExit);

        miFileExit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Bye");
            }
        });

        JPanel[] jpeast = new JPanel[3];
        for (int i = 0; i < jpeast.length ; i++) {
            jpeast[i] = new JPanel();
            jpeast[i].setLayout(new FlowLayout());
            }

        jpeast[0].setPreferredSize(new Dimension(200,400));
        jpeast[1].setPreferredSize(new Dimension(400,400));
        jpeast[2].setPreferredSize(new Dimension(100,50));

        jpeast[0].setBackground(new Color(34+2*40,34+2*40,34+2*40));
        jpeast[1].setBackground(new Color(34+2*40,34+2*40,34+2*40));
        jpeast[2].setBackground(new Color(100+3*40,100+3*40,99+40));


        JButton button1 = new JButton("Отправить");
        button1.getColorModel();
        button1.setBackground(new Color(100+3*40,100+3*40,99+40));

        JTextArea jTextArea2 = new JTextArea();
        JTextField jTextField = new JTextField();
        JTable jTable = new JTable();
//        jTable.setBackground(new Color(100+3*40,100+3*40,99+40));


        JScrollPane scrollPane1 = new JScrollPane(jTable);
        scrollPane1.setPreferredSize(new Dimension(190, 655));
        JScrollPane scrollPane2 = new JScrollPane(jTextArea2);
        scrollPane2.setPreferredSize(new Dimension(810, 655));
        JScrollPane scrollPane3 = new JScrollPane(jTextField);
        scrollPane3.setPreferredSize(new Dimension(900, 40));

        jTextArea2.setEditable(false);
        jTextArea2.setLineWrap(true);
       // jTextField.setLineWrap(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                jTextArea2.append( "Ваше сообщение: "+ jTextField.getText() + "\n");
                jTextField.setText("");
            }
        });

        jTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                jTextArea2.append("Ваше сообщение: " + jTextField.getText() + "\n");
                jTextArea2.setCaretPosition(jTextArea2.getDocument().getLength());
                jTextField.setText("");
            }
        });

        jpeast[0].add(scrollPane1);
        jpeast[1].add(scrollPane2);
        jpeast[2].add(scrollPane3);
        jpeast[2].add(button1);

        add(jpeast[0], BorderLayout.EAST);
        add(jpeast[1], BorderLayout.CENTER);
        add(jpeast[2], BorderLayout.SOUTH);

        setVisible(true);
    }
}
