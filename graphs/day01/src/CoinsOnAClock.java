import java.util.List;
import java.util.ArrayList;


public class CoinsOnAClock {

    public static List<char[]> coinsOnAClock(int pennies, int nickels, int dimes, int hoursInDay) {
        // TODO
        List<char[]> result = new ArrayList<>();
        char[] current = new char[hoursInDay];

        coinsOnAClockHelper(pennies,  nickels,  dimes,current,0,result);
        System.out.println(result.get(2));
        return result;
    }

    public static int checkI(int i, int hoursInDay){
        i = i%hoursInDay;
        if(i<0) i += hoursInDay;

        return i;
    }

    public static void coinsOnAClockHelper(int pennies, int nickels, int dimes, char[] current, int i, List<char[]> result){

            i = checkI(i, current.length);

            if(pennies!=0){
                current[i] = 'p';
                pennies--;
                i+=1;
                i=checkI(i,current.length);
                System.out.println(new String(current));
                System.out.println(pennies+" p");
                System.out.println(nickels+ " n");
                System.out.println(dimes+" d");
                if(pennies==0 && nickels==0 && dimes==0){
                    char[] copyArr = new char[current.length];
                    System.arraycopy(current, 0, copyArr,0,current.length);
                    result.add((copyArr));
                    System.out.println(new String(current));
                }
                if(!(current[i]=='p' || current[i]=='n' || current[i]=='d')){
                    coinsOnAClockHelper(pennies,nickels,dimes,current,i,result);
                }
                pennies++;
                i--;
                i=checkI(i,current.length);
                current[i] = '.';
            }
            if(nickels!=0){
                current[i] = 'n';
                nickels--;
                i+=5;
                i=checkI(i,current.length);
                System.out.println(new String(current));
                System.out.println(pennies+" p");
                System.out.println(nickels+ " n");
                System.out.println(dimes+" d");
                if(pennies==0 && nickels==0 && dimes==0){
                    char[] copyArr = new char[current.length];
                    System.arraycopy(current, 0, copyArr,0,current.length);
                    result.add((copyArr));
                    System.out.println(new String(current));
                }
                if(!(current[i]=='p' || current[i]=='n' || current[i]=='d')){
                    coinsOnAClockHelper(pennies,nickels,dimes,current,i,result);
                }
                nickels++;
                i-=5;
                i=checkI(i,current.length);
                current[i] = '.';

            }
            if(dimes!=0){
                current[i] = 'd';
                dimes--;
                i+=10;
                i=checkI(i,current.length);
                System.out.println(new String(current));
                System.out.println(pennies+" p");
                System.out.println(nickels+ " n");
                System.out.println(dimes+" d");
                if(pennies==0 && nickels==0 && dimes==0){
                    char[] copyArr = new char[current.length];
                    System.arraycopy(current, 0, copyArr,0,current.length);
                    result.add((copyArr));
                    System.out.println(new String(current));
                }
                if(!(current[i]=='p' || current[i]=='n' || current[i]=='d')){
                    coinsOnAClockHelper(pennies,nickels,dimes,current,i,result);
                }
                dimes++;
                i-=10;
                i=checkI(i,current.length);
                current[i] = '.';
            }


    }
}
