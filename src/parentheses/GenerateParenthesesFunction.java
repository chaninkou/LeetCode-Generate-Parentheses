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
        
        // Open ( should always be first, no more than max
        if(open < max){
        	// After this is done, it will go to next if statement
            backtrack(result, current + "(", open + 1, close, max);
        }
        
        // Close ) should always be after open
        // Close can't than be more than open
        if(close < open){
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
    
    public List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<>();
        
        dfs(result, 0, 0, 0, n, new StringBuilder(""));
        
        return result;
    }
    
    private void dfs(List<String> result, int left, int right, int open, int n, StringBuilder sb){
    	// Don't run the code at the bottom if open is negative
        if(open < 0){
            return;
        }
        
        // Base case, left and right should be the same length of n, and open should be 0
        if(left == n && right == n && open == 0){
            result.add(sb.toString());
            return;
        }
        
        // Save the previous length so we could use it to remove later
        int previousLen = sb.length();
        
        // left will make open + 1
        if(left < n){
            sb.append('(');
            
            dfs(result, left + 1, right, open + 1, n, sb);
            
            // After finished, use the length to remove
            sb.setLength(previousLen);
        }
        
        // right will make open = open - 1
        if(right < n){
            sb.append(')');
            
            dfs(result, left, right + 1, open - 1, n, sb);
            sb.setLength(previousLen);
        }
    }
}
