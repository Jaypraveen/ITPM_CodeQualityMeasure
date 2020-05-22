package com.service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.model.*;

public class Coupling_service {

	public ArrayList<Coupling> coupling(String code) {
		
        int count = 0;
        boolean inside_Method=false;
        int inside_Method_count=0;
        int line_Count=0;
        
        String[] m_Store=finding_methods(code).split("@");
        String m_Name=null;
        ArrayList<Coupling> list = new ArrayList<Coupling>();
        
        int insideClass =0;

        String[] lines = code.split("\\r?\\n");
        for (String line : lines) {
        	
            count++;
            String[] sample_line_txt  = line.split("\"");
            
            int regularGlobals=0;
            int recursiveGlobals=0;
            int recursive=0;
            int regularRegulars=0;
            int regularRecursives=0;
            int recursiveRegulars=0;
            int recursiveRecursives=0;
    		
            for (int i=1;i<=sample_line_txt.length;i++) {
        		
            	if(i%2==1) {
            		
            		String test =sample_line_txt[i-1];
            		
        			String str= test.replaceAll("\\s+","_");
        			
        			String rgx = "public_|protected_|private_";
            		Pattern pattern = Pattern.compile(rgx, Pattern.CASE_INSENSITIVE);
            		Matcher matcher = pattern.matcher(str);
            		while (matcher.find())
            		{
            			String txt_line1= test.replaceAll("\\s+","");
            			String txt_line2= txt_line1.replaceAll("\\)","@");
            			String txt_line3= txt_line2.replaceAll("\\{","-.X");
            			
            			String rgx1 = "@-.X"; 
                		Pattern ptrn1 = Pattern.compile(rgx1, Pattern.CASE_INSENSITIVE);
                		Matcher txt_mt1 = ptrn1.matcher(txt_line3);
                		while (txt_mt1.find())
                		{
                			String txt_line4= test.replaceAll("\\(","@@");
                			String[] sample  = txt_line4.split("@@");
                			
                			String txt_line5= sample[0].replaceAll("\\s+","_");
                			String rgx3 = "_boolean_|_byte_|_char_|_double_|_float_|_int_|_long_|_short_|_String_|_void_"; 
                    		Pattern ptrn3 = Pattern.compile(rgx3, Pattern.CASE_INSENSITIVE);
                    		Matcher txt_mt3 = ptrn3.matcher(txt_line5);
                    		while (txt_mt3.find())
                    		{
                    			String[] sample1  = (txt_line5.substring(txt_mt3.end(),txt_line5.length())).split("_");
                    			m_Name = sample1[0];
                    			inside_Method=true;
                    		}
                    		
                		}

            		}
            		
            		if(inside_Method) {
            			String rgx2 = "get|set|add"; 
                		Pattern ptrn2 = Pattern.compile(rgx2, Pattern.CASE_INSENSITIVE);
                		Matcher txt_mt2 = ptrn2.matcher(test);
                		while (txt_mt2.find())
                		{
                			boolean ch=false;
                			String test2= test.replaceAll("\\(","-.X");
                    		String rgx3 = "-.X"; 
                    		Pattern ptrn3 = Pattern.compile(rgx3, Pattern.CASE_INSENSITIVE);
                    		Matcher txt_mt3 = ptrn2.matcher(test2);
                    		while (txt_mt3.find())
                    		{
                    			ch=true;
                    		}
                    		
                    		if(ch) {
                    			regularRegulars++;
                    		}
                    		
                		}
            		}
            		
            		if(inside_Method) {
            			line_Count++;

                		String txt_line1= test.replaceAll("\\{","@@");
            			
            			String rgx1 = "@@"; 
                		Pattern ptrn1 = Pattern.compile(rgx1, Pattern.CASE_INSENSITIVE);
                		Matcher txt_mt1 = ptrn1.matcher(txt_line1);
                		while (txt_mt1.find())
                		{
                			inside_Method_count++;
                		}
                		
                		String txt_line2= test.replaceAll("\\}","@@");
            			
            			String rgx2 = "@@"; 
                		Pattern ptrn2 = Pattern.compile(rgx2, Pattern.CASE_INSENSITIVE);
                		Matcher txt_mt2 = ptrn2.matcher(txt_line2);
                		while (txt_mt2.find())
                		{
                			inside_Method_count--;
                		}
                		
                		if(inside_Method_count==0) {
                			inside_Method=false;
                			line_Count=0;
                			m_Name=null;
                			insideClass=0;
                		}else {
                			for(int k = 0; k < m_Store.length; k++) {
                				if(k%2==0) {
                					boolean check=false;
                        			
                					String txt_line3= str.replaceAll("\\(","@");
                					String txt_line4= txt_line3.replaceAll("\\+","@@");
                					String txt_line5= txt_line4.replaceAll("\\-","@@");
                					String txt_line6= txt_line5.replaceAll("\\*","@@");
                					String txt_line7= txt_line6.replaceAll("\\/","@@");
                					
                        			String rgx3 = "_"+m_Store[k]+"_|_"+m_Store[k]+"@|@@"+m_Store[k];
                            		Pattern ptrn3 = Pattern.compile(rgx3, Pattern.CASE_INSENSITIVE);
                            		Matcher txt_mt3 = ptrn3.matcher(txt_line7);
                            		while (txt_mt3.find())
                            		{
                            			check=true;
                            		}
                            		
                            		if(check) {
                            			if(m_Store[k+1]=="Global") {
                            				
                            				for(int m = 0; m < m_Store.length; m++) {
                            					if(m%2==0) {
                            						if(m_Name==m_Store[m]) {
                            							if(m_Store[m+1].equals("regular")) {
                            								regularGlobals++;
                            							}else {
                            								recursiveGlobals++;
                            							}
                            						}
                            					}
                            				}
                            				
                            			}else {
                            				if(line_Count>1) {
                                				if(m_Name.equals(m_Store[k])) {
                                					recursive++;
                                				}else {
                                					
                                					for(int m = 0; m < m_Store.length; m++) {
                                    					if(m%2==0) {
                                    						if(m_Name.equals(m_Store[m])) {
                                    							if(m_Store[m+1].equals("regular")) {
                                    								if(m_Store[k+1].equals("regular")) {
                                    									regularRegulars++;
                                    								}else {
                                    									regularRecursives++;
                                    								}
                                    							}else {
                                    								if(m_Store[k+1].equals("regular")) {
                                    									recursiveRegulars++;
                                    								}else {
                                    									recursiveRecursives++;
                                    								}
                                    							}
                                    						}
                                    					}
                                    				}
                                					
                                				}
                            				}
                            			}
                            		}
                				}
                			}
                		}
            		}
            	}
            }
            
            Coupling coupling = new Coupling();
            
            coupling.setLine(line);
            coupling.setLineNumber(count);
            coupling.setRecursive(recursive);
            coupling.setRecursive_global(recursiveGlobals);
            coupling.setRecursive_recursive(recursiveRecursives);
            coupling.setRecursive_regular(recursiveRegulars);
            coupling.setRegular_recursive(regularRecursives);
            coupling.setRegular_regular(regularRegulars);
            coupling.setRegular_global(regularGlobals);
            
            list.add(coupling);
            
        }
		
        return list;
		
    }
	
