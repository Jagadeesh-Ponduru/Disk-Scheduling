package diskscheduling;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class disk extends JFrame {

	private JPanel contentPane;
	private JTextField num;
	private JTextField num1;
	private JTextField out1;
	private JTextField out;
	private JTextField in;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					disk frame = new disk();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public disk() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 287);
		contentPane = new JPanel();
		contentPane.setBackground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnFcfs = new JButton("FCFS");
		btnFcfs.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnFcfs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random R=new Random();
				int n=Integer.parseInt(num.getText());
				int i,j,k=0,hm=0,sum=0;
				int input[]=new int[100];
				System.out.println("Give input values");
				String t="";
				for(i=1;i<=n;i++)
				{
					input[i]=R.nextInt(200-1)+1;
					System.out.println(input[i]);
					t=t+input[i]+" ";
				}
				in.setText(t);
				int h=Integer.parseInt(num1.getText());
				input[0]=h;
				String s=""+h+" ";
		System.out.println("output:");
				for(i=1;i<=n;i++)
				{
					s=s+input[i]+" ";
					System.out.println(input[i]);
					hm=h-input[i];
					h=input[i];
					sum=sum+Math.abs(hm);
				}
				System.out.println("total head movements ="+sum);
			out.setText(s);
			out1.setText(""+sum);
			Graph g=new Graph(input,n+1);
			g.test(input,n+1);

			}
		});
		btnFcfs.setBounds(164, 45, 89, 23);
		contentPane.add(btnFcfs);
		
		JButton btnSstf = new JButton("SSTF");
		btnSstf.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnSstf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a[]=new int[100];
				int b[]=new int[100];
				int d,n,i,j;
				int temp,s,k=0,x=0,t=0;
				String T="";
