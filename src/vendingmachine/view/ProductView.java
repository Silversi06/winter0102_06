package vendingmachine.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vending_machine.ProductVO;

public class ProductView {
	ArrayList<ProductVO> productList;
	ArrayList<JLabel> lblList = new ArrayList<JLabel>();
	JTextField insertTf = new JTextField(15);
	JLabel lblResult = new JLabel();
	JFrame frame;
	ProductVO vo;
	JLabel eLbl;
	
	public JPanel displayProducts(JFrame frame) {
		this.frame= frame;
		JPanel panC = new JPanel(new GridLayout(3,3));
		JPanel pan = null;
		JLabel lblPrice = null;
		for(ProductVO vo  : productList) {
			ImageIcon icon = new ImageIcon("images/"+vo.getImageName()+".jpg");
			JLabel lbl = new JLabel(icon);
			lbl.setOpaque(true);
			lbl.setBackground(Color.WHITE);
			lbl.addMouseListener(lblL);
			lblList.add(lbl);
			lblPrice = new JLabel(vo.getPrice()+"��",JLabel.CENTER);
			lblPrice.setFont(new Font("�߰��",Font.BOLD,15));
			lblPrice.setOpaque(true);
			lblPrice.setBackground(new Color(232,217,255));
			pan = new JPanel(new BorderLayout());
			pan.add(lbl, "Center");
			pan.add(lblPrice, "South");
			panC.add(lbl);
		}
		return panC;
		
	}
	public JPanel inputPurchase() {
		JPanel panS = new JPanel();
		JLabel lblMoney = new JLabel("�ݾ� : ");
		
		JButton btnInsert = new JButton("����");
		btnInsert.addActionListener(btnL);
		panS.add(lblMoney); panS.add(insertTf); panS.add(btnInsert);
		panS.add(lblResult);
		return panS;
	}
	
	public void setProductList(ArrayList<ProductVO>productList) {
		this.productList = productList;
	}

	MouseAdapter lblL = new MouseAdapter() {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
			for(int i=0; i<lblList.size(); i++) {
				if(e.getSource()==lblList.get(i)) {
					vo = productList.get(i);
				}
			}
			JOptionPane.showMessageDialog(frame, "��ǰ�� : "+vo.getName()+"��ǰ���� : "+vo.getPrice()+"��");
		}
	};
	
	ActionListener btnL = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
//			���Թ�ư�� Ŭ���Ǿ��� ��
//			JTextField�� �Էµ� �ݾװ� ���� �ݾ��� ���Ͽ� ����̻��̸� ��ǰ�� �Ž������� ������
//			�ݾ��� �����ϸ� �����ϴٰ� ����Ͽ� �ٽ� �ݾ��� �Է��� �� �ְ���
			int money = Integer.parseInt(insertTf.getText());
			if(money >= vo.getPrice()) {
				ImageIcon icon = new ImageIcon("images/"+vo.getImageName()+".jpg");
				lblResult.setIcon(icon);
				JOptionPane.showMessageDialog(frame,"�Ž����� : "+(money-vo.getPrice())+"��");
				//lblResult.setText(vo.getName()+"��ǰ ����, �Ž����� "+(money-vo.getPrice())+"��");
			}else {
				lblResult.setText("�ݾ��� �����մϴ�.");
			}
			insertTf.setText("");
			eLbl.setBackground(Color.WHITE);
		}
	};
}