    public String finding_methods(String code) {
		
        int count = 0;
        boolean inside_Method=false;
        int inside_Method_count=0;
        int line_Count=0;
        boolean regular=true;
        String m_Store="";
        String m_Name=null;

        String[] lines = code.split("\\r?\\n");
        for (String line : lines) {
            count++;
            String[] sample_line_txt  = line.split("\"");
            
            for (int i=1;i<=sample_line_txt.length;i++) {
        		
            	if(i%2==1) {
            		
            		String test =sample_line_txt[i-1];
            		
        			String str= test.replaceAll("\\s+","_");
        			
        			String rgx = "public_|protected_|private_"; 
            		Pattern pattern = Pattern.compile(rgx, Pattern.CASE_INSENSITIVE);
            		Matcher matcher = pattern.matcher(str);
            		while (matcher.find())
            		{
            			String txt_line1= test.replaceAll("\\s+","");
            			String txt_line2= txt_line1.replaceAll("\\)","@");
            			String txt_line3= txt_line2.replaceAll("\\{","-.X");
            			
            			String rgx1 = "@-.X"; 
                		Pattern ptrn1 = Pattern.compile(rgx1, Pattern.CASE_INSENSITIVE);
                		Matcher txt_mt1 = ptrn1.matcher(txt_line3);
                		while (txt_mt1.find())
                		{
                			String txt_line4= test.replaceAll("\\(","@@");
                			String[] sample  = txt_line4.split("@@");
                			
                			String txt_line5= sample[0].replaceAll("\\s+","_");
                			String rgx3 = "_boolean_|_byte_|_char_|_double_|_float_|_int_|_long_|_short_|_String_|_void_"; 
                    		Pattern ptrn3 = Pattern.compile(rgx3, Pattern.CASE_INSENSITIVE);
                    		Matcher txt_mt3 = ptrn3.matcher(txt_line5);
                    		while (txt_mt3.find())
                    		{
                    			String[] sample1  = (txt_line5.substring(txt_mt3.end(),txt_line5.length())).split("_");
                    			m_Name = sample1[0];
                    			inside_Method=true;
                    		}
                    		
                		}
            		}
            		
            		if(inside_Method) {
            			line_Count++;

                		String txt_line1= test.replaceAll("\\{","@@");
            			
            			String rgx1 = "@@"; 
                		Pattern ptrn1 = Pattern.compile(rgx1, Pattern.CASE_INSENSITIVE);
                		Matcher txt_mt1 = ptrn1.matcher(txt_line1);
                		while (txt_mt1.find())
                		{
                			inside_Method_count++;
                		}
                		
                		String txt_line2= test.replaceAll("\\}","@@");
            			
            			String rgx2 = "@@"; 
                		Pattern ptrn2 = Pattern.compile(rgx2, Pattern.CASE_INSENSITIVE);
                		Matcher txt_mt2 = ptrn2.matcher(txt_line2);
                		while (txt_mt2.find())
                		{
                			inside_Method_count--;
                		}
                		
                		if(line_Count>1) {
                			
	                		String txt_line3= test.replaceAll("\\s+","_").replaceAll("\\(","@@");
	            			
	            			String rgx3 = "_"+m_Name+"@@|_"+m_Name+"_"; 
	                		Pattern ptrn3 = Pattern.compile(rgx3, Pattern.CASE_INSENSITIVE);
	                		Matcher txt_mt3 = ptrn3.matcher(txt_line3);
	                		while (txt_mt3.find())
	                		{
	                			regular=false;
	                		}
                		}
                		
                		
                		if(inside_Method_count==0) {
                			inside_Method=false;
                			line_Count=0;
                			if(regular) {
                				if(m_Store=="") {
                					m_Store=m_Name+"@regular";
                				}else {
                					m_Store=m_Store+"@"+m_Name+"@regular";
                				}
                			}else {
                				if(m_Store=="") {
                					m_Store=m_Name+"@recursive";
                				}else {
                					m_Store=m_Store+"@"+m_Name+"@recursive";
                				}
                			}
                			m_Name=null;
                			regular=true;
                		}
                		
            		}else {
            			
            			String rgx1 = "boolean|byte|char|double|float|int|long|short|String"; 
                		Pattern ptrn1 = Pattern.compile(rgx1, Pattern.CASE_INSENSITIVE);
                		Matcher txt_mt1 = ptrn1.matcher(test);
                		while (txt_mt1.find())
                		{
                			String rgx2 = ";"; 
                    		Pattern ptrn2 = Pattern.compile(rgx2, Pattern.CASE_INSENSITIVE);
                    		Matcher txt_mt2 = ptrn2.matcher(test);
                    		while (txt_mt2.find())
                    		{
                    			String line_var= test.substring(txt_mt1.end(),txt_mt2.start());
                    			String[] var_arr  = line_var.split("=\\,\\;");
                    			for(int k = 0; k < var_arr.length; k++) {
                    				String[] var_arr1  = line_var.split(",");
                    				for(int m = 0; m < var_arr1.length; m++) {
                    					if(m==0) {
                    						if(m_Store=="") {
                    							m_Store=var_arr1[0]+"@Global";
                    						}else {
                    							m_Store=m_Store+"@"+var_arr1[0]+"@Global";
                    						}
                    					}
                    				}
                                }
                    		}
                		}
            		}
            		
            	}
            }
        }
        
        return m_Store;

    }
	
}