Random R=new Random();
				  a[0]=Integer.parseInt(num1.getText());
				 n=Integer.parseInt(num.getText());
				 System.out.println("Enter processes in request order");
				 for(i=1;i<=n;i++)
				 {
				  a[i]=R.nextInt(200-1)+1;
				  System.out.println("Queue = "+a[i] );
				  T=T+a[i]+" ";
				 }
				 in.setText(T);
				 b[k++]=a[0];
				 for(i=0;i<n;i++)
				 {
				  s=1000;
				  for(j=i+1;j<=n;j++)
				  {
				   if(a[i]>a[j])
				   d=a[i]-a[j];
				   else
				   d=a[j]-a[i];
				   if(d<s)
				   {
				    s=d;
				    x=j;
				   }
				  }
				  t+=s;
				  temp=a[i+1];
				  a[i+1]=a[x];
				  a[x]=temp;
				  b[k++]=a[i+1];
				 }
				 String S="";
				 System.out.println("output:");
				 for(i=0;i<=n;i++)
				 {
					 S=S+b[i]+" ";
				 System.out.println(b[i]);
				 }
				 System.out.println("total head movements = "+t);
				 out.setText(S);
				 out1.setText(""+t);
				 Graph g=new Graph(b,n+1);
					g.test(b,n+1);
			}
		});
		btnSstf.setBounds(164, 79, 89, 23);
		contentPane.add(btnSstf);
		
		JButton btnScan = new JButton("SCAN");
		btnScan.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnScan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ){
				Random R=new Random();
				int n=Integer.parseInt(num.getText());
				int i,j,k=0,hm=0,sum=0;
				int input[]=new int[100];
				System.out.println("Give input values");
				input[0]=0;
				String t="";
				for(i=1;i<=n;i++)
				{
					input[i]=R.nextInt(200-1)+1;
					System.out.println("Queue = "+input[i]);
				t=t+input[i]+" ";
				}
				in.setText(t);
				int h=Integer.parseInt(num1.getText());
				for(i=0;i<n;i++)
				{
					for(j=0;j<n-i;j++)
					{
						if(input[j]>input[j+1])
						{
							int temp=input[j];
							input[j]=input[j+1];
							input[j+1]=temp;
						}
					}
				}
				for(i=0;i<=n;i++)
				{
					if(h>=input[i])
					{
						k=i+1;
					}
				}
				String s=""+h+" ";
				int p=1;
				int output[]=new int[20];
				output[0]=h;
				System.out.println("output:");
				for(i=k-1;i>=0;i--)
				{
					output[p]=input[i];
					p++;
					s=s+input[i]+" ";
					System.out.println(input[i]);
					hm=h-input[i];
					h=input[i];
					sum=sum+Math.abs(hm);
				}
				
				for(i=k;i<=n;i++)
				{
					output[p]=input[i];
					p++;
					s=s+input[i]+" ";
					System.out.println(input[i]);
					hm=h-input[i];
					h=input[i];
					sum=sum+Math.abs(hm);
				}
				
				System.out.println("head movements = "+sum);
				out.setText(s);
				out1.setText(""+sum);
				Graph g=new Graph(output,p);
				g.test(output,p);				
			}
		});
		btnScan.setBounds(164, 113, 89, 23);
		contentPane.add(btnScan);
		
		JButton btnCscan = new JButton("C-SCAN");
		btnCscan.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnCscan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n=Integer.parseInt(num.getText());
				int i,j,k=0,sum=0,hm=0;
				int input[]=new int[100];
				Random R=new Random();
				System.out.println("Give input values");
				input[0]=0;
				input[n+1]=199;
				String t="";
				for(i=1;i<=n;i++)
				{
					input[i]=R.nextInt(200-1)+1;
                     System.out.println("Queue = "+input[i]);
                     t=t+input[i]+" ";
				}
				in.setText(t);
				int h=Integer.parseInt(num1.getText());
				for(i=0;i<n;i++)
				{
					for(j=0;j<n-i;j++)
					{
						if(input[j]>input[j+1])
						{
							int temp=input[j];
							input[j]=input[j+1];
							input[j+1]=temp;
						}
					}
				}
				for(i=0;i<=n;i++)
				{
					if(h>=input[i])
					{
						k=i+1;
					}
				}
				String s=""+h+" ";
				int p=1;
				int output[]=new int[20];
				output[0]=h;
				System.out.println("output:");
				for(i=k-1;i>=0;i--)
				{
					output[p]=input[i];
					p++;
					s=s+input[i]+" ";
					System.out.println(input[i]);
					hm=h-input[i];
					h=input[i];
					sum=sum+Math.abs(hm);
				}
				for(i=n+1;i>=k;i--)
				{
					output[p]=input[i];
					p++;
					s=s+input[i]+" ";
					System.out.println(input[i]);
					hm=h-input[i];
					h=input[i];
					sum=sum+Math.abs(hm);
				}
				out.setText(s);
				out1.setText(""+sum);
				System.out.println("tatal head movements = "+sum);
				Graph g=new Graph(output,p);
				g.test(output, p);

			}
		});
		btnCscan.setBounds(164, 147, 89, 23);
		contentPane.add(btnCscan);
		
		JButton btnLook = new JButton("LOOK");
		btnLook.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnLook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n=Integer.parseInt(num.getText());
				int i,j,k=0,hm=0,sum=0;
				int input[]=new int[100];
				System.out.println("Give input values");
				input[0]=0;
				Random R=new Random();
				String t="";
				for(i=1;i<=n;i++)
				{
					input[i]=R.nextInt(200-1)+1;
					System.out.println("Queue = "+input[i]);
					t=t+input[i]+" ";
				}
				in.setText(t);
				int h=Integer.parseInt(num1.getText());
				for(i=0;i<n;i++)
				{
					for(j=0;j<n-i;j++)
					{
						if(input[j]>input[j+1])
						{
							int temp=input[j];
							input[j]=input[j+1];
							input[j+1]=temp;
						}
					}
				}
				for(i=0;i<=n;i++)
				{
					if(h>=input[i])
					{
						k=i+1;
					}
				}
			String s=""+h+" ";
			int p=1;
			int output[]=new int[20];
			output[0]=h;
			System.out.println("output:");
				for(i=k-1;i>=1;i--)
				{ 
					output[p]=input[i];
					p++;
					s=s+input[i]+" ";
					System.out.println(input[i]);
					hm=h-input[i];
					h=input[i];
					sum=sum+Math.abs(hm);
				}
				for(i=k;i<=n;i++)
				{
					output[p]=input[i];
					p++;
					s=s+input[i]+" ";
					System.out.println(input[i]);
					hm=h-input[i];
					h=input[i];
					sum=sum+Math.abs(hm);
				}
				out.setText(s);
				out1.setText(""+sum);
				System.out.println(sum);
				Graph g=new Graph(output,p);
				g.test(output,p);

			}
		});
		btnLook.setBounds(164, 176, 89, 23);
		contentPane.add(btnLook);
		
		JButton btnClook = new JButton("C-LOOK");
		btnClook.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnClook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random R=new Random();
				int n=Integer.parseInt(num.getText());
				int i,j,k=0,hm=0,sum=0;
				int input[]=new int[100];
				System.out.println("Give input values");
				input[0]=0;
				String t="";
				for(i=1;i<=n;i++)
				{
					input[i]=R.nextInt(200-1)+1;
					System.out.println("Queue = "+input[i]);
					t=t+input[i]+" ";
				}
				int h=Integer.parseInt(num1.getText());
				for(i=0;i<n;i++)
				{
					for(j=0;j<n-i;j++)
					{
						if(input[j]>input[j+1])
						{
							int temp=input[j];
							input[j]=input[j+1];
							input[j+1]=temp;
						}
					}
				}
				for(i=0;i<=n;i++)
				{
					if(h>=input[i])
					{
						k=i+1;
					}
				}
				String s=""+h+" ";
				int p=1;
				int output[]=new int[20];
				output[0]=h;
				System.out.println("output:");
				for(i=k-1;i>0;i--)
				{
					output[p]=input[i];
					p++;
					s=s+input[i]+" ";
					System.out.println(input[i]);
					hm=h-input[i];
					h=input[i];
					sum=sum+Math.abs(hm);
				}
				for(i=n;i>=k;i--)
				{
					output[p]=input[i];
					p++;
					s=s+input[i]+" ";
					System.out.println(input[i]);
					hm=h-input[i];
					h=input[i];
					sum=sum+Math.abs(hm);
				}
				System.out.println("Total head movements ="+sum);
				out.setText(s);
				out1.setText(""+sum);
				Graph g=new Graph(output,p);
				g.test(output,p);
			}
		});
		btnClook.setBounds(164, 210, 89, 23);
		contentPane.add(btnClook);
		
		JLabel lblButtons = new JLabel("Buttons");
		lblButtons.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblButtons.setBounds(172, 11, 64, 23);
		contentPane.add(lblButtons);
		
		JLabel lblInputs = new JLabel("Inputs");
		lblInputs.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInputs.setBounds(39, 11, 57, 23);
		contentPane.add(lblInputs);
		
		JLabel lblOutput = new JLabel("Output");
		lblOutput.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOutput.setBounds(324, 11, 64, 23);
		contentPane.add(lblOutput);
		
		num = new JTextField();
		num.setBounds(10, 63, 86, 20);
		contentPane.add(num);
		num.setColumns(10);
		
		num1 = new JTextField();
		num1.setBounds(10, 100, 86, 20);
		contentPane.add(num1);
		num1.setColumns(10);
		
		out1 = new JTextField();
		out1.setBounds(288, 164, 124, 23);
		contentPane.add(out1);
		out1.setColumns(10);
		
		JLabel lblNoofCylinders = new JLabel("No.of Cylinders");
		lblNoofCylinders.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNoofCylinders.setBounds(10, 49, 97, 14);
		contentPane.add(lblNoofCylinders);
		
		JLabel lblHead = new JLabel("Head");
		lblHead.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblHead.setBounds(10, 83, 46, 14);
		contentPane.add(lblHead);
		
		JLabel lblTotalHeadMovments = new JLabel("Total Head Movements");
		lblTotalHeadMovments.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblTotalHeadMovments.setBounds(288, 151, 136, 14);
		contentPane.add(lblTotalHeadMovments);
		
		out = new JTextField();
		out.setBounds(288, 79, 181, 57);
		contentPane.add(out);
		out.setColumns(10);
		
		JLabel lblProccingOrder = new JLabel("Processing Order");
		lblProccingOrder.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblProccingOrder.setBounds(288, 65, 114, 14);
		contentPane.add(lblProccingOrder);
		
		in = new JTextField();
		in.setBounds(10, 149, 144, 52);
		contentPane.add(in);
		in.setColumns(10);
		
		JLabel lblRandomInputs = new JLabel("Random Inputs");
		lblRandomInputs.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblRandomInputs.setBounds(10, 131, 97, 14);
		contentPane.add(lblRandomInputs);
	}
}
