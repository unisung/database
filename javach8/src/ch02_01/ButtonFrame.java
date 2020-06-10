package ch02_01;

import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;



public class ButtonFrame {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);
		Container  container = frame.getContentPane();
        frame.setSize(new Dimension(300, 400));
        
        JPanel panel = new JPanel();
        JButton button = new JButton("버튼");
        panel.add(button);
        container.add(panel);
        
        frame.setVisible(true);
        button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "버튼클릭");
			}
		});
		
	}
}
