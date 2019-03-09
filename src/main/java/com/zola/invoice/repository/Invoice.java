package com.zola.invoice.repository;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Invoice implements Serializable {
	private static final long serialVersionUID = 5168169743621793424L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, updatable = false)
	private String invoiceNumber;
	@Column(nullable = false, updatable = false)
	private String poNumber;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dueDate;
	@Column(nullable = false, updatable = false)
	private Long amountCents;
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Long getAmountCents() {
		return amountCents;
	}

	public void setAmountCents(Long amountCents) {
		this.amountCents = amountCents;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public static class InvoiceBuilder {
		private Long id;
		private String invoiceNumber;
		private String poNumber;
		private Date dueDate;
		private Long amountCents;
		private Date createdAt;

		public InvoiceBuilder id(Long id) {
			this.id = id;
			return this;
		}

		public InvoiceBuilder invoiceNumber(String invoiceNumber) {
			this.invoiceNumber = invoiceNumber;
			return this;
		}

		public InvoiceBuilder poNumber(String poNumber) {
			this.poNumber = poNumber;
			return this;
		}

		public InvoiceBuilder dueDate(Date dueDate) {
			this.dueDate = dueDate;
			return this;
		}

		public InvoiceBuilder amountCents(Long amountCents) {
			this.amountCents = amountCents;
			return this;
		}

		public InvoiceBuilder createdAt(Date createdAt) {
			this.createdAt = createdAt;
			return this;
		}

		public Invoice build() {
			Invoice result = new Invoice();
			result.setId(id);
			result.setInvoiceNumber(invoiceNumber);
			result.setPoNumber(poNumber);
			result.setDueDate(dueDate);
			result.setAmountCents(amountCents);
			result.setCreatedAt(createdAt);
			return result;
		}
	}
}
