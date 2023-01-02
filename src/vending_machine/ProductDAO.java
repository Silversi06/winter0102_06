package vending_machine;

import java.util.ArrayList;

import vending_machine.ProductVO;

public class ProductDAO {
	
	ArrayList<ProductVO> productList = new ArrayList<ProductVO>();

	//insert: ArrayList 에 학생정보객체(StudentVO)를 추가하는 메서드
	public void insert(ProductVO vo) {
		productList.add(vo);
	}
	
	//select:전체 학생정보객체들을 반황하는 메서드
	public ArrayList<ProductVO> select(){
		return productList;
	}

}
