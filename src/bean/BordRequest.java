package bean;

/**
 *
 * @author miyauchishou
 *
 */
public class BordRequest {
	private String date;
	private String name;
	private String inputType;
	private String limit;

	public BordRequest() {

	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInputType() {
		return inputType;
	}
	public void setInputType(String inputType) {
		this.inputType = inputType;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}

}
