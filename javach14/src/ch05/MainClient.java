package ch05;

/*
대기실 입장 100
방만들기 200
방들어가기 210
방에서 메세지 400
방퇴장 290
종료 900
*/
import java.awt.*;
import javax.swing.table.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class MainClient extends JFrame 
	implements Runnable,ActionListener,MouseListener {

	//필드 선언
	Socket s;
	BufferedReader in;
	OutputStream out;
	String name,host,title="대기실";
	String [][]data1 = new String[0][2];
	String []cols1 = {"방제목","인원"};
	String [][]data2 = new String[0][1];
	String []cols2 = {"대화명"};
	String [][]data3 = new String[0][2];
	String []cols3 = {"대화명","위치"};

	JButton creatB = new JButton("방 만들기"); 
	JButton roominB = new JButton("방들어가기");
	JButton exitB = new JButton("종   료");
	
	DefaultTableModel  model1 = new DefaultTableModel(data1,cols1);
	DefaultTableModel  model2 = new DefaultTableModel(data2,cols2);
	DefaultTableModel  model3 = new DefaultTableModel(data3,cols3);
	
	JTable table1 = new JTable(model1);	
	JTable table2 = new JTable(model2);	
	JTable table3 = new JTable(model3);	
	
	JScrollPane waitroom = new JScrollPane(table1);
	JScrollPane roominfo = new JScrollPane(table2);
	JScrollPane waitinfo = new JScrollPane(table3);
	
	RoomClient client=new RoomClient();
	
	public MainClient(String host)	{
	    super("Main_Caht");
		this.host=host;
      
		table1.getTableHeader().setReorderingAllowed(false);
		table2.getTableHeader().setReorderingAllowed(false);
		table3.getTableHeader().setReorderingAllowed(false);
		
		table1.getTableHeader().setBackground(new Color(255,207,96));
		table2.getTableHeader().setBackground(new Color(255,207,96));
		table3.getTableHeader().setBackground(new Color(255,207,96));
		
		creatB.setBackground(new Color(85,214,211));
		roominB.setBackground(new Color(85,214,211));
		exitB.setBackground(new Color(85,214,211));
		
		creatB.setFont(new Font("Dialog", Font.PLAIN, 12));
		roominB.setFont(new Font("Dialog", Font.PLAIN, 12));
		exitB.setFont(new Font("Dialog", Font.PLAIN, 12));
		
		//프레임 배치
		setLayout(null);
		add(waitroom).setBounds(10,10,400,250);
		add(roominfo).setBounds(415,10,168,250);
		add(waitinfo).setBounds(10,270,400,197);

		add(creatB).setBounds(449,300,100,30);
		add(roominB).setBounds(449,340,100,30);
		add(exitB).setBounds(449,380,100,30);		
		table1.setSelectionMode(0);
				
		setSize(600,500);
		name=JOptionPane.showInputDialog(null,"대화명을 입력하세요",
				"대화명입력",JOptionPane.YES_NO_OPTION);
		
		if(name==null||name.length()<1)
		  return;
		connectProcess();
		setVisible(true);
		eventUp();	
	}
	
	void eventUp() 	{
	
	  creatB.addActionListener(this);
	  roominB.addActionListener(this);
	  client.tf.addActionListener(this);
	  client.outB.addActionListener(this);
	  
	  table1.addMouseListener(this);
     
	  client.nickB.addActionListener(this);
     client.sayB.addActionListener(this);
	  exitB.addActionListener(this);
	}
	
	public void mouseClicked(MouseEvent e)	{
	    model2.setRowCount(0);
	    int r=table1.getSelectedRow();
			String temp=(String)model1.getValueAt(r,0);
			for(int i=0;i<model3.getRowCount();i++) {
				String roomt=(String)model3.getValueAt(i,1);
				if(temp.equals(roomt))			 {
					Object ob[]={model3.getValueAt(i,0)};
					model2.addRow(ob);
                }
			}
   } // mouseClicked end
	
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}

	public void actionPerformed(ActionEvent e)
	{
	   Object ob=e.getSource();
		if(ob==creatB)	 {
		  title=JOptionPane.showInputDialog(this,"방제목을 입력하세요",
				  "방제목 입력",JOptionPane.YES_NO_OPTION);
	  
		  if (title==null||title.length()<1)
				  return;
		  try{
				  out.write(("200|"+title+"\n").getBytes());
			}catch(Exception ex){}
	    }// if

		 if(ob==roominB)			{
		    int row=table1.getSelectedRow();
			if(row<0)				{
				JOptionPane.showMessageDialog(this,"방을먼저 선택하세요");
				return;
			}
			title=(model1.getValueAt(row,0)).toString();
			try{
				   out.write(("210|"+title+"\n").getBytes());
			    }catch(Exception ex){}
		 } //if

		 if(ob==client.tf)			{
			String msg=client.tf.getText().trim();
			if(msg.length()<1)
				 return;
			try {
				out.write(("400|"+msg+"\n").getBytes());
			    }catch(Exception ex){}
			client.tf.setText(null);
		} //if

		 if(ob==client.outB)		{
			requestRoomOut();
		}
		 
		if(ob==client.nickB)		{
			String n=JOptionPane.showInputDialog(client,
					  "변경할 대화명을 입력하세요","대화명 입력",
					  JOptionPane.YES_NO_OPTION);
			if (n==null||n.length()<1)
			   return;
			try{
				out.write(("420|"+n+"\n").getBytes());
			 }catch(Exception ex){}
		}
			
		 if(ob==client.sayB)		 {	
			int row=client.table1.getSelectedRow();
			if(row<0)				{
				JOptionPane.showMessageDialog(client,
						"귀속말을 보낼상대를 선택하세요");
						return;
			}
			String sayN=(client.model1.getValueAt(row,0)).toString();
			  String say=JOptionPane.showInputDialog(client,
					  "전하고 싶은말을 입력하세요","귓속말",
					  JOptionPane.YES_NO_OPTION);
			    if (say==null||say.length()<1)
				     return;
				try{
					 out.write(("450|"+sayN+"|"+say+"\n").getBytes());
					 client.ta.append("[귓속말(to)]"+sayN+">>"+say+"\n");
				   }catch(Exception ex){}
			} //if

		if(ob==exitB)		 {
			 closeProcess();
		}
	} //actionPerformed end

	public void connectProcess()	{
	   try{
		 s=new Socket(host,5555);
		 in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		 out = s.getOutputStream();
		 out.write((name+"\n").getBytes());
		 new Thread(this).start();  //run() 메서드 호출
	   }catch(Exception ex){System.out.println("서버연결 실패!");}
	}
	
  public	void requestRoomOut()	{
	    try{	
			  out.write(("290|\n").getBytes());
			 }catch(Exception ex){}
		 title="대기실";
	}

  public void closeProcess()	{
	   try{
			client.setVisible(false);
			out.write(("900|\n").getBytes());
			s.close();
			in.close();
			out.close();
		  }catch(Exception ex){}
	}

	public void run()	{
	   while(true)		 {  
		   try{
			  String msg=in.readLine();
			  if(msg==null)
				  return;
			  StringTokenizer st=new StringTokenizer(msg,"|");
	     	  int protocol=Integer.parseInt(st.nextToken());
			  
			  switch(protocol)			   {
				  case 100:{
				      String ob[]={st.nextToken(),st.nextToken()};
				      model3.addRow(ob);
					 break;} //case 100
				  
	              case 200:{
				      String ob[]={st.nextToken(),st.nextToken()};
				      model1.addRow(ob);
					 break;} //case 200
	              
	              case 205:{
				     String n=st.nextToken();
				     String t=st.nextToken();
					 for(int i=0;i<model3.getRowCount();i++)  {  
						 String temp=(String)model3.getValueAt(i,0);
						 if(temp.equals(n))	 {
							 model3.setValueAt(t,i,1);
							 break;
						 }
					} //for

					for(int i=0;i<model1.getRowCount();i++)	{
						String temp=(String)model1.getValueAt(i,0);
						if(temp.equals(t))	{
							int inwon=Integer.parseInt(
									model1.getValueAt(i,1).toString());
							model1.setValueAt(++inwon+"",i,1);
							//inwon이 int이므로 +""해서 object화 한다
							//===>Integer.toSting(++inwon)
						     break;  
					    }
					} //for

					if(n.equals(name)) {   //내가 들어갈때
						roomInProcess();
					}
					else if(t.equals(title)) {  //내방에 다른사람이 들어왔을때
						 Object ob[]={n};
						 client.model1.addRow(ob);
                  	     client.inwon.setText(
                  	    		  Integer.toString(client.model1.getRowCount()));
						 client.ta.append("*** [ "+n+" ]님이 입장하였읍니다 ***\n");}
						 break;
					 }// case 205
	              
				  	 case 400:
              		    client.ta.append("   "+st.nextToken()+"\n");
						break;
						
					 case 290:			 { 
						String n=st.nextToken();
						String t=st.nextToken();
			    		for(int i=0;i<model1.getRowCount();i++)	{
							String temp=(String)model1.getValueAt(i,0);
							if(temp.equals(t))	{
							    int inwon=Integer.parseInt(
									  model1.getValueAt(i,1).toString());
								if (inwon==1)
									 model1.removeRow(i);
								else
									 model1.setValueAt(--inwon+"",i,1);
									//inwon이 int이므로 +""해서 object화 한다
									//===>Integer.toSting(++inwon)
								break;  
							 }//if
						 } // for   //model1에서 인원정보 갱신

						for(int i=0;i<model3.getRowCount();i++)	{
							String temp=(String)model3.getValueAt(i,0);
							if(temp.equals(n))	 {  
								model3.setValueAt("대기실",i,1);
								break; 
							}  
						} // for //model3에서 위치정보 갱신
							
						if(n.equals(name))  //내가 나갈경우 
						  roomOutProcess();
							
                     if(t.equals(title))  { //내방에서 나간 경우
					     for(int i=0;i<client.model1.getRowCount();i++)    {
							String temp=(String)client.model1.getValueAt(i,0);
							if(temp.equals(n))	{ 
								client.model1.removeRow(i);
								break;
							}
     					} //for
           				client.inwon.setText(Integer.toString(
           						client.model1.getRowCount()));
						client.ta.append("*** [ "+n+" ]님이 퇴장하였읍니다 ***\n");	
	                 } //if						
				 } // case 290
				 break;
				     
				 case 420:	   {
					  String oldN=st.nextToken();
					  String newN=st.nextToken();
					  String t=st.nextToken();

					  for(int i=0;i<model3.getRowCount();i++)	 {
						 String N=(String)model3.getValueAt(i,0);
						 if(oldN.equals(N))		 {
							model3.setValueAt(newN,i,0);
						    break;
						 }
					  }// for

					  if(t.equals(title)) { //내방안에 있는 사람의 대화명이 바뀐 경우
						  for(int i=0;i<client.model1.getRowCount();i++)   {
							  String N=(String)client.model1.getValueAt(i,0);
							  if(oldN.equals(N)) {
								 client.model1.setValueAt(newN,i,0);
						         break;
							   }
						  } //for
							
						  client.ta.append("   *** [ "+name+" ]님의 대화명이 ["+newN+"]로 바뀌었습니다 ***\n");	
					  } // if
	                
					  if(oldN.equals(name))
						  name=newN;
					} // case 420
					break;

				     case 450: 		   {
					     String n=st.nextToken();
						 String str=st.nextToken();
						 client.ta.append("[귓속말(from)]"+n+">>"+str+"\n");
					   } // case 450
					   break;
				     
					  case 900:   {
						 String n=st.nextToken();
						 String t=st.nextToken();
						 for(int i=0;i<model3.getRowCount();i++)	{
							String temp=(String)model3.getValueAt(i,0);
							if(temp.equals(n))			{
							   model3.removeRow(i);
							   break;
							}
						 }// for

						if(!t.equals("대기실")) {  //대화중에 나간 경우
							 for(int i=0;i<model1.getRowCount();i++)  {
							    String temp=(String)model1.getValueAt(i,0);
								if(temp.equals(t)) 		{
									int a=Integer.parseInt(
											(model1.getValueAt(i,1)).toString());
									if(--a==0)
										model1.removeRow(i);
									else
									    model1.setValueAt(a+"",i,1);
										break;
								}  // if 
							  } // for
							} // if

						  if(t.equals(title)) {  //내방에서 나간경우
							 for(int i=0;i<client.model1.getRowCount();i++)   {
								String temp=(String)client.model1.getValueAt(i,0);
								if(temp.equals(n))	{ 
									client.model1.removeRow(i);
									break;
								}
     						 } // for
           				     client.inwon.setText(
           						Integer.toString(client.model1.getRowCount()));
     					     client.ta.append("   *** [ "+n+" ]님이 퇴장하였읍니다 ***\n");	
	                      } // if						
					  } // case 900
					  break;
				} // switch
				}catch(Exception ex){System.out.println("서버와 연결실패!");
				return;}
			} // while
		}	// run
			
	public void roomOutProcess()	{
		client.ta.setText("");
		client.inwon.setText("");
		for(int i=0;i<client.model1.getRowCount();i++)  {
			client.model1.removeRow(0);
		}
		client.model1.setRowCount(0);	
			
		client.inwon.setText(Integer.toString(client.model1.getRowCount()));
		client.setVisible(false);
		creatB.setEnabled(true);
		roominB.setEnabled(true);
	}  // roomOutProcess

	public void roomInProcess()	{
	    client.setVisible(true);
		client.ta.append("   *** [ "+title+" ]방에 입장하였읍니다 ***\n");
		for(int i=0;i<model3.getRowCount();i++)	 {
			String temp=(String)model3.getValueAt(i,1);
			if(temp.equals(title))	{
				Object ob[]={model3.getValueAt(i,0)};
				client.model1.addRow(ob);
			 }
		} // for

	  client.inwon.setText(Integer.toString(client.model1.getRowCount()));
      roominB.setEnabled(false);
      creatB.setEnabled(false);
	} // roomInProcess

  public static void main(String args[]) {
	 String ip = JOptionPane.showInputDialog("server ip는 ?"); 
	 new MainClient(ip);
  }
}