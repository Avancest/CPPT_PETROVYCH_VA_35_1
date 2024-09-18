import java.io.*;
import java.util.Scanner;

public class Lab_1
{

  public static void main(String[] args) throws FileNotFoundException
  {
      int nRows;
      char[][] arr;
      String filler="";
      Scanner in = new Scanner(System.in);
      File dataFile = new File("MyFile.txt");
      PrintWriter fout = new PrintWriter(dataFile);
      
      System.out.print("Введіть розмір квадратної матриці: ");
      nRows = (int)in.nextInt();
      in.nextLine();
      arr = new char[nRows][];
      for(int i = 0; i < nRows/2; i++)
      {
          arr[i]= new char[i+1];
      }
      for(int i = nRows/2; i < nRows; i++)
      {
          arr[i]= new char[i+1];
      }
       
      boolean inputFlag = false;
      while (!inputFlag)
      {
        System.out.print("\nВведіть символ-заповнювач: ");
        filler = in.nextLine();
        if (filler.length() != 1)
        {
          inputFlag=false;
          System.out.print("\nНе введено символ заповнювач");
        }
        
        else 
        {
          inputFlag=true;
        }
      }    
      for(int i = 0; i <  nRows/2; i++) {
          for(int j = 0; j < i+1; j++) {
                  arr[i][j] = (char) filler.codePointAt(0);
                  System.out.print(arr[i][j] + " ");
                  fout.print(arr[i][j] + " ");
          }
         System.out.print("\n");
        fout.print("\n");
      }
              for(int i = nRows/2; i <  nRows; i++) {
                for(int j = 0; j < nRows/2; j++) {
                      System.out.print(" " + " ");
                      fout.print(" " + " ");
            }
              for(int j = 0; j < i+1-nRows/2; j++) {
                          arr[i][j] = (char) filler.codePointAt(0);
                          System.out.print(arr[i][j] + " ");
                          fout.print(arr[i][j] + " ");       
              }                
              System.out.print("\n");
            fout.print("\n");
        }
              
      fout.flush();
      fout.close();  
  }
}