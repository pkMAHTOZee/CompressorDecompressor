package GUI;

import comp_decomp.Compressor;
import comp_decomp.DeCompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton deCompressButton;
    AppFrame()
    {
        //set close operation for the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create compress button
        compressButton=new JButton("Select file to Compress");
        compressButton.setBounds(120,110,200,30);
        compressButton.addActionListener(this);

        //create decompress button
        deCompressButton=new JButton("select file to Decompress");
        deCompressButton.setBounds(350,110,200,30);
        deCompressButton.addActionListener(this);

        //add compress and decompress button to frame
        this.add(compressButton);
        this.add(deCompressButton);
        this.setSize(1000,500);

        //set frame layout and features
        this.setTitle("Compressor Decompressor (by Praveen)");
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==compressButton)
        {
            //create a file chooser dialog for choosing a file to compress
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                //get the file and its absolute path
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Compressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null,ee.toString());

                }
            }
        }
        if(e.getSource()==deCompressButton)
        {
            //create a file chooser dialog fo selecting a file for decompress
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                // get the file and its absolute path
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    DeCompressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null,ee.toString());

                }
            }
        }
    }

    public static void main(String[] args) {
        AppFrame app=new AppFrame();
    }
}
