package main;

import javax.swing.*;

public class Main {

	/**
	 * @param args
	 */
	//Allows the user to select the operation and input values with JOptionPane
	public static void main(String[] args) {
		Object[] options = {"int to binary","binary to int", "String to binary", "binary calculator"};
		int z = JOptionPane.showOptionDialog(null, "1   1   1   1   1   1   1   1\n2^7 2^6 2^5 2^4 2^3 2^2 2^1 2^0\n128 + 64 + 32 + 16 + 8 + 4 + 2 + 1\n\nselect an action:", "options",
		        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
		if(z==0){
			int x = Integer.valueOf(JOptionPane.showInputDialog(null, "Input int 1 to 255"));
			JOptionPane.showMessageDialog(null, x + "\n" + binaryToString(intToBinary(x)) + "\n" +intToBinaryString(x));
		}
		else if(z==2){
			String s = JOptionPane.showInputDialog(null, "Input String with only lowercase Latin letters");
			  byte[] bytes = s.getBytes();
			  StringBuilder binary = new StringBuilder();
			  for (byte b : bytes)
			  {
			     int val = b;
			     for (int i = 0; i < 8; i++)
			     {
			        binary.append((val & 128) == 0 ? 0 : 1);
			        val <<= 1;
			     }
			     binary.append(' ');
			  }
			  JOptionPane.showMessageDialog(null, s + "\n" + binary);
			  System.out.println("'" + s + "' to binary: " + binary);
		}
		else if(z==1){
			String x = JOptionPane.showInputDialog(null, "Input 8 bit binary");
			JOptionPane.showMessageDialog(null, x + "\n" + binaryToString(Integer.valueOf(x)) + "\n" + binaryToInt(Integer.valueOf(x)));
		}
		else{
			JOptionPane.showMessageDialog(null, binaryCalculator());
		}
	
	}
	
	//converts a binary number to a decimal integer
	private static int binaryToInt(int b){
		int bin = b;
		int ret = 0;
		int x = 10000000;
		int y = 128;
		while(bin>=1){
			if(bin>=x){
				System.out.println(bin);
				bin%=x;
				ret+=y;
				x/=10;
				y/=2;
				System.out.println(ret);
			}
			else{
				System.out.println(bin);
				bin%=x;
				x/=10;
				y/=2;
				System.out.println(ret);
			}
		}
		return ret;
	}
	
	//converts a binary number to a string decimal representation
	private static String binaryToString(int b){
		int bin = b;
		String ret = "";
		int x = 10000000;
		int y = 128;
		while(bin>=1){
			if(bin>=x){
				bin%=x;
				ret+=y;
				if(bin>=1){
					ret+=" + ";
				}
				x/=10;
				y/=2;
			}
			else{
				bin%=x;
				x/=10;
				y/=2;
			}
		}
		ret+= " = " + binaryToInt(b);
		return ret;
	}
	
	//converts a binary number to a string decimal represention with 8 digits
	private static String binaryToStringAlt(int b){
		int bin = b;
		String ret = "";
		int x = 10000000;
		int y = 128;
		while(bin>=1){
			if(bin>=x){
				bin%=x;
				ret+=y;
				x/=10;
				y/=2;
			}
			else{
				ret+="0";
				bin%=x;
				x/=10;
				y/=2;
			}
			ret+=" ";
		}
		return ret;
	}
	
	//converts a decimal integer to 8 bit binary
	private static int intToBinary(int b){
		int bin = b;
		int ret = 0;
		int x = 10000000;
		int y = 128;
		while(y>=1){
			if(bin>=y){
				System.out.println(bin);
				bin%=y;
				ret+=x;
				x/=10;
				y/=2;
				System.out.println(ret);
			}
			else{
				System.out.println(bin);
				bin%=y;
				x/=10;
				y/=2;
				System.out.println(ret);
			}
		}
		return ret;
	}
	
	//converts a decimal int to a binary string representation
	private static String intToBinaryString(int b){
		int bin = b;
		String ret = "";
		int x = 10000000;
		int y = 128;
		while(y>=1){
			if(bin>=y){
				System.out.println(bin);
				bin%=y;
				ret+="1";
				x/=10;
				y/=2;
				System.out.println(ret);
			}
			else{
				System.out.println(bin);
				ret+="0";
				bin%=y;
				x/=10;
				y/=2;
				System.out.println(ret);
			}
		}
		return ret;
	}
	
	//performs calculations on binary numbers depending on user input
	private static String binaryCalculator(){
		String ret = "";
		Object[] options = {"add","subtract", "multiply"};
		int z = JOptionPane.showOptionDialog(null, "select operation:", "options",
		        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
		if(z==0){
			int on = binaryToInt(Integer.valueOf(JOptionPane.showInputDialog(null, "Input 8 bit binary less than 10000000")));
			ret+=intToBinaryString(on) + " + ";
			String f = intToBinaryString(255-on);
			int tw = binaryToInt(Integer.valueOf(JOptionPane.showInputDialog(null, "Input 8 bit binary less than "+f)));
			ret+=intToBinaryString(tw)+ " = ";
			on+=tw;
			if(on>255||on<1){
				on=255;
			}
			ret+=intToBinaryString(on);
		}
		else if(z==1){
			int on = binaryToInt(Integer.valueOf(JOptionPane.showInputDialog(null, "Input 8 bit binary")));
			ret+=intToBinaryString(on)+" - ";
			int tw = binaryToInt(Integer.valueOf(JOptionPane.showInputDialog(null, "Input 8 bit binary less than previous input")));
			ret+=intToBinaryString(tw)+" = ";
			on-=tw;
			if(on>255||on<1){
				on=255;
			}
			ret+=intToBinaryString(on);
		}
		else{
			int on = binaryToInt(Integer.valueOf(JOptionPane.showInputDialog(null, "Input 8 bit binary less than 10000000")));
			ret+=intToBinaryString(on)+" x ";
			String f = intToBinaryString(255/on);
			int tw = binaryToInt(Integer.valueOf(JOptionPane.showInputDialog(null, "Input 8 bit binary less than " + f)));
			ret+=intToBinaryString(tw)+ " = ";
			on*=tw;
			if(on>255||on<1){
				on=255;
			}
			ret+=intToBinaryString(on);
		}
		return ret;
	}
}
