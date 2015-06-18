package test;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

class myMouseListener  implements MouseMotionListener
{
       public void mouseMoved(MouseEvent e){
           int x=e.getX();
           int y=e.getY();
           String s="当前鼠标坐标:"+x+','+y;
           MouseMove.lab.setText(s);


       }
         public void mouseDragged(MouseEvent e){};
}

