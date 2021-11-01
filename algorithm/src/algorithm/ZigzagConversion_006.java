package algorithm;
/*
 * Runtime: 34 ms, faster than 17.30% of Java online submissions for Zigzag Conversion.
 * Memory Usage: 40.1 MB, less than 52.72% of Java online submissions for Zigzag Conversion.
 */
public class ZigzagConversion_006 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "PAYPALISHIRING";
		int numRows = 4;
		String result ="";
		if(numRows == 1) {
			result = s;
		}
		else if(numRows>1) {
			char[][] resultArr = fill(s,numRows);
			
			for(int row = 0; row<resultArr.length; row++) {
				for(int col = 0; col<resultArr[0].length; col++) {
					if(resultArr[row][col] != 0) {
						String con = Character.toString(resultArr[row][col]);
						result = result.concat(con);
					}
				}
			}
		}
		System.out.print(result);
		
	}
    public static char[][] fill(String s, int numRows) {
    	int quot = s.length()/(numRows+(numRows-2));
    	int rest = s.length()%(numRows+(numRows-2));
    	int numCols = rest<=numRows?quot*(numRows-1)+1:quot*(numRows-1)+(rest-numRows);
    	if(rest / numRows >0 ) {
    		numCols++;
    	}
    	char[][] result = new char[numRows][numCols];
        for(int row = 0; row<result.length; row++) {
			for(int col = 0; col<result[0].length; col++) {
				result[row][col] = 0;
			}
		}

        int index = 0;
		for(int col = 0; col<numCols; col++) {
			int c_rest = col%(numRows-1);
			if(c_rest != 0) {
				result[numRows-(c_rest+1)][col] = s.charAt(index);
				index++;
				if(index>=s.length()) {
					return result;
				}
			}else {
				for(int row = 0; row<numRows; row++) {
					result[row][col] = s.charAt(index);
					index++;
					if(index>=s.length()) {
						return result;
					}
				}
			}
		}
        return result;
    }
    
}
