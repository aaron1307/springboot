package com.aaron.exer.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Bean class used to store Feedbackform info, and maintain Hibernate table
 * "feedbackform" Hibernate validation is is used here. Hibernate configuration
 * file located under /WEB-INF/Spring folder
 * 
 * @author Aaron C.
 * @version v0.1
 */
@Entity(name = "feedbackform")
public class FeedbackForm implements Serializable{

	/**
	 * generated serialVersionUID
	 */
	private static final long serialVersionUID = -1916668996204618191L;

	/**
	 * @Fields id : database unique id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private String id;

	/**
	 * @Fields name : customer email
	 */
	@Email(message = "email is not valid")
	@NotEmpty(message = "your email is required")
	@Column(name = "email", length = 20)
	private String email;

	/**
	 * @Fields name : customer name
	 */
	@Size(min = 2, max = 40, message = "name should contain 2 to 40 characters")
	@NotEmpty(message = "your name is required")
	@Column(name = "name", length = 30)
	private String name;

	/**
	 * @Fields name : customer phone, self defined validation "@PhoneNO" is used
	 *         here validation located under package validation
	 */
	@NotEmpty(message = "your phone is required")
	@PhoneNO
	@Column(name = "phone", length = 20)
	private String phone;

	/**
	 * @Fields name : customer selected product name this field is not mapped
	 *         into feedback table, self defined validation "@ProductSelector"
	 *         is used here validation located under package validation
	 */
	@ProductSelector
	@Transient
	private String productName;

	/**
	 * @Fields name : customer selected product id foreign key connected to
	 *         column id on product table, product name and id are stored
	 *         separately instead of using bean Product, this is because this
	 *         value is passed to controller from options of <select></select>,
	 *         only String value can be passed through
	 */
	@Column(name = "product")
	private Integer product;

	/**
	 * @Fields name : customer feedback
	 */
	@Size(min = 2, max = 1000, message = "name should contain less than 1000 characters")
	@NotEmpty(message = "feedback may not be empty")
	@Column(name = "feedback", length = 1000)
	private String feedback;

	/**
	 * @Fields name : uuid of the feedback form, generated using UUIDUtil
	 *         utility class, here 16 length uuid is generated
	 */
	@Column(name = "uuid", length = 30)
	private String uuid;

	/**
	 * @Fields name : timestamp of the feedback form, generated when feedback is
	 *         created, and CalendarUtil is used to generate timestamp here
	 */
	@Column(name = "timestamp", length = 30)
	private String timestamp;

	/**
	 * @Title: FeedbackForm constructor @Description: values of uuid and
	 *         timestamp are set during instance creation @param: @throws
	 */
	public FeedbackForm() {
		uuid = UUIDUtil.id(16);
		timestamp = CalendarUtil.getCurrentDate();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getProductName() {
		return productName;
	}

	/**
	 * @Title: setProductName 
	 * @Description: string is passed through to
	 *         productName using format of "1:XXX". "1" means the id of the
	 *         product whihc is used to store in the db; 
	 *         "XXX" means the name of
	 *         the product which is used to send email later. For efficiency
	 *         reasons no further db query select is needed here. 
	 *         @param:
	 *         productName @return: void 
	 *         @throws
	 */
	public void setProductName(String productName) {
		String[] vars = productName.split(":");
		this.product = Integer.valueOf(vars[0]);
		this.productName = vars[1];
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getProduct() {
		return product;
	}

	public void setProduct(Integer product) {
		this.product = product;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((phone == null) ? 0 : phone.hashCode());
        result = prime * result + ((productName == null) ? 0 : productName.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof FeedbackForm))
            return false;
        FeedbackForm other = (FeedbackForm) obj;
        if (uuid == null) {
            if (other.uuid != null)
                return false;
        } else if (!uuid.equals(other.uuid))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User [id=" + id + 
        		", name=" + name + 
        		", email=" + email + 
        		", phone=" + phone + 
        		", productName=" + productName + 
        		", UUID=" + uuid + 
        		", timestamp=" + timestamp + 
        		", feedback=" + feedback +"]";
    }
}
