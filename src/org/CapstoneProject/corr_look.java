package org.CapstoneProject;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class corr_look extends JPanel implements ActionListener, MouseListener {

   public static String bus_num;
   private JLabel corr_regist, corr_lookup, corr_lookup2, pur_regist, Lcorr_no, Lcorr_nm, Lcorr_prnm, Lcorr_ph, Lcorr_addr; 
   private JTextField  Tsearch;      
         
   private String[] col1 = {"��ü��ȣ", "��ü��", "��ǥ��", "����ó", "�ּ�", ""};  
   private String[] search = {"��ü��ȣ", "��ü��", "��ǥ��"};       
   
   private DefaultTableModel model1 = new DefaultTableModel(col1, 0);
   
   private JTable corr_info;
   private JScrollPane scrollpane1;
         
   private JButton Bsearch,Breset, jb; 
   
   private JComboBox<String> cbSearch;      
         
   GridBagLayout gridbaglayout;      
   GridBagConstraints gridbagconstraints;      // gridbag���̾ƿ��� ������Ʈ�� ��ġ�� ����ִ� ����
         
   public corr_look() {      
         
         gridbaglayout = new GridBagLayout();
         gridbagconstraints = new GridBagConstraints();
         
         corr_regist = new JLabel("�ŷ�ó���");
         corr_regist.addMouseListener(this);
         corr_regist.setPreferredSize(new Dimension(200,28));
         corr_lookup = new JLabel("�ŷ�ó��ȸ");
         corr_lookup.setPreferredSize(new Dimension(200,28));
         corr_lookup2 = new JLabel("�ŷ�ó��ȸ");
         corr_lookup2.setPreferredSize(new Dimension(200,28));
         pur_regist = new JLabel("���ŵ��");
         pur_regist.setPreferredSize(new Dimension(200,28));
         
         Lcorr_no = new JLabel("��ü��ȣ");
         Lcorr_no.setPreferredSize(new Dimension(100,30));
         Lcorr_nm = new JLabel("��ü��");
         Lcorr_nm.setPreferredSize(new Dimension(100,30));
         Lcorr_prnm = new JLabel("��ǥ��");
         Lcorr_prnm.setPreferredSize(new Dimension(100,30));
         Lcorr_ph = new JLabel("����ó");
         Lcorr_ph.setPreferredSize(new Dimension(100,30));
         Lcorr_addr = new JLabel("�ּ�");
         Lcorr_addr.setPreferredSize(new Dimension(100,30));
         
         Tsearch = new JTextField(18);
         Tsearch.setPreferredSize(new Dimension(100,30));
         
         cbSearch = new JComboBox<String>(search);
         cbSearch.setPreferredSize(new Dimension(200,28));
         
         corr_info = new JTable(model1);
         scrollpane1 = new JScrollPane(corr_info);
         scrollpane1.setPreferredSize(new Dimension(1000, 300));
         
         Bsearch = new JButton("�˻�");
         Bsearch.setPreferredSize(new Dimension(200,28));
         Breset = new JButton("�ʱ�ȭ");
         Breset.setPreferredSize(new Dimension(200,28));
         
         corr_info.getColumnModel().getColumn(5).setCellRenderer(new TableCell());
         corr_info.getColumnModel().getColumn(5).setCellEditor(new TableCell());
      	   
         EmpRegisterView();
    }
   
   private void getData(List<Map<String, Serializable>> corrListData) {

	      for(int i=0; i < corrListData.size(); i++) {
	         model1.addRow(new Object[] {
	               
	               corrListData.get(i).get("BUS_NUM"),
	               corrListData.get(i).get("BUS_NM"),
	               corrListData.get(i).get("REP_NM"),
	               corrListData.get(i).get("BUS_TEL"),
	               corrListData.get(i).get("ADDR")

	         });
	      }


	   }
         
    private void EmpRegisterView() {      
         
//         setTitle("�ŷ�ó��ȸ");
         
         gridbagconstraints.anchor = GridBagConstraints.WEST;
//         gridbagconstraints.ipadx = 7;
//         
//         gridbagconstraints.weightx=1.0;
//         gridbagconstraints.weighty=1.0;
         
         setLayout(gridbaglayout);
         gridbagconstraints.anchor = GridBagConstraints.CENTER;
         
         gridbagAdd(scrollpane1, 1, 3, 5, 5);
         
         gridbagconstraints.anchor = GridBagConstraints.WEST;
         
         gridbagAdd(Tsearch, 2, 2, 1, 1);
         gridbagAdd(cbSearch, 1, 2, 1, 1);
         gridbagAdd(corr_lookup2, 1, 1, 1, 1);
         gridbagAdd(Bsearch, 3, 2, 1, 1);
         
         gridbagconstraints.anchor = GridBagConstraints.EAST;
         gridbagAdd(Breset, 4, 2, 1, 1);

//         setResizable(true);
         getData(corrData.selectcorr());
         setVisible(true);
      }   
         
      private void gridbagAdd(Component c, int x, int y, int w, int h) {   
         
         gridbagconstraints.gridx = x;
         gridbagconstraints.gridy = y; 
            //���� ���� �� gridx, gridy���� 0    
         
         gridbagconstraints.gridwidth  = w;
         gridbagconstraints.gridheight = h;
              
               
          gridbaglayout.setConstraints(c, gridbagconstraints); //������Ʈ�� ������Ʈ ��ġ+ũ�� ������ ���� GridBagLayout�� ��ġ   
         
         add(c);   
         
         }   
         
      public static void main(String[] args) {   
         new corr_look();
      }

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource() == corr_regist) {

	      }
		
		int row = corr_info.getSelectedRow();
		int column = corr_info.getSelectedColumn();
		bus_num = (String) corr_info.getValueAt(row, column);
		
	}
	
	class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer{
        
        public TableCell() {
            // TODO Auto-generated constructor stub
            jb = new JButton("������ȸ");
            jb.addActionListener(e -> {
    			pur_list s = new pur_list(new JFrame());
            });
         
        }
         
        @Override
        public Object getCellEditorValue() {
            // TODO Auto-generated method stub
            return null;
        }
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            // TODO Auto-generated method stub
            return jb;
        }
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                int column) {
            // TODO Auto-generated method stub
            return jb;
        }
         
    }

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}   
         
}