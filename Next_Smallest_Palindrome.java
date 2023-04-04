import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.*;
import java.util.*;
public class Next_Smallest_Palindrome {
    public String solve(String A) 
    {
        if(A.length() == 1)
        {
            return "11";
        }
        int first = 0;
        int middle = A.length()/2;
        int last = A.length();
        String first_string ="";
        String middle_string="";
        String last_string = "";
        if(A.length()%2 == 0 )
        {
            first_string = A.substring(first,middle);
            last_string = A.substring(middle, last);
            return ConvertPalindrome((first_string),(last_string), (A));
        }
        else 
        {
            first_string = A.substring(first,middle);
            middle_string = A.charAt(middle)+"";
            last_string = A.substring(middle+1, last);
            return ConvertPalindrome((first_string),(middle_string),(last_string),(A));
        }
    }
    public String ConvertPalindrome(String a,String b,String c)
    {
        int n = (a+"").length();
        String a_b ="";
        String s_b = "";
        s_b = a+""+reverseString(a+"");
        int result = s_b.compareTo(c);
        String regexStr="^9*$";
        Pattern pattern = Pattern.compile(regexStr);
        Matcher matcher = pattern.matcher(a+b+c);
        if(matcher.matches())
        {
            a_b += "1";
            a = (a+b);
            for(int i=0;i<a.length()-1;i++)
            {
                a_b +="0";
            }
            a_b+="1";
            return a_b;
        }
        if(result<=0)
        {
            return ConvertPalindrome(addStrings(a,"1"),b,c);
        }
        return s_b;
    }
    public String ConvertPalindrome(String a, String b, String c , String d)
    {
        String s_b="";
        int convert = 0;
        String regexStr="^9*$";
        Pattern pattern = Pattern.compile(regexStr);
        Matcher matcher = pattern.matcher(a+b+c);
        int n = (a+"").length();
        if(matcher.matches())
        {
            s_b = "1";
            for(int i=0;i<(a+b).length()-1;i++)
            {
                s_b +="0";
            }
            s_b+="1";
            return s_b;
        }
        s_b = a+b+reverseString(a);
        int result=s_b.compareTo(d);
        if(result<=0)
        {
            return ConvertPalindrome(a,addStrings(b,"1"),c,d);
        }
        return s_b;
    }
    public String reverseString(String input) {
    char[] inputArray = input.toCharArray();
    int left = 0;
    int right = inputArray.length - 1;
    while (left < right) {
        char temp = inputArray[left];
        inputArray[left] = inputArray[right];
        inputArray[right] = temp;
        left++;
        right--;
    }
    return new String(inputArray);
}
public static String addStrings(String num1, String num2) {
    StringBuilder sb = new StringBuilder();
    int carry = 0;
    int i = num1.length() - 1;
    int j = num2.length() - 1;
    while (i >= 0 || j >= 0) {
        int digit1 = i >= 0 ? num1.charAt(i) - '0' : 0;
        int digit2 = j >= 0 ? num2.charAt(j) - '0' : 0;
        int sum = digit1 + digit2 + carry;
        carry = sum / 10;
        int digit = sum % 10;
        sb.append(digit);
        i--;
        j--;
    }
    if (carry != 0) {
        sb.append(carry);
    }
    return sb.reverse().toString();
}    
}

