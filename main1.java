import java.util.Scanner;
import java.io.File; 
import java.io.FileWriter;  
import java.io.IOException;  
import java.io.FileNotFoundException;   
 
class Movie {
    private String name;
    private int general_ticket;
    private int VIP_ticket;
    private int general_cost;
    private int VIP_cost;
  
    int count=0;

    // to enter movie details by manager
    Movie()
    {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter name of the Movie:");
            this.name=sc.next();
            System.out.print("Enter no of ticket available for general category:");
            this.general_ticket=sc.nextInt();
            System.out.print("Enter no of ticket available for VIP category:");
            this.VIP_ticket=sc.nextInt();
            System.out.print("Enter cost of general category ticket:");
            this.general_cost=sc.nextInt();
            System.out.print("Enter cost of VIP category ticket:");
            this.VIP_cost=sc.nextInt();
        }
        try {  
            FileWriter fwrite1 = new FileWriter("C:/Users/PATEL SHREYA/OneDrive/Desktop/java/movie_info.txt",true); 
            fwrite1.write("*****************************************\n");
            fwrite1.write("Name of the Movie: "+name+"\n");
            fwrite1.write("Total no of general seat available: "+general_ticket+"\n");
            fwrite1.write("Total no of VIP seat available: "+VIP_ticket+"\n");
            fwrite1.write("cost of general seat: "+general_cost+"\n");
            fwrite1.write("cost of VIP seat: "+VIP_cost+"\n");
            fwrite1.write("*****************************************\n");
            fwrite1.close();   
          
        } catch (IOException e) {  
            System.out.println("Unexpected error occurred");  
            e.printStackTrace();  
            }  
    }
    void setName(String name)
    {
        this.name=name;
    }
    void setGticket(int general_ticket)
    {
        this.general_ticket=general_ticket;
    }
    void setVticket(int VIP_ticket)
    {
        this.VIP_ticket=VIP_ticket;
    }
    void setGcost(int general_cost)
    {
        this.general_cost=general_cost;
    }
    void setVcost(int VIP_cost)
    {
        this.VIP_cost=VIP_cost;
    }
   
    String getName()
    {
        return name;
    }
    int getGticket()
    {
        return general_ticket;
    }
    int getVticket()
    {
        return VIP_ticket;
    }
    int getGcost()
    {
        return general_cost;
    }
    int getVcost()
    {
        return VIP_cost;
    }
  // to view the movie details on the console 
    void view()
    {
        System.out.println();
        System.out.println("Name of the Movie:"+name);
        System.out.println("Total no of general seat:"+general_ticket);
        System.out.println("Total no of VIP seat:"+VIP_ticket);
        System.out.println("cost of general ticket:"+general_cost);
        System.out.println("cost of VIP ticket:"+VIP_cost);
System.out.println();
System.out.println();

    }

    // to store the details of booked ticket by audience in movie_ticket.txt file
    void view(String n,int g,int v,int t)
    {
        
        try {  
        FileWriter fwrite = new FileWriter("C:/Users/PATEL SHREYA/OneDrive/Desktop/java/movie_ticket.txt"); 
        fwrite.write("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=\n");
        fwrite.write("Name of the Movie: "+n+"\n");
        fwrite.write("Total no of general seat: "+g+"\n");
        fwrite.write("Total no of VIP seat: "+v+"\n");
        fwrite.write("Your Total Payment: "+t+"\n");
        fwrite.write("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
        fwrite.close();   

    } catch (IOException e) {  
        System.out.println("Unexpected error occurred");  
        e.printStackTrace();  
        }  
       
       
    }
    
    
}
class main1
{
    public static void main(String args[])
    {
        try (Scanner sc = new Scanner(System.in)) {
            Movie list[]=null;//array of object
      label:
            do
            {
            System.out.println("1.Manager");
            
            System.out.println("2.Audience");
            System.out.println("3.exit");
            System.out.println("Enter your preference:");
            int c=sc.nextInt();
                switch(c)
                {
                case 1:
                            System.out.println("Enter no of movie:");
                            int n=sc.nextInt();
                            list=new Movie[n];
                            for(int i=0;i<list.length;i++)
                            {
                                System.out.println("Enter Movie "+(i+1)+" Information");
                                list[i]=new Movie();
                            }
                break;
                case 2:
                     do
                     {
                         System.out.println("1.View Details:");
                         System.out.println("2.Book Ticket:");
                         System.out.println("3.Get Ticket:");
                         System.out.println("4.exit");
                         System.out.println("Enter your Choice:");
                         int choice=sc.nextInt();
                         switch(choice)
                         {
                             case 1:
                              for(int j=0;j<list.length;j++)
                             {
                                list[j].view(); 
                             }
                              break;
                             case 2:int g,gc,vc,v,t;
                             System.out.print("Enter name of the movie:");
                             String s=sc.next();
                             System.out.print("Enter no of general tickets:");
                             g=sc.nextInt();
                             System.out.print("Enter no of VIP tickets:");
                             v=sc.nextInt();
                             for(int i=0;i<list.length;i++)
                             {
                                 if(list[i].getName().equals(s))
                                 {
                                     gc=list[i].getGcost()*g;
                                     vc=list[i].getVcost()*v;
                                     t=gc+vc;
                                    
                                    list[i].view(s,g,v,t);
                                
                                 }
                             }
                             break;
                             case 3:
                             try {  
                // Create fwrite object of the file to read data  
                                    File fwrite = new File("C:/Users/PATEL SHREYA/OneDrive/Desktop/java/movie_ticket.txt");    
                                    Scanner read = new Scanner(fwrite);  
                                    while (read.hasNextLine()) {  
                                        String data = read.nextLine();  
                                        System.out.println(data);  
                                    }  
                                    read.close();  
                                } catch (FileNotFoundException exception) {  
                                    System.out.println("Unexcpected error occurred!");  
                                    exception.printStackTrace();  
                                }  
                             break;
                             default:System.out.println("Invalid choice");
                             break;
                             case 4: continue label;
                         }
                         }while(true);
                default:System.out.println("Invalid choice");
                case 3:return;
                }
            }while(true);
        }
    }
}