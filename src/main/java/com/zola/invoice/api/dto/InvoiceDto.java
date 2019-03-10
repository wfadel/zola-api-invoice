package com.zola.invoice.api.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InvoiceDto implements Serializable {
	private static final long serialVersionUID = 3040125111929707622L;

	private Long id;
	@NotNull
	@JsonProperty("invoice_number")
	private String invoiceNumber;
	@NotNull
	@JsonProperty("po_number")
	private String poNumber;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull
	@JsonProperty("due_date")
	private Date dueDate;
	@NotNull
	@JsonProperty("amount_cents")
	private Long amountCents;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonProperty("created_at")
	private Date createdAt;

	private InvoiceDto() {

	}

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

	public static class InvoiceDtoBuilder {
		private Long id;
		private String invoiceNumber;
		private String poNumber;
		private Date dueDate;
		private Long amountCents;
		private Date createdAt;

		public InvoiceDtoBuilder id(Long id) {
			this.id = id;
			return this;
		}

		public InvoiceDtoBuilder invoiceNumber(String invoiceNumber) {
			this.invoiceNumber = invoiceNumber;
			return this;
		}

		public InvoiceDtoBuilder poNumber(String poNumber) {
			this.poNumber = poNumber;
			return this;
		}

		public InvoiceDtoBuilder dueDate(Date dueDate) {
			this.dueDate = dueDate;
			return this;
		}

		public InvoiceDtoBuilder amountCents(Long amountCents) {
			this.amountCents = amountCents;
			return this;
		}

		public InvoiceDtoBuilder createdAt(Date createdAt) {
			this.createdAt = createdAt;
			return this;
		}

		public InvoiceDto build() {
			InvoiceDto result = new InvoiceDto();
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
