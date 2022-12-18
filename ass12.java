import java.io.Serializable;
import java.util.*;
import java.io.*;


class student implements Serializable
{
   public String first_name;
   public String last_name;
   public int roll_number;
   public float cpi;
   public int age;

    public student(String first_name, String last_name, int roll_number , float cpi, int age)
    {
        this.first_name = first_name;
        this.last_name = last_name;
        this.roll_number = roll_number;
        this.cpi = cpi;
        this.age = age;
    }

}

public class ass12 {

     static  ArrayList<student> satkash = new ArrayList();
    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int students_size = scn.nextInt();

        for(int i=0;i< students_size;i++)
        {
            scn.nextLine();
            System.out.println("Enter first name");
            String first_name = scn.nextLine();
            System.out.println("Enter last name");
            String last_name = scn.nextLine();

            System.out.println("enter roll number");
            int rollnumber = scn.nextInt();
            System.out.println("enter cpi");
            float cpi = scn.nextFloat();
            System.out.println("enter age");
            int age = scn.nextInt();

            student obj = new student(first_name, last_name, rollnumber, cpi, age);

            satkash.add(obj);
        }
        scn.close();

            String filename = "database.ser";

            try {
                // Saving of object in a file
                FileOutputStream file = new FileOutputStream(filename);
                ObjectOutputStream out = new ObjectOutputStream(file);

                // Method for serialization of object

                for (int i = 0; i < students_size; i++)
                {
                    out.writeObject(satkash.get(i));
                }
                

                out.close();
                file.close();

                System.out.println("Object has been serialized");

            }

            catch (IOException ex) {
                System.out.println("IOException is caught");
            }

            ArrayList<student> satkash2 = new ArrayList<>();

            try {
                // Reading the object from a file
                FileInputStream file = new FileInputStream(filename);
                ObjectInputStream in = new ObjectInputStream(file);

                // Method for deserialization of object
                for (int j = 0; j < students_size; j++) {
                    student object = null;
                    object = (student) in.readObject();
                    satkash2.add(object);
                }

                in.close();
                file.close();

                System.out.println("Object has been deserialized ");

            
            
            for(int i=0;i<students_size;i++)
            {
                System.out.println("first name" + satkash2.get(i).first_name);
                System.out.println("first name" + satkash2.get(i).first_name);
                System.out.println("first name" + satkash2.get(i).first_name);
            }
        }

            catch (IOException ex) {
                System.out.println("IOException is caught");
            }

            catch (ClassNotFoundException ex) {
                System.out.println("ClassNotFoundException is caught");
            }




        }
        

    }
    

