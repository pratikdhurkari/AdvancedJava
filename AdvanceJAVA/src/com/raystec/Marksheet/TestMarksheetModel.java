package com.raystec.Marksheet;

import java.util.ArrayList;
import java.util.Iterator;

public class TestMarksheetModel {

	public static void main(String[] args) throws Exception {

//		 testAdd();
//		testDelete();
//		testUpdate();
//		testGetById();
//		testSelect();
//		testMerit();

	}
	
	
private static void testMerit() throws Exception {
		
		MarksheetBean bean = new MarksheetBean();
		
				MarksheetModel model = new MarksheetModel();
		
				ArrayList l = new ArrayList();
				
				
				l = (ArrayList) model.Merit(bean);
			
				Iterator it = l.iterator();
				
				while (it.hasNext()) {
					MarksheetBean bean1 = (MarksheetBean) it.next();
					System.out.print(bean1.getId());
					System.out.print("\t"+bean1.getRollno());
					System.out.print("\t"+bean1.getFname());
					System.out.print("\t\t"+bean1.getLname());
					System.out.print("\t"+bean1.getPhy());
					System.out.print("\t"+bean1.getChem());
					System.out.print("\t"+bean1.getMath());
					System.out.print("\t"+bean1.getTotal());
					System.out.println("\t"+bean1.getPercentage());
					
				}
				
	}
	
	private static void testSelect() throws Exception {
		
		MarksheetBean bean = new MarksheetBean();
		
				MarksheetModel model = new MarksheetModel();
		
				ArrayList l = new ArrayList();
				
				
				l = (ArrayList) model.Select(bean);
			
				Iterator it = l.iterator();
				
				while (it.hasNext()) {
					MarksheetBean bean1 = (MarksheetBean) it.next();
					System.out.print(bean1.getId());
					System.out.print("\t"+bean1.getRollno());
					System.out.print("\t"+bean1.getFname());
					System.out.print("\t"+bean1.getLname());
					System.out.print("\t"+bean1.getPhy());
					System.out.print("\t"+bean1.getChem());
					System.out.println("\t"+bean1.getMath());
				}
				
	}
	
	

	private static void testGetById() throws Exception {
	
		MarksheetBean bean = new MarksheetBean();
		
				bean.setRollno(1210);
		
				MarksheetModel model = new MarksheetModel();
		
				MarksheetBean bean1 = model.GetById(bean);
			

				System.out.print(bean1.getId());
				System.out.print("\t"+bean1.getRollno());
				System.out.print("\t"+bean1.getFname());
				System.out.print("\t"+bean1.getLname());
				System.out.print("\t"+bean1.getPhy());
				System.out.print("\t"+bean1.getChem());
				System.out.println("\t"+bean1.getMath());
				
	
	}

	private static void testUpdate() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		
				bean.setId(10);
				bean.setLname("Jaiswal");
				MarksheetModel model = new MarksheetModel();
		
				model.Update(bean);
		
	}

	private static void testDelete() throws Exception {
		MarksheetBean bean = new MarksheetBean();

		bean.setId(11);
		MarksheetModel model = new MarksheetModel();

		model.Delete(bean);
	}

	private static void testAdd() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setRollno(1212);
		bean.setFname("Raj");
		bean.setLname("Sharma");
		bean.setPhy(30);
		bean.setChem(39);
		bean.setMath(41);

		MarksheetModel model = new MarksheetModel();

		model.Add(bean);

	}
}
