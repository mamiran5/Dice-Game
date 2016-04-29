package diceGame;

import java.util.Comparator;

public class PlayerStatsComparator implements Comparator<String>
{
	@Override
	public int compare(String x, String y)
	{
		String [] info1 = x.split(" ", 3);
		String [] info2 = y.split(" ", 3);
		
		
		double ratio1 = Double.parseDouble(info1[0]);
		double ratio2 = Double.parseDouble(info2[0]);
		
	   if (ratio1 > ratio2)
	   {
	       return -1;
	   }
	   
	   else if (ratio1 < ratio2)
	   {
	       return 1;
	   }
	   
	   else{
		   int played1 = Integer.parseInt(info1[1]);
		   int played2 = Integer.parseInt(info2[1]);
		   
		   if(played1 > played2){
			   return -1;
		   }
		   
		   else if(played1 < played2){
			   return 1;
		   }
		   
		   else{
			   String name1 = info1[2];
			   String name2 = info2[2];
			   
			   if(name1.compareTo(name2) < 0){
				   return -1;
			   }
			   
			   else if(name1.compareTo(name2) > 0){
				   return 1;
			   }
			   
			   else{
				   return 0; // should never happen
			   }
		   }
	   }
	}
}
