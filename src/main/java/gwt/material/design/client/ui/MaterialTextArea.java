package gwt.material.design.client.ui;

import gwt.material.design.client.custom.CustomIcon;
import gwt.material.design.client.custom.CustomLabel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class MaterialTextArea extends Composite {

	private static MaterialTextAreaUiBinder uiBinder = GWT
			.create(MaterialTextAreaUiBinder.class);

	interface MaterialTextAreaUiBinder extends
			UiBinder<Widget, MaterialTextArea> {
	}

	private String placeholder;
	private String type = "text";
	private String icon = "";
	private boolean isValid = true;
	private String length;
	@UiField
	CustomLabel 
	customLabel;
	@UiField
	Label lblName;
	@UiField
	TextArea txtBox;
	@UiField
	CustomIcon iconPanel;

	public MaterialTextArea() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setInvalid() {
		backToDefault();
		txtBox.getElement().addClassName("invalid");
		isValid = false;
	}

	public void setValid() {
		backToDefault();
		txtBox.getElement().addClassName("valid");
		isValid = true;
	}

	public void backToDefault() {
		txtBox.getElement().removeClassName("valid");
		txtBox.getElement().removeClassName("invalid");
	}

	public String getText() {
		return txtBox.getText();
	}

	public void setText(String text) {
		txtBox.setText(text);
		customLabel.addStyleName("active");

	}
	
	@Override
	protected void onAttach() {
		// TODO Auto-generated method stub
		super.onAttach();
		customLabel.getElement().setAttribute("for", "field");
	}

	public String getPlaceholder() {
		return placeholder;

	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
		lblName.setText(placeholder);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
		txtBox.getElement().setAttribute("type", type);
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
		iconPanel.addStyleName(icon + " prefix");
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
		txtBox.getElement().setAttribute("length", length);
	}

}