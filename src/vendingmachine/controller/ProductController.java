package vendingmachine.controller;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vending_machine.ProductDAO;
import vending_machine.ProductVO;
import vendingmachine.view.ProductView;

public class ProductController extends JFrame{
	
	public static final int STOP =0;
	ArrayList<ProductVO> productList;
	

	public ProductController() {
		ProductView view = new ProductView();
		fullProduct();
		view.setProductList(productList);
		//view.displayProducts();
		JPanel panC= view.displayProducts(this);
		JPanel panS = view.inputPurchase();
		add(panC,"Center");
		add(panS,"South");
		
		
		setTitle("�������Ǳ�");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100,50,600,600);
		setVisible(true);
		
	}
	
	public void fullProduct() {
		ProductDAO dao = new ProductDAO();
		String[]names = {"���ڿ�","�������","��Ÿ500","���̴�","�������ֽ�","�ʷϸŽ�","�ݶ�","Ƽ��","�����꽺"};
		int [] prices = {2200,1000,700,1000,1500,1000,1000,2000,1500}; 
		ProductVO vo = null;
		productList = dao.select();
		for (int i=0; i<names.length; i++) {
			vo = new ProductVO();
			vo.setName(names[i]);
			vo.setPrice(prices[i]);
			vo.setProductNum(i);
			vo.setStockNum(10);
			vo.setImageName("drink"+(i+1));
			productList.add(vo);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ProductController();
		
		
		
		}
			
}

