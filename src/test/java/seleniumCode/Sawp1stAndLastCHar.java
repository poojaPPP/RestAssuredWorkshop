package seleniumCode;

public class Sawp1stAndLastCHar {

    // Java program for the above approach

        public static String
        swapFirstAndLast(String str)
        {
            // Check if the string has only
            // one character then return
            // the string
            if (str.length() < 2)
                return str;

            // Concatenate last character
            // and first character between
            // middle characters of string
            return (str.substring(str.length() - 1)
                    + str.substring(1, str.length() - 1)
                    + str.substring(0, 1));
        }

        // Driver Code
        public static void
        main(String args[])
        {
            // Given String str
            String str = "GeeksForGeeks";

            // Function Call
            System.out.println(
                    swapFirstAndLast(str));
        }


}
