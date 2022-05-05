import java.sql.*;
import java.util.Scanner;

public class MdBb {
    public static void main(String[] args) {
        System.out.println("We Are BACK");

        try{
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world","root","Sattyda1!");
            Statement stmt=con.createStatement();

            Scanner scanner = new Scanner(System.in);

            System.out.println("What are you looking for? \n");

            String input = scanner.nextLine();

            input = input.trim();

            boolean isCountry = false;
            boolean isContinent = false;
            boolean isCity = false;


            if(!isContinent){
                int countryCount = 0;
                ResultSet rs =stmt.executeQuery("select * from country where Continent= '"+ input + "'");
                while(rs.next()){
                    isContinent = true;
                    countryCount++;
                }
                if(isContinent){
                    System.out.println("You searched For Continent Which Has "+ countryCount + " Countries");
                }
            }

            if( !isContinent ){
                ResultSet rs =stmt.executeQuery("select * from country where Name= '"+ input + "'");
                while(rs.next()){
                    isCountry = true;
                    System.out.println("You searched For Country. Code is "+ rs.getString("Code") + " Population is "+ rs.getInt("Population") + " Region is "+ rs.getString("Region") + " Continent is "+ rs.getString("Continent") + ".");
                }
            }

            if( !isContinent && !isCountry){
                ResultSet rs =stmt.executeQuery("select * from city where Name= '"+ input + "'");
                while(rs.next()){
                    isCity = true;
                    System.out.println("You searched For City. Code is "+ rs.getString("CountryCode") + " Population is "+ rs.getInt("Population"));
                }
            }

            if(!isCountry && !isContinent && !isCity){
                System.out.println("Please search something that makes sense");
            }

            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}


/// take user input... if it is continent return number of countries... if it is country name return details of country...
/// if it is city.. return city details... otherwise return null
