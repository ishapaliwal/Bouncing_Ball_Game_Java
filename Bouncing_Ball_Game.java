import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.Random;
public class Bouncing_Ball_Game extends Applet implements MouseListener, MouseMotionListener 
{
int xb,yb,hb,wb,xs,ys,ws,hs,m,n,x1,y1,x2,y2,y,k;
boolean flag1,flag2;
Font f;
Random ob;
public void init()
{
f=new Font("Old English Text MT",Font.BOLD+Font.ITALIC,40);
flag1=true;
flag2=true;
ob=new Random();
y=50;
k=ob.nextInt(260);
xb=0;
yb=530;
wb=50;
hb=20;
xs=0;
ys=50;
ws=300;
hs=500;
addMouseListener(this);
addMouseMotionListener(this);
}
public void mouseEntered(MouseEvent me)
{
}
public void mouseExited(MouseEvent me)
{
}
public void mouseClicked(MouseEvent me)
{
}
public void mousePressed(MouseEvent me)
{
x1=me.getX();
y1=me.getY();
}
public void mouseReleased(MouseEvent me)
{
}
public void mouseMoved(MouseEvent me)
{
}
public void mouseDragged(MouseEvent me)
{
x2=me.getX();
y2=me.getY();
if((x2>=xs&&x2<=xs+ws)&&(y2>=ys&&y2<=ys+hs))
{
if(xb<=xs)
xb=xs;
else if(xb+wb>=xs+ws)
xb=xs+ws-wb;
m=x2-x1;
xb=xb+m;
x1=x2;
y1=y2;
repaint();
}
}
public void paint(Graphics g)
{
g.fillRect(xs,ys,ws,hs);
g.setColor(Color.blue);
g.fillRect(xb,yb,wb,hb);

if(flag2==true)
{
if(flag1==true) 
y+=2;
else
y-=2;
}
else
{
g.setFont(f);
g.drawString("Game Over",40,300);
}

if(y==510)
{
/*k=ob.nextInt(260);
y=50;
flag1=true;*/
flag2=false;
/*repaint();*/

}
else if(y==50)
{
k=ob.nextInt(260);
flag1=true;
flag2=true;
}
else if(k<=xb+wb&&k>=xb-40&&y==490)
{
flag1=false;
flag2=true;
}
g.fillOval(k,y,40,40);
try
{
Thread.sleep(5);
}
catch(InterruptedException e)
{
System.out.println("ERRORRRRRRRR");
}
repaint();

}
}
/*<applet code="Bouncing_Ball_Game" width=440 height=640>
</applet>*/