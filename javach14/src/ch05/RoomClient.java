package ch05;

import java.awt.*;
import javax.swing.table.*;
import java.awt.event.*;
import javax.swing.*;

class RoomClient extends JFrame
{
	//필드선언
	String [][]data1 = new String[0][1];
	String []cols1 = {"대화명"};

	TextArea ta = new TextArea();
	TextField tf = new TextField(10);

	 JLabel lab1 = new JLabel("현재인원");
	 TextField inwon = new TextField(10);
	
	JButton nickB = new JButton("대화명 변경");
	JButton sayB = new JButton("귓속말");
	JButton outB = new JButton("나가기");
	
	DefaultTableModel  model1 = new DefaultTableModel(data1,cols1);
	JTable table1 = new JTable(model1);	
	JScrollPane roominfo = new JScrollPane(table1);	
	
	//생성자
	RoomClient()	{
		super("RoomClient");
		//속성지정
		table1.getTableHeader().setReorderingAllowed(false);	
		table1.getTableHeader().setBackground(new Color(61,232,205));

		nickB.setBackground(new Color(85,214,211));
		sayB.setBackground(new Color(85,214,211));
		outB.setBackground(new Color(85,214,211));
		
		lab1.setFont(new Font("Dialog", Font.PLAIN, 12));
		nickB.setFont(new Font("Dialog", Font.PLAIN, 12));
		sayB.setFont(new Font("Dialog", Font.PLAIN, 12));
		outB.setFont(new Font("Dialog", Font.PLAIN, 12));

		//프레임 배치
		setLayout(null);
		add(ta).setBounds(10,10,400,400);
		add(roominfo).setBounds(415,10,168,200);
		add(tf).setBounds(10,420,400,30);
		add(lab1).setBounds(445,240,100,30);
		add(inwon).setBounds(445,280,45,20);
		
		add(nickB).setBounds(450,325,100,30);
		add(sayB).setBounds(450,365,100,30);
		add(outB).setBounds(450,405,100,30);
		tf.requestFocus();
		setSize(600,485);
		// setVisible(true);
	}//생성자 종료
 	/*
	 public static void main(String args[])	{
		new RoomClient();
	}   */
}