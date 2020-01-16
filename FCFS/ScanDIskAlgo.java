package com.sid.FCFS;

import java.util.Scanner;

public class ScanDIskAlgo {

		public static void main(String[] args) {
		       int n, queue[],high,c=0,temp,k=0,i;
		       Scanner sc = new Scanner(System.in);
		       System.out.println("Enter queue size: ");
		         n=sc.nextInt();
		queue = new int[n+3];
		        System.out.println("Enter position of head: ");
		        high=sc.nextInt();
		        System.out.println("Enter Seek time:");
		        int s=sc.nextInt();
		queue[0]=high;
		queue[1]=0;
		queue[2]=199;
		        System.out.println("Enter Disk queue for input-output: ");
		        for(i=3;i<(n+3);i++)
		        {    queue[i]=sc.nextInt();
		        }
		        for(i=0;i<(n+3);i++)
		        { 
		 for(int j=i+1;j<(n+3);j++)
		            {  
		  if(queue[i]>queue[j])
		                {   temp=queue[i];
		queue[i]=queue[j];
		queue[j]=temp;
		} 
		} 
		   }
		        for(i=0;i<n;i++)
		        {    if(high==queue[i])
		         {   k=i;
		             break;
		         }
		}
		        if(high<(queue[n-1]/2))
		        {
		 for(i=k;i>0;i--)
		            {   
		c=c+(queue[i]-queue[i-1]);
		            }
		c=c+(queue[k+1]-queue[0]);
		        for(i=(k+1);i<(n+1);i++)
		        { 
		c=c+(queue[i+1]-queue[i]);
		 }
		}
		        if(high>(queue[n-1]/2))
		{
		            for(i=k+1;i<(n+3);i++)
		            {
		c=c+(queue[i]-queue[i-1]);
		            }
		c=c+(queue[n+2]-queue[k-1]);
		                 for(i=(k-1);i>1;i--)
		               {
		c=c+(queue[i]-queue[i-1]);
		                 }
		}
		  System.out.println("Tota head movements: "+c+" cylinders ");
		        int seek_time=s*c;
		        System.out.println("Seek time is: "+seek_time+" ms");
		        sc.close();
		}
		}


