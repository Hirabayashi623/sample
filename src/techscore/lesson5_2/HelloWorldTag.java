package techscore.lesson5_2;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class HelloWorldTag implements Tag{
	private Tag parentTag = null;
	private PageContext pageContext = null;

	@Override
	public int doEndTag() throws JspException {
		try {
			pageContext.getOut().print("Hello World");
		} catch (IOException e) {
			e.printStackTrace();
			throw new JspException(e.getMessage());
		}

		return 0;
	}

	@Override
	public int doStartTag() throws JspException {
		return SKIP_BODY;		// ボディ部を評価しない
	}

	@Override
	public Tag getParent() {
		return parentTag;
	}

	@Override
	public void release() {
		// 実装不要
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}

	@Override
	public void setParent(Tag parentTag) {
		this.parentTag = parentTag;
	}

}
