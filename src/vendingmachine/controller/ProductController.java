package vendingmachine.controller;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
		JPanel panC= view.displayProducts();
		add(panC,"Center");
		
		
		setTitle("�������Ǳ�");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100,50,600,600);
		setVisible(true);
		
	}
	
	public void fullProduct() {
		ProductDAO dao = new ProductDAO();
		String[]names = {"���̴�","�ݶ�","��Ÿ500","Ƽ��","�ʷϸŽ�","�����꽺","���ڿ�","�������","�������꽺"};
		int [] prices = {700,900,900,2100,1600,1500,2200,1000,2000};
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

