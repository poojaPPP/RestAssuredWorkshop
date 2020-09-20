package seleniumCode;// Java program to swap pair
// of characters of a string

class SwapPairs {

    // Function to swap pair of
    // characters of a string
    public static String swapPairs(String str)
    {

        // Checking if string is null
        // or empty then return str
        if (str == null || str.isEmpty())
            return str;

        int len = str.length();

        // Creating a StringBuffer object with
        // length of the string passed as a parameter
        StringBuffer sb = new StringBuffer(len);

        // Traverse the string and append
        // the character in the StringBuffer
        // object in reverse order
        for (int i = 0; i < len - 1; i += 2) {
            sb.append(str.charAt(i + 1));
            sb.append(str.charAt(i));
        }

        // Checking if the string has
        // odd number of characters
        // then append the last character
        // into StringBuffer object
        if (len % 2 != 0) {
            sb.append(str.charAt(len - 1));
        }

        // Converting the StringBuffer
        // into the string and return
        return sb.toString();
    }

    // Driver Code
    public static void main(String args[])
    {

        // Given String str
        String str = "GeeksForGeeks";

        // Print the result
        System.out.println(swapPairs(str));
    }
}
