package parentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesesFunction {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        
        // Instead of using templist, it will be an empty string
        backtrack(result, "", 0, 0, n);
        
        return result;
    }
    
    private void backtrack(List<String> result, String current, int open, int close, int max){
    	// Always have base case
    	// If current is at the correct length, add it
        if(current.length() == max * 2){
            result.add(current);
            return;
        }
        
        // Open ( should always be first, not more than max
        if(open < max){
            backtrack(result, current + "(", open + 1, close, max);
        }
        
        // Close ) should always be after open
        if(close < open){
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}
