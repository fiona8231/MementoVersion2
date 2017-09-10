import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test extends JFrame{
    public static void main(String[] args){
        new Test();
    }

    private JButton saveButton, undoButton, redoButton;
    private JTextArea textingArea = new JTextArea(50,50);

    Container container = new Container();
    int saveFile = 0;
    int currentFile =0;


public Test(){

    this.setSize(350, 500); // the total size
    this.setTitle("CAT Memory");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JLabel jLabel = new JLabel("Miao");


    JPanel jPanel = new JPanel();
    jPanel.add(textingArea);
    jPanel.add(jLabel);

    saveButton = new JButton("Save");
    undoButton = new JButton("Undo");
    redoButton = new JButton("Redo");


   ButtonListener saveListen = new ButtonListener();
   ButtonListener undoListen = new ButtonListener();
   ButtonListener redoListen = new ButtonListener();
    saveButton.addActionListener(saveListen);
    undoButton.addActionListener(undoListen);
    redoButton.addActionListener(redoListen);

    jPanel.add(saveButton);
    jPanel.add(undoButton);
    jPanel.add(redoButton);

    this.add(jPanel);
    this.setVisible(true);

}class ButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == saveButton){

            Fraction newFraction = new Fraction(textingArea.getText());
            container.addElement(newFraction);
            saveFile++;
            System.out.println("File " + saveFile + " Saved");
            undoButton.setEnabled(true);
        }

        if(e.getSource() == undoButton){

            if(saveFile >= 1){
                saveFile--;
                Fraction tmp = container.getElement(saveFile);
                String fileTemp = tmp.getFraction();
                textingArea.setText(fileTemp);
                System.out.println("File" + saveFile + "Saved");
                redoButton.setEnabled(true);
            }else {
                System.out.println("This is the last file you have");
                undoButton.setEnabled(false);
            }

        }
        if(e.getSource() == redoButton){
            saveFile++;
            Fraction tmp = container.getElement(saveFile);
            String fileTmp = tmp.getFraction();
            textingArea.setText(fileTmp);
            System.out.println("File" + saveFile + "Saved");
            undoButton.setEnabled(true);

        }



    }
}




}
