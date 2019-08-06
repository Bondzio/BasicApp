package com.example.basicapp.utility;

public class SpecialCharacterReplacement {

    public static String replaceSpecialCharacters(String original)
    {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < original.length(); i++)
        {
            char c = original.charAt(i);

            switch (c)
            {
                case 'ä': sb.append("ae"); break;
                case 'ö': sb.append("oe"); break;
                case 'ü': sb.append("ue"); break;
                case 'ß': sb.append("ss"); break;
                default: sb.append(c); break;
            }
        }

        return sb.toString();
    }

}
