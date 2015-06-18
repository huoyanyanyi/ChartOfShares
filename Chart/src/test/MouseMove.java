package test;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseMove extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JLabel lab=new JLabel();
    public MouseMove(String string) {
    }
    public static void main(String [] args)
    {
       MouseMove fm=new MouseMove("鼠标坐标测试");
     //  JFrame fm=new JFrame("鼠标坐标测试");
       JPanel fp=new JPanel();
       fp.addMouseMotionListener(new myMouseListener());//对在面板上的鼠标移动进行监听。
       Container con=fm.getContentPane();
       fp.add(lab);        
       con.add(fp);
       fm.setSize(500,400);
       fm.setVisible(true); 
       fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}