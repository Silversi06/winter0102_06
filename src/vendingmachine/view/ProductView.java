package vendingmachine.view;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vending_machine.ProductVO;

public class ProductView {
	ArrayList<ProductVO> productList;
	ArrayList<JLabel> lblList = new ArrayList<JLabel>();
	
	
	public JPanel displayProducts() {
		JPanel panC = new JPanel(new GridLayout(3,3));
		for(ProductVO vo  : productList) {
			ImageIcon icon = new ImageIcon("images/"+vo.getImageName()+".jpg");
			JLabel lbl = new JLabel(icon);
			lblList.add(lbl);
			panC.add(lbl);
		}
		return panC;
		
	}
	public void inputPurchase() {
		
	}
	
	public void setProductList(ArrayList<ProductVO>productList) {
		this.productList = productList;
	}

}
