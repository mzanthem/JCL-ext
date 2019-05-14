/*
 * Snippet.java Created On 2019年4月8日
 * Copyright(c) 2019 Mazan Inc.
 * ALL Rights Reserved.
 */
package io.github.mzanthem.util;
/**
 * StringUtils
 *
 * @time: 下午9:31:10
 * @author mazan
 * @see org.apache.commons.lang3.StringUtils.java
 */
public class StringUtils {
		// Empty checks
	    //-----------------------------------------------------------------------
	    /**
	     * <p>Checks if a CharSequence is empty ("") or null.</p>
	     *
	     * <pre>
	     * StringUtils.isEmpty(null)      = true
	     * StringUtils.isEmpty("")        = true
	     * StringUtils.isEmpty(" ")       = false
	     * StringUtils.isEmpty("bob")     = false
	     * StringUtils.isEmpty("  bob  ") = false
	     * </pre>
	     *
	     * <p>NOTE: This method changed in Lang version 2.0.
	     * It no longer trims the CharSequence.
	     * That functionality is available in isBlank().</p>
	     *
	     * @param cs  the CharSequence to check, may be null
	     * @return {@code true} if the CharSequence is empty or null
	     * @since 3.0 Changed signature from isEmpty(String) to isEmpty(CharSequence)
	     */
	    public static boolean isEmpty(final CharSequence cs) {
	        return cs == null || cs.length() == 0;
	    }
	
	    /**
	     * <p>Checks if a CharSequence is not empty ("") and not null.</p>
	     *
	     * <pre>
	     * StringUtils.isNotEmpty(null)      = false
	     * StringUtils.isNotEmpty("")        = false
	     * StringUtils.isNotEmpty(" ")       = true
	     * StringUtils.isNotEmpty("bob")     = true
	     * StringUtils.isNotEmpty("  bob  ") = true
	     * </pre>
	     *
	     * @param cs  the CharSequence to check, may be null
	     * @return {@code true} if the CharSequence is not empty and not null
	     * @since 3.0 Changed signature from isNotEmpty(String) to isNotEmpty(CharSequence)
	     */
	    public static boolean isNotEmpty(final CharSequence cs) {
	        return !isEmpty(cs);
	    }
	
	
	    /**
	     * <p>Checks if a CharSequence is empty (""), null or whitespace only.</p>
	     *
	     * <p>Whitespace is defined by {@link Character#isWhitespace(char)}.</p>
	     *
	     * <pre>
	     * StringUtils.isBlank(null)      = true
	     * StringUtils.isBlank("")        = true
	     * StringUtils.isBlank(" ")       = true
	     * StringUtils.isBlank("bob")     = false
	     * StringUtils.isBlank("  bob  ") = false
	     * </pre>
	     *
	     * @param cs  the CharSequence to check, may be null
	     * @return {@code true} if the CharSequence is null, empty or whitespace only
	     * @since 2.0
	     * @since 3.0 Changed signature from isBlank(String) to isBlank(CharSequence)
	     */
	    public static boolean isBlank(final CharSequence cs) {
	        int strLen;
	        if (cs == null || (strLen = cs.length()) == 0) {
	            return true;
	        }
	        for (int i = 0; i < strLen; i++) {
	            if (!Character.isWhitespace(cs.charAt(i))) {
	                return false;
	            }
	        }
	        return true;
	    }
	
	    /**
	     * <p>Checks if a CharSequence is not empty (""), not null and not whitespace only.</p>
	     *
	     * <p>Whitespace is defined by {@link Character#isWhitespace(char)}.</p>
	     *
	     * <pre>
	     * StringUtils.isNotBlank(null)      = false
	     * StringUtils.isNotBlank("")        = false
	     * StringUtils.isNotBlank(" ")       = false
	     * StringUtils.isNotBlank("bob")     = true
	     * StringUtils.isNotBlank("  bob  ") = true
	     * </pre>
	     *
	     * @param cs  the CharSequence to check, may be null
	     * @return {@code true} if the CharSequence is
	     *  not empty and not null and not whitespace only
	     * @since 2.0
	     * @since 3.0 Changed signature from isNotBlank(String) to isNotBlank(CharSequence)
	     */
	    public static boolean isNotBlank(final CharSequence cs) {
	        return !isBlank(cs);
	    }
	
	
	    // Trim
	    //-----------------------------------------------------------------------
	    /**
	     * <p>Removes control characters (char &lt;= 32) from both
	     * ends of this String, handling {@code null} by returning
	     * {@code null}.</p>
	     *
	     * <p>The String is trimmed using {@link String#trim()}.
	     * Trim removes start and end characters &lt;= 32.
	     * To strip whitespace use {@link #strip(String)}.</p>
	     *
	     * <p>To trim your choice of characters, use the
	     * {@link #strip(String, String)} methods.</p>
	     *
	     * <pre>
	     * StringUtils.trim(null)          = null
	     * StringUtils.trim("")            = ""
	     * StringUtils.trim("     ")       = ""
	     * StringUtils.trim("abc")         = "abc"
	     * StringUtils.trim("    abc    ") = "abc"
	     * </pre>
	     *
	     * @param str  the String to be trimmed, may be null
	     * @return the trimmed string, {@code null} if null String input
	     */
	    public static String trim(final String str) {
	        return str == null ? null : str.trim();
	    }
	
}

