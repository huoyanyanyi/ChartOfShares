package test;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
public class aa extends JFrame {
 public aa(){
  super();
  setSize(100,100);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setVisible(true);
  
  JProgressBar progressBar = new JProgressBar();
  getContentPane().add(progressBar,BorderLayout.NORTH);
  progressBar.setStringPainted(true);
  for (int i = 0;i < 50;i++){
   progressBar.setValue(i);
   try {
    Thread.sleep(1000);
   } catch (InterruptedException e) {
    e.printStackTrace();
   }
  }
 }
 public static void main(String[] args) {
  new aa();
 }
}