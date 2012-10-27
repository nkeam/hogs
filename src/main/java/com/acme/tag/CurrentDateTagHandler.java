package com.acme.tag;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class CurrentDateTagHandler extends TagSupport {
	private static final long serialVersionUID = -1874236398237569883L;
	@Override 
	public int doStartTag() throws JspException {
        
        try {
            //Get the writer object for output.
            JspWriter out = pageContext.getOut();
 
            //Perform substr operation on string.
            out.println(new Date());
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
