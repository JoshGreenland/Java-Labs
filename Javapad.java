import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

class Javapad extends JFrame {
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem n, open, save, exit;

    public Javapad(){
        super("Javapad");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buildGUI();
        setPreferredSize(new Dimension(640, 480));
        pack();
        setVisible(true);
    }

    private void buildGUI(){
        Container ct = getContentPane();
        menuBar = new JMenuBar();
        ct.add(menuBar, BorderLayout.NORTH);

        fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        n = new JMenuItem("New");
        fileMenu.add(n);
        fileMenu.addSeparator();

        open = new JMenuItem("Open");
        fileMenu.add(open);
        fileMenu.addSeparator();

        save = new JMenuItem("Save");
        fileMenu.add(save);
        fileMenu.addSeparator();

        exit = new JMenuItem("Exit");
        fileMenu.add(exit);

        JTextArea edit = new JTextArea(30,20);
        edit.setFont(new Font("Menlo", Font.PLAIN, 14));

        JScrollPane sp = new JScrollPane(edit);
        sp.setPreferredSize(new Dimension(450,100));
        ct.add(sp,BorderLayout.CENTER);

        MenuListener ML = new MenuListener(edit);
        n.addActionListener(ML);
        open.addActionListener(ML);
        save.addActionListener(ML);
        exit.addActionListener(ML);

    }

    private class MenuListener implements ActionListener{
        private JFileChooser fc;
        private JTextArea area;

        public MenuListener(JTextArea edit){
            area = edit;
            fc = new JFileChooser();
        }
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == n){

                area.setText("");

            }else if(e.getSource() == open){
                int returnVal = fc.showOpenDialog(Javapad.this);
                if(returnVal == JFileChooser.APPROVE_OPTION){

                    try{
                        File f = fc.getSelectedFile();
                        area.setText(readFile(f));
                    }catch(Exception x){
                        System.out.println(x);
                    }
                }
            }else if(e.getSource() == save){
                int returnVal = fc.showSaveDialog(Javapad.this);
                if(returnVal == JFileChooser.APPROVE_OPTION){
                    
                    try{
                        File f = fc.getSelectedFile();
                        writeFile(f);
                        
                    }catch(Exception x){
                        System.out.println(x);
                    }
                }
            }else if(e.getSource() == exit){
                 System.exit(0);
            }
        }
        public String readFile(File f)throws IOException{
            FileReader in = new FileReader(f);
            int size = (int)f.length();
            char[] data = new char[size];
            in.read(data);
            in.close();
            return new String(data);
        } 

        public void writeFile(File f) throws IOException {
		    FileWriter out = new FileWriter(f);
		    out.write(area.getText());
		    out.close();
	    }   
    }

    public static void main(String[] args){
        Javapad jp = new Javapad();
    }
}