package FruitCount;

import java.util.LinkedList;
import java.util.List;

public class FruitCount {
    public static void main(String[] args) {

        // int[] trees={1,0,1,4,1,4,1,2,3};
        // int[] trees={1,2,3};
        //int[] trees={1,2,2,2,2,2,2,2,1,1,1,1,1,1,2};
          //  int[] trees = {1,1,2,2};
       // int[] trees = {1,2,1};
        // int[] trees={1,1,2,2,2,3,3,3,1};
       // int[] trees = {1, 0, 1, 4, 4, 4, 1, 4, 4, 2, 3};
        int[] trees= {0,1,2,2};
      //  int[] trees = {1,0,1,4,1,4,1,2,3};

        System.out.println(fruitCount(trees));
    }
    public static int fruitCount(int[] trees)
    {
       LinkedList<Integer> result = new LinkedList<Integer>();

       int firstElement=-1;
       int secondElement=-1;
       int maxCount = -1;
       int index=-1;
        List l1;
       for(int i:trees)
       {
           if(result.contains(i))   result.add(i);

           if(result.size()==0) { // inserting first element to array
               result.add(i);
               firstElement=i;

           }

           if((!result.contains(i))&&(secondElement==-1)) { // inserting second number
               result.add(i);
               secondElement=i;
           }
           if((!result.contains(i))&&(secondElement!=-1)) { // third number is found, we should keep most recent element and remove the other element
             if(secondElement!=(result.get(result.size()-1)))
               {
                   firstElement=secondElement;
                   secondElement=result.get(result.size()-1);
               }
               maxCount=maxCount>result.size()?maxCount:result.size();
               index = result.lastIndexOf(firstElement);
               l1= result.subList(index+1,result.size());
               result = new LinkedList<Integer>(l1);
               result.add(i);
               firstElement=secondElement;
               secondElement=i;
           }
       }
       // System.out.println(result);
        maxCount=maxCount>result.size()?maxCount:result.size();
      return maxCount;
    }
    Thread t = new Thread();
}
